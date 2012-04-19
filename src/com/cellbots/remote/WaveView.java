package com.cellbots.remote;

import com.cellbots.R;
import de.dfki.ccaal.gestures.IGestureRecognitionListener;
import de.dfki.ccaal.gestures.IGestureRecognitionService;
import de.dfki.ccaal.gestures.classifier.Distribution;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Toast;

public class WaveView extends UiView {

	private boolean isDrawer = true;

	private static Context mContext;

	private UiEventListener uiEventListener;
	private Activity activity;
	
	IGestureRecognitionService recognitionService;
	String activeTrainingSet = "default";
	double recognitionThreshold;
	

	final IBinder gestureListenerStub = new IGestureRecognitionListener.Stub() {

		//@Override
		public void onGestureLearned(final String gestureName) throws RemoteException {
			activity.runOnUiThread(new Runnable() {
			    public void run() {
			    	Toast.makeText(activity, String.format("Gesture %s learned", gestureName), Toast.LENGTH_SHORT).show();
			    	System.out.println(String.format("Gesture %s learned", gestureName));
			    }
			});
		}

		//@Override
		public void onTrainingSetDeleted(final String trainingSet) throws RemoteException {
			activity.runOnUiThread(new Runnable() {
			    public void run() {
			    	Toast.makeText(activity, String.format("Training set %s deleted", trainingSet), Toast.LENGTH_SHORT).show();
			    	System.err.println(String.format("Training set %s deleted", trainingSet));
			    }
			});
		}

		//@Override
		public void onGestureRecognized(final Distribution distribution) throws RemoteException {
			if (distribution.getBestDistance() < recognitionThreshold) {
				// Send to Roomba
				String cmd = distribution.getBestMatch();
				if (cmd.equals("left")) {
					uiEventListener.onActionRequested(
							UiEventListener.ACTION_LEFT, "");
				} else if (cmd.equals("right")) {
					uiEventListener.onActionRequested(
							UiEventListener.ACTION_RIGHT, "");
				} else if (cmd.equals("forward")) {
					uiEventListener.onActionRequested(
							UiEventListener.ACTION_FORWARD, "");
				} else if (cmd.equals("backward")) {
					uiEventListener.onActionRequested(
							UiEventListener.ACTION_BACKWARD, "");
				} else if (cmd.equals("stop")) {
					uiEventListener.onStopRequested();
				} else {
					
				}
				activity.runOnUiThread(new Runnable() {
				    public void run() {
				    	Toast.makeText(activity, String.format("%s: %f", distribution.getBestMatch(), distribution.getBestDistance()), Toast.LENGTH_LONG).show();
				    	System.out.println(String.format("%s: %f", distribution.getBestMatch(), distribution.getBestDistance()));
				    }
				});
			}
		}
	};

	final ServiceConnection serviceConnection = new ServiceConnection() {

		//@Override
		public void onServiceConnected(ComponentName className, IBinder service) {
			recognitionService = IGestureRecognitionService.Stub.asInterface(service);
			try {
				recognitionService.startClassificationMode(activeTrainingSet);
				recognitionService.registerListener(IGestureRecognitionListener.Stub.asInterface(gestureListenerStub));
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		//@Override
		public void onServiceDisconnected(ComponentName className) {
			recognitionService = null;
		}
	};


	public WaveView(Context context, final UiEventListener eventListener,
			boolean drawer, int width, int height, Activity act) {
		super(context, eventListener);

		mContext = context;

		isDrawer = drawer;
		uiEventListener = eventListener;
		activity = act;

		LayoutParams params = new LayoutParams(width, height);
		setLayoutParams(params);

		LayoutInflater inflate = LayoutInflater.from(context);
		FrameLayout frameLayout = (FrameLayout) inflate
				.inflate(
						R.layout.remote_drawer_with_directional_control_container,
						null);
		addView(frameLayout);

		// Sliding drawer arrow flip for open vs closed
		final Button slidingDrawerButton = (Button) findViewById(R.id.slideHandleButton);
		SlidingDrawer slidingDrawer = (SlidingDrawer) findViewById(R.id.SlidingDrawer);
		slidingDrawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {
			@Override
			public void onDrawerOpened() {
				slidingDrawerButton
						.setBackgroundResource(R.drawable.icon_tray_top_opened);
				slidingDrawerButton.setContentDescription(mContext
						.getString(R.string.close_actions_drawer));
			}
		});
		slidingDrawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {
			@Override
			public void onDrawerClosed() {
				slidingDrawerButton
						.setBackgroundResource(R.drawable.icon_tray_top_closed);
				slidingDrawerButton.setContentDescription(mContext
						.getString(R.string.open_actions_drawer));
			}
		});

		if (!isDrawer) {
			slidingDrawer.setVisibility(View.GONE);
		}

		
		FrameLayout waveControls = (FrameLayout) inflate.inflate(
				R.layout.remote_wave, null);

		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.directionalController_container);
		linearLayout.addView(waveControls);
		
		final EditText thresholdTextField = (EditText) findViewById(R.id.thresholdTextField);
		recognitionThreshold = Double.parseDouble(thresholdTextField.getText().toString());
	
		final EditText gestureTextField = (EditText) findViewById(R.id.gestureTrainTextField);
		
		final Button startTrainButton = (Button) findViewById(R.id.trainButton);
		startTrainButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (recognitionService != null) {
					try {
						if (!recognitionService.isLearning()) {
							startTrainButton.setText("STOP");
							gestureTextField.setEnabled(false);
							recognitionService.startLearnMode(activeTrainingSet, gestureTextField.getText().toString());
						} else {
							startTrainButton.setText("TRAIN");
							gestureTextField.setEnabled(true);
							recognitionService.stopLearnMode();
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		thresholdTextField.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
					recognitionThreshold = Double.parseDouble(thresholdTextField.getText().toString()); 
					Toast.makeText(WaveView.mContext, String.format("%s: %2f", "Threshold", recognitionThreshold), Toast.LENGTH_LONG).show();
					return true;
				}
				return false;
			}
		});
		
		Intent bindIntent = new Intent("de.dfki.ccaal.gestures.GESTURE_RECOGNIZER");
		mContext.bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);
		
		final ImageButton nextControl = (ImageButton) findViewById(R.id.nextControl);
		// TODO (clchen): Replace this with the right resource once we get
		// it.
		nextControl.setImageResource(R.drawable.mode_switch_rocker_right);
		nextControl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				uiEventListener
						.onSwitchInterfaceRequested(UiEventListener.INTERFACE_DPAD);
			}
		});
		final ImageButton previousControl = (ImageButton) findViewById(R.id.previousControl);
		previousControl
				.setImageResource(R.drawable.mode_switch_accelerometer_left);
		previousControl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				uiEventListener
						.onSwitchInterfaceRequested(UiEventListener.INTERFACE_ACCELEROMETER);
			}
		});
	}

}
