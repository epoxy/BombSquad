package se.chalmers.group11.BombSquad;

public class BlockTile implements GameTile {
	
	private int x;
	private int y;

	public BlockTile() {
		;
	}

	@Override
	public boolean canReceivePlayer() {
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		return false;
	}

	@Override
	public void performOnPlayer(Player p) {

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
