/*
 * LoserKeeper
 * 
 * Version 1.0
 *
 * Date 2012-05-15
 * 
 * No rights reserved
 */


package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;
import se.chalmers.group11.main.Main;

/**
 *  
        
A class made to transefer the game to the GameOver-state, 
showing the results of who won the game.
 *
 * @version      
        
1.0 18 May 2012
 * @author          
        
Anton Palmqvist
 */

public class GameOverHandler implements IEventHandler{
	private StateBasedGame sbg;
	
	/**
	 * Constructor for creating a new LoserKeeper.
	 * 
	 * @param sbg the current statebasedgame
	 */
	public GameOverHandler(StateBasedGame sbg){
		EventBus.INSTANCE.register(this);
		this.sbg=sbg;
	}

	@Override
	public void onEvent(Event evt) {
		if(evt.getTag()==Event.Tag.PLAYER_KILLED){
			sbg.enterState(Main.GAMEOVERSTATE); //Transfers to the GameOverState
		}
	}
}
