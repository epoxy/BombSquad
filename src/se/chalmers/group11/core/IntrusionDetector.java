package se.chalmers.group11.core;

import java.util.Observable;

public class IntrusionDetector extends Observable{
	public void someoneWon(int i){//Anropas om n�gon vann
		setChanged();
		notifyObservers(i);
	}
}
