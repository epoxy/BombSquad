package se.chalmers.group11.core;

/**
 * A class representing a WaterTile
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 */
public class WaterTile implements GameTile {

	public WaterTile() {
		;
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
	public void performOnPlayer(Player p) {
		;
	}

	@Override
	public void performOnEnemy() {
		;

	}

}
