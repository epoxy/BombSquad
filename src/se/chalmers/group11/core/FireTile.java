package se.chalmers.group11.core;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;

import se.chalmers.group11.main.Main;

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
	public void performOnPlayer(Player p, StateBasedGame sbg) {
		System.out.println("Player" + (p.getPlayerNumber()) + " sucks");
		
		sbg.enterState(Main.GAMEOVERSTATE);
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
