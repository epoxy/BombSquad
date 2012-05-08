package se.chalmers.group11.core;

import java.util.Observable;

import org.newdawn.slick.state.StateBasedGame;

public class IntrusionDetector extends Observable{
	
	 //StateBasedGame sbg
	
	public void someoneWon(int i){//Anropas om någon vann
		setChanged();
		//sbg.enterState(Main.GAMEOVERSTATE);

		notifyObservers(i);
	}
}
