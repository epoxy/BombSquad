package se.chalmers.group11.core;

public class BoardEmpty implements IBoard{
	private int sideLength = 11;
	private GameTile gameTiles[][];
	public BoardEmpty() {
		gameTiles = new GameTile[sideLength][sideLength];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {
				gameTiles[i][j] = TileFactory.getEmptyTile();
			}
		}
		for (int i = 1; i < gameTiles.length - 1; i += 2) {
			for (int j = 1; j < gameTiles[i].length - 1; j += 2) {
				gameTiles[i][j] = TileFactory.getBlockTile();
			}
		}
	}
	@Override
	public GameTile getTile(int x, int y) {
		return gameTiles[x][y];
	}

	@Override
	public int getSideLength() {
		return sideLength;
	}

	@Override
	public void setToTile(int x, int y, GameTile tile) {
		gameTiles[x][y] = tile;
	}
	@Override
	public GameTile getTileTmp(int bombX, int bombY) {
		return null;
	}
	public void setTmpToTile(int bombX, int bombY, GameTile emptyTile) {}

}
