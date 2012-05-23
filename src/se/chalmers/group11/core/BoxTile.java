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

	@Override
	public void performOnEnemy() {
		// TODO Auto-generated method stub

	}

}
