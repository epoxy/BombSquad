package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

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

	}

	public String toString() {
		return "EmptyTile";
	}

	@Override
	public void performOnEnemy() {
		// TODO Auto-generated method stub
		
	}

}
