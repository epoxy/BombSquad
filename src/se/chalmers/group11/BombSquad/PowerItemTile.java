package se.chalmers.group11.BombSquad;

public class PowerItemTile implements GameTile {

	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;
	}

	@Override
	public void performOnPlayer(int playerIndex) {
		Player p = GameBoard.getInstance().getPlayer(playerIndex);
		p.setFirePower(playerIndex);
	}

}
