package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

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
		p.incrementBombs();
	}

}
