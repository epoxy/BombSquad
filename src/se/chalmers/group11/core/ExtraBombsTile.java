package se.chalmers.group11.core;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;

/**
 * A class representing an ExtraBombsTile
 */
public class ExtraBombsTile implements GameTile {

	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;
	}

	@Override
	public void performOnPlayer(Player p) {
		EventBus.INSTANCE.publish(new Event(Event.Tag.MORE_BOMBS));
		p.incrementBombs();
	}

	@Override
	public void performOnEnemy() {
		;
	}

}
