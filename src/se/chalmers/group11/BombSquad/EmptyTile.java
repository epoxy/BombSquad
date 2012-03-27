package se.chalmers.group11.BombSquad;

public class EmptyTile implements GameTile{
	@Override
	public boolean recievesPlayer(Player p) {
		return true;
	}

	@Override
	public void receivesFire() {

	}

}
