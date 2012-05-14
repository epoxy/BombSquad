package se.chalmers.group11.utils;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;

public class InitMusic implements IEventHandler {

	private Music backgroundMusic;

	public InitMusic() throws SlickException {
		backgroundMusic = new Music("Music/kirby.ogg");
		EventBus.INSTANCE.register(this);
	}

	@Override
	public void onEvent(Event evt) {
		if (evt.getTag() == Event.Tag.MUSIC_STARTER) {

			backgroundMusic.play();
			backgroundMusic.loop();

		}
		if (evt.getTag() == Event.Tag.MUSIC_STOPPER) {
			backgroundMusic.stop();
		}
	}
}
