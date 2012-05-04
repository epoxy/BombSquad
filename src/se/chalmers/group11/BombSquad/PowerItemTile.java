package se.chalmers.group11.BombSquad;

public class PowerItemTile implements GameTile {

	private int x;
	private int y;
	
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
		
		p.setFirePower();
	}

	@Override
	public int getX() {

		return x;
	}

	@Override
	public int getY() {

		return y;
	}

}
