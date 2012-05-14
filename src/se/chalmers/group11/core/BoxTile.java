package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

/**
 * A class representing a BoxTile
 */
public class BoxTile implements GameTile {

	@Override
	public boolean canReceivePlayer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void performOnPlayer(Player p) {
		// TODO Auto-generated method stub

	}

}
