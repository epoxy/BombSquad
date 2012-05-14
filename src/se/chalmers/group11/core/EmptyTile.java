package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

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
	public void performOnPlayer(Player p, StateBasedGame sbg) {

	}

	public String toString() {
		return "EmptyTile";
	}

}
