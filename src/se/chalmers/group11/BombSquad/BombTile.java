package se.chalmers.group11.BombSquad;

public class BombTile implements GameTile {
	public BombTile() {
	}
	
	private int x;
	private int y;

	@Override
	public boolean canReceivePlayer() {
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		return false;
		// TODO lägg till receivesFire()==true så att eld på bomb leder till
		// sprängningskedjereaktion
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer(Player p) {
		// TODO Auto-generated method stub
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