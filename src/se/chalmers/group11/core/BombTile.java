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
		// TODO l�gg till receivesFire()==true s� att eld p� bomb leder till
		// spr�ngningskedjereaktion
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer(Player p, StateBasedGame sbg) {
		// TODO Auto-generated method stub
	}

}