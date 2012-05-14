package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

/**
 * A class representing a WaterTile
 */
public class WaterTile implements GameTile {

	public WaterTile() {

	}

	@Override
	public boolean canReceivePlayer() {
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		return true;
	}

	@Override
	public void performOnPlayer(Player p, StateBasedGame sbg) {

	}

}
