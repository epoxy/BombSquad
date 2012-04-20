package se.chalmers.group11.BombSquad;

public class BombTile implements GameTile {
	public BombTile() {
	}

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
	public void performOnPlayer(int playerIndex) {
		// TODO Auto-generated method stub
	}
}