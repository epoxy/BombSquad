package se.chalmers.group11.BombSquad;

public class ExtraBombsTile implements GameTile {

	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;
	}

	@Override
	public void performOnPlayer(Player p) {
		p.incrementBombs();
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

}
