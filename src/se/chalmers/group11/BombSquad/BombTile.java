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
		// TODO l�gg till receivesFire()==true s� att eld p� bomb leder till
		// spr�ngningskedjereaktion
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer(int playerIndex) {
		// TODO Auto-generated method stub
	}
}