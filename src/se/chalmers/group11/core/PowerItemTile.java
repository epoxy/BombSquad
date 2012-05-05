package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

public class PowerItemTile implements GameTile {

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
		
		p.addFirePower();
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
