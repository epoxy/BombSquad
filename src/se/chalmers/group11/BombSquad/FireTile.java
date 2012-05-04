package se.chalmers.group11.BombSquad;

import org.newdawn.slick.state.StateBasedGame;

import com.sun.org.apache.xml.internal.security.Init;


public class FireTile implements GameTile {
	
	private int x;
	private int y;

	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer(Player p) {
		System.out.println("Player" + (p) + " sucks");

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
