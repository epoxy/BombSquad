package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;

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
		// TODO lägg till receivesFire()==true så att eld på bomb leder till
		// sprängningskedjereaktion
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer(Player p, StateBasedGame sbg) {
		// TODO Auto-generated method stub
	}

}