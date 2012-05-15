package se.chalmers.group11.core;

public class BoardEmpty implements IBoard{
	
	private GameTile gameTiles[][];
/**
 * @constructor generates a board without any boxes	
 */
	public BoardEmpty() {
		gameTiles = new GameTile[SIDELENGTH][SIDELENGTH];
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
/**
 * @return the tile on that position
 * @param int x the x coordinate in board array
 * @param int y the y coordinate in board array	
 */
	@Override
	public GameTile getTile(int x, int y) {
		return gameTiles[x][y];
	}
/**
 * @return the SIDELENGTH of the board
 */
	@Override
	public int getSideLength() {
		return SIDELENGTH;
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
