package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

/**
 * A class representing a BombTile
 */
public class BombTile implements GameTile {
	public BombTile() {
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

	}

	@Override
	public void performOnEnemy() {
	
		
	}

}