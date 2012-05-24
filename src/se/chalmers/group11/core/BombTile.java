package se.chalmers.group11.core;

/**
 * A class representing a BombTile
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 */
public class BombTile implements GameTile {

	public BombTile() {
		;
	}

	private int playerWhoDetonated;

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

	}

	@Override
	public void performOnEnemy() {

	}

	public int getplayerWhoDetonated() {
		return playerWhoDetonated;
	}

	public void setplayerWhoDetonated(int player) {
		playerWhoDetonated = player;
	}

}