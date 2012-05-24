package se.chalmers.group11.utils;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.Event.Tag;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;

/**
 * A class to handle all the music
 * 
 * @version 1.0 23 may 2012
 * 
 * @author Tomas Selldén
 * @author Anton Palmqvist implemented more tags
 * 
 */
public class InitMusic implements IEventHandler {

	private Music backgroundMusic;
	private Music menuMusic;
	private Music winningMusic;

	public InitMusic() throws SlickException {
		backgroundMusic = new Music("Music/battletheme.ogg");
		menuMusic = new Music("Music/intro.ogg");
		winningMusic = new Music("Music/winning.ogg");
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
		if (evt.getTag() == Event.Tag.MENUMUSIC_STARTER) {
			menuMusic.play();
			menuMusic.loop();
		}
		if (evt.getTag() == Event.Tag.MENUMUSIC_STOPPER) {
			menuMusic.stop();
		}
		if (evt.getTag() == Event.Tag.WINNINGMUSIC_STARTER) {
			winningMusic.play();
		}
	}
}
