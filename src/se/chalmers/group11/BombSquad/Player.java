package se.chalmers.group11.BombSquad;

public class Player {

	private int x = 0;
	private int y = 0;

	public void setPosition(int deltaX, int deltaY) {
		if (x + deltaX >= 0
				&& x + deltaX < GameBoard.getInstance().getSideLength()
				&& y + deltaY >= 0
				&& y + deltaY < GameBoard.getInstance().getSideLength()) {

			GameTile gt = GameBoard.getInstance().getTile(deltaX + x,
					deltaY + y);
			if (gt.recievesPlayer()) {
				x = x + deltaX;
				y = y + deltaY;
				gt.performOnPlayer();
				System.out.println(x + " + " + y);
			}
		}
	}
	
	public int getX() {
		return x;
	}
 
	public int getY() {
		return y;
	}

	public void releaseBomb() {
		new BombTile(x, y);
	}
}
