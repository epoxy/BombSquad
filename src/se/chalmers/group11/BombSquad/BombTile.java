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
		// TODO l�gg till receivesFire()==true s� att eld p� bomb leder till
		// spr�ngningskedjereaktion
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