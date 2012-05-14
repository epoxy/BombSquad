package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;
import se.chalmers.group11.main.Main;

public class LoserKeeper implements IEventHandler{
	private StateBasedGame sb;
	private int loser;
	
	public LoserKeeper(StateBasedGame sb){
		EventBus.INSTANCE.register(this);
		this.sb=sb;
	}

	@Override
	public void onEvent(Event evt) {
		if(evt.getTag()==Event.Tag.FIRE_STARTER){
			System.out.println("Got event" + evt.getValue());
			loser=(int)evt.getValue();
			sb.enterState(Main.GAMEOVERSTATE);
		}
	}

}
