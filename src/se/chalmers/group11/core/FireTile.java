package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;

/**
 * A class representing a FireTile
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 */
public class FireTile implements GameTile {// observable

	public FireTile() {
	}

	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;

	}

	@Override
	public void performOnPlayer(final Player p) {
		EventBus.INSTANCE.publish(new Event(Event.Tag.PLAYER_KILLED, p
				.getPlayerNumber()));
	}

	public void performOnEnemy() {
		EventBus.INSTANCE.publish(new Event(Event.Tag.ENEMY_KILLED));
	}
}
