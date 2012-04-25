package se.chalmers.group11.BombSquad;

public class EmptyTile implements GameTile {
	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;

	}

	@Override
	public void performOnPlayer(int playerIndex) {

	}

	public String toString() {
		return "EmptyTile";
	}

}
