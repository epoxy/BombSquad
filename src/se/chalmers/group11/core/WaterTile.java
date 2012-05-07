package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

public class WaterTile implements GameTile {

	private int x;
	private int y;
	
	public WaterTile(){
		
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
