package se.chalmers.group11.BombSquad;

public interface GameTile {
	
	public boolean canReceivePlayer();
	
	public boolean canReceiveFire();
	
	public void performOnPlayer();

	}
