package se.chalmers.group11.BombSquad;

import org.newdawn.slick.state.StateBasedGame;

public interface GameTile {

	public boolean canReceivePlayer();

	public boolean canReceiveFire();

	public void performOnPlayer(Player p, StateBasedGame sbg);
	
	public int getX();
	
	public int getY();

}
