package se.chalmers.group11.core;

public interface IBoard {
	//private int sideLength;
	public GameTile getTile(int x, int y);
	public int getSideLength();
	public void setToTile(int x, int y, GameTile tile);
	public GameTile getTileTmp(int x, int y);
	public void setTmpToTile(int x, int y, GameTile emptyTile);
	
}