package se.chalmers.group11.utils;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.Event.Tag;
import se.chalmers.group11.eventbus.IEventHandler;

public class InitSound implements IEventHandler{

	Sound placeBomb = null;
	Sound explodeBomb = null;
	
	public InitSound() throws SlickException {

		placeBomb = new Sound("Music/fuse.ogg");
		explodeBomb = new Sound("Music/bomb.ogg");
		EventBus.INSTANCE.register(this);

	}
	

	public void startPlayBombSound() {
		placeBomb.play();
	}


	@Override
	public void onEvent(Event evt) {
		if(evt.getTag()==Event.Tag.EXPLODE_BOMB){
			explodeBomb.play();
		}
	}
}
