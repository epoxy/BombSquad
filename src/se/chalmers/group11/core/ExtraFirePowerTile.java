package se.chalmers.group11.core;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;
import se.chalmers.group11.utils.InitSound;

/**
 * A class representing a ExtraFirePowerTile
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 */
public class ExtraFirePowerTile implements GameTile {

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
		EventBus.INSTANCE.publish(new Event(Event.Tag.MORE_FIRE, 0));
		p.addFirePower();
	}

	@Override
	public void performOnEnemy() {
		;
	}

}
