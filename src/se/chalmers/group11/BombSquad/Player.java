package se.chalmers.group11.BombSquad;

public class Player {

	private int x;
	private int y;

	public Player() {
		x = 0;
		y = 0;
	}

	// public void setPosition(int deltaX, int deltaY) {
	// if (x + deltaX >= 0
	// && x + deltaX < GameBoard.getInstance().getSideLength()
	// && y + deltaY >= 0
	// && y + deltaY < GameBoard.getInstance().getSideLength()) {
	//
	// GameTile gt = GameBoard.getInstance().getTile(deltaX + x,
	// deltaY + y);
	// if (gt.recievesPlayer()) {
	// x = x + deltaX;
	// y = y + deltaY;
	// gt.performOnPlayer();
	// System.out.println(x + " + " + y);
	// }
	// }
	// }
	public void move(int deltaX, int deltaY) {
		x = x + deltaX;
		y = y + deltaY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void releaseBomb() {
		new BombTile(x, y);
		// GameBoard.getInstance().setBomb(new BombTile(x,y)); //TODO set bomb
	}
}
