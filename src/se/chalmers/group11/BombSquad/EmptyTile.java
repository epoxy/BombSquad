package se.chalmers.group11.BombSquad;

import org.newdawn.slick.state.StateBasedGame;

public class EmptyTile implements GameTile {
	
	private int x;
	private int y;
	
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

	@Override
	public int getX() {
	
		return x;
	}

	@Override
	public int getY() {
		
		return y;
	}

}
