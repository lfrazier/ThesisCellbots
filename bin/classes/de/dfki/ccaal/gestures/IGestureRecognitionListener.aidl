
package de.dfki.ccaal.gestures;
import de.dfki.ccaal.gestures.classifier.Distribution;

interface IGestureRecognitionListener {
	void onGestureRecognized(in Distribution distribution);

	 void onGestureLearned(String gestureName);

	 void onTrainingSetDeleted(String trainingSet);
} 


