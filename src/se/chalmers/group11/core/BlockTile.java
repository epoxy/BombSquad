package se.chalmers.group11.core;

/**
 * A class representing a BlockTile
 */
public class BlockTile implements GameTile {

	public BlockTile() {

	}

	@Override
	public boolean canReceivePlayer() {
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		return false;
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
