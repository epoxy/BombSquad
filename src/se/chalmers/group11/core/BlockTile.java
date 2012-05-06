package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

public class BlockTile implements GameTile {
	
	private int x;
	private int y;

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
	public void performOnPlayer(Player p, StateBasedGame sbg) {

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
