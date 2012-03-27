package se.chalmers.group11.BombSquad;

public class Player {

	private int x = 0;
	private int y = 0;

	public void setPosition(int deltaX, int deltaY) {
		GameTile gt = GameBoard.getInstance().getTile(deltaX + x, deltaY + y);
		if (gt.recievesPlayer()){
			x=x+deltaX;
			y=y+deltaY;
			gt.performOnPlayer();
			System.out.println(x + " + " + y);
		}
	}
}
