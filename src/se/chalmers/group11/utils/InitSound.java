package se.chalmers.group11.utils;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.Event.Tag;
import se.chalmers.group11.eventbus.IEventHandler;

/**
 * A class to handle all the sounds, short music clips.
 * 
 * @version 1.0 23 may 2012
 * 
 * @author Tomas Selldén
 * @author Anton Palmqvist implemented more tags
 */
public class InitSound implements IEventHandler {

	Sound placeBomb = null;
	Sound explodeBomb = null;
	Sound playerScream = null;
	Sound enemyScream = null;
	Sound moreFire = null;
	Sound moreBombs = null;

	public InitSound() throws SlickException {

		placeBomb = new Sound("Music/fuse.ogg");
		explodeBomb = new Sound("Music/bomb.ogg");
		playerScream = new Sound("Music/playerScream.ogg");
		enemyScream = new Sound("Music/enemyScream.ogg");
		moreFire = new Sound("Music/ohyeah.wav");
		moreBombs = new Sound("Music/ohyeah.wav");
		EventBus.INSTANCE.register(this);
	}

	@Override
	public void onEvent(Event evt) {
		if (evt.getTag() == Event.Tag.EXPLODE_BOMB) {
			explodeBomb.play();
		}
		if (evt.getTag() == Event.Tag.PLAYER_KILLED) {
			playerScream.play();
		}
		if (evt.getTag() == Event.Tag.ENEMY_KILLED) {
			enemyScream.play();
		}
		if (evt.getTag() == Event.Tag.PLACE_BOMB) {
			placeBomb.play();
		}
		if (evt.getTag() == Event.Tag.MORE_FIRE) {
			moreFire.play();
		}
		if (evt.getTag() == Event.Tag.MORE_BOMBS) {
			moreBombs.play();
		}
	}
}
