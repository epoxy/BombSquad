package se.chalmers.group11.core;

public class BoardWithoutBlocks implements IBoard {
	private int sideLength = 11;
	private GameTile gameTiles[][];
	private GameTile gameTilestmp[][];

	public BoardWithoutBlocks() {
		gameTilestmp = new GameTile[sideLength][sideLength];
		gameTiles = new GameTile[sideLength][sideLength];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles.length; j++) {
				gameTiles[i][j] = TileFactory.getBoxTile();
				gameTilestmp[i][j] = TileFactory.getBoxTile();
			}
		}
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 2; k++) {
				gameTiles[j][k] = TileFactory.getEmptyTile();
				gameTilestmp[j][k] = TileFactory.getEmptyTile();
			}
		}
		for (int i = 9; i < gameTiles.length; i++) {
			for (int j = 9; j < gameTiles.length; j++) {
				gameTiles[i][j] = TileFactory.getEmptyTile();
				gameTilestmp[i][j] = TileFactory.getEmptyTile();
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
	public GameTile getTileTmp(int x, int y) {

		return gameTilestmp[x][y];
	}

	@Override
	public void setTmpToTile(int x, int y, GameTile tile) {
		gameTilestmp[x][y] = tile;

	}

}
