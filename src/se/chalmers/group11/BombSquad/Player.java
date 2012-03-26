package se.chalmers.group11.BombSquad;

public class Player {

	private int x;
	private int y;

	public void setPosition(int deltaX, int deltaY) {
		GameTile gt = GameBoard.getInstance().getTile(deltaX + x, deltaY + y);
		gt.recievesPlayer(this);
	}
}
