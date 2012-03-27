package se.chalmers.group11.BombSquad;

public class EmptyTile implements GameTile{

	public boolean recievesPlayer(Player p) {
		return true;
	}

	@Override
	public void receivesFire() {

	}

}
