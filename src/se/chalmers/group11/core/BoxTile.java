package se.chalmers.group11.core;

/**
 * A class representing a BoxTile
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
