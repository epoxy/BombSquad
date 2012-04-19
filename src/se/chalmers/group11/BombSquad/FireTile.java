package se.chalmers.group11.BombSquad;

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
	public void performOnPlayer(int playerIndex) {
		System.out.println("Player" + (playerIndex+1) + " sucks");
	}

}
