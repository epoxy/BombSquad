package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

public class BoxTile implements GameTile {

	private int x;
	private int y;
	
	@Override
	public boolean canReceivePlayer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void performOnPlayer(Player p, StateBasedGame sbg) {
		// TODO Auto-generated method stub

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
