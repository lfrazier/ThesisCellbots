ThesisCellbots
==============

This is the version of [Cellbots](http://code.google.com/p/cellbots/) that I used for my Master's Thesis (Spring 2012). For information on installation and how to use each of the views, see **Instructions** below.

## Changes from regular Cellbots ##
The original code was altered to include a fifth view, `WaveView.java`. This view is the gesture command interface and is mostly made up of code from Robert Nesselrath's [GestureTrainer](http://code.google.com/p/android-gesture-recognition-tool/) application.

## Instructions ##
#### Installation ####
ThesisCellbots has the same hardware requirements as standard Cellbots. Open the project in Eclipse, make any changes necessary and build to the phone. ThesisCellbots has not been tested in the Android Emulator, only on a real device. The package/application information was not changed from the original Cellbots, so any previously installed version of Cellbots (e.g. from the Android Market) will be overwritten by the version you build.

#### Using ThesisCellbots ####
Again, Cellbots usage is almost identical to the standard Cellbots usage. Upon opening the app, the user must select a robot and connect with it. After connecting to the robot, the user can switch between the different control schemes. The major difference is the addition of the gesture-based controls (called Wave in the code). The Wave controls allow the user to record gestures, and then perform them in order to send their names to the robot as commands. Acceptable command names to send are
<ul>
<li>forward</li>
<li>backward</li>
<li>left</li>
<li>right</li>
<li>stop</li>
</ul>
Any other name sent will do nothing.

Each gesture that is recorded is added to a Training Set, which is just a set of gestures. When the app is opened, the training set that is loaded is the most recently used one. The app comes with 4 training sets already defined:
<ul>
<li>default</li>
<li>thesis</li>
<li>thesis2</li>
<li>thesis3</li>

These training sets already have gestures recorded, and will begin recognition immediately upon loading (the training set used in the Spring 2012 study is `thesis3`). To change the training set, one must go to line 40 of `com.cellbots.remote.WaveView` and change the provided string to a name of your choice (either an existing name or a new name).

> `00040         String activeTrainingSet = "thesis3";`

After changing the training set, rebuild the application on the phone. 

Training sets cannot currently be deleted or changed in-app, though the methods to do so exist in `de.dfki.ccaal.gestures.classifier.GestureClassifier` and could be called if needed via a button press, menu option, etc. 

#### Running Experiments ####
The Spring 2012 experiments used the D-Pad view, the Tilt view, and the newly added Wave view (as well as an XBOX 360 controller which was separate from the ThesisCellbots app).

Future experiments might make use of the Joystick view, Voice view, or add new views. 

New views can be added by creating a subclass of `com.cellbots.remote.UiView` and editing `com.cellbots.remote.CellbotRCActivity` and `com.cellbots.directcontrol.CellbotDirectControlActivity` to reflect the new controller's existence. Each UiView subclass has "previous" and "next" control buttons used to switch between views. Be sure to edit these to reflect the insertion of the new controller (a la linked list insertion).

> ex. I added a new view, Wave, between Tilt and DPad.

> `Tilt <--> D-Pad` becomes `Tilt <--> Wave <--> D-Pad`

## Documentation ##
More complete documentation with class hierarchies and method headers (autogenerated with Doxygen) can be found  in `docs/html/index.html`.
