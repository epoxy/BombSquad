package se.chalmers.group11.BombSquad;

public class BoxTile implements GameTile {

	@Override
	public boolean canReceivePlayer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void performOnPlayer(int playerIndex) {
		// TODO Auto-generated method stub

	}

}
