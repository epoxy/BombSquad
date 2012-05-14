package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

/**
 * A class representing a ExtraFirePowerTile
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
	public void performOnPlayer(Player p, StateBasedGame sbg) {

		p.addFirePower();
	}

}
