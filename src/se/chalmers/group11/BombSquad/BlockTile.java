package se.chalmers.group11.BombSquad;

public class BlockTile implements GameTile {
	@Override
	public boolean canReceivePlayer() {
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		return false;
	}

	@Override
	public void performOnPlayer(int playerIndex) {

	}

}
