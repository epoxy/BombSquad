package se.chalmers.group11.BombSquad;

public interface IBoard {
	public GameTile getTile(int x, int y);
	public int getSideLength();
	public void setToTile(int x, int y, GameTile tile);
}
