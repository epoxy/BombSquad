package se.chalmers.group11.BombSquad;

public class FireTile implements GameTile {

	@Override
	public boolean recievesPlayer() {
		return true;
	}

	@Override
	public void receivesFire() {
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer() {
		System.out.println("you suck");
		System.exit(0);

	}

}
