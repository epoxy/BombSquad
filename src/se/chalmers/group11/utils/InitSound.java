package se.chalmers.group11.utils;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class InitSound {

	Sound placeBomb = null;

	public InitSound() throws SlickException {

		placeBomb = new Sound("Music/ohyeah.wav");

	}

	public void startPlayBombSound() {

		placeBomb.play();
	}
}
