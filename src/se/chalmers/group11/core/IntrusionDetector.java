package se.chalmers.group11.core;

import java.util.Observable;

public class IntrusionDetector extends Observable{
	public void someoneWon(int i){//Anropas om någon vann
		setChanged();
		notifyObservers(i);
	}
}
