package se.chalmers.group11.core;

/**
 * A class representing an EmptyTile
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
		;
	}

	@Override
	public void performOnEnemy() {
		;
	}

}
