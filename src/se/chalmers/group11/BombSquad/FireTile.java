package se.chalmers.group11.BombSquad;

public class FireTile implements GameTile {
	MainMenuState main = new MainMenuState(0);
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
		System.out.println("you suck");
		
		// System.exit(0);

	}

}
