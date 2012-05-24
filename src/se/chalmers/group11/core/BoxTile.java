package se.chalmers.group11.core;

/**
 * A class representing a BoxTile
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 */
public class BoxTile implements GameTile {

	@Override
	public boolean canReceivePlayer() {

		return false;
	}

	@Override
	public boolean canReceiveFire() {

		return true;
	}

	@Override
	public void performOnPlayer(Player p) {
		;

	}

	@Override
	public void performOnEnemy() {
		;

	}

}
