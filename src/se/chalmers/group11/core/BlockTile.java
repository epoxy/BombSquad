package se.chalmers.group11.core;

/**
 * A class representing a BlockTile
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
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
