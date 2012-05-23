package se.chalmers.group11.core;

/**
 * A class representing an EmptyTile
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 */
public class EmptyTile implements GameTile {

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

	}

	public String toString() {
		return "EmptyTile";
	}

	@Override
	public void performOnEnemy() {
		// TODO Auto-generated method stub

	}

}
