package se.chalmers.group11.BombSquad;

public interface IBoard {
	//private int sideLength;
	public GameTile getTile(int x, int y);
	public int getSideLength();
	public void setToTile(int x, int y, GameTile tile);
	public GameTile getTileTmp(int bombX, int bombY);
	public void setTmpToTile(int bombX, int bombY, GameTile emptyTile);
}