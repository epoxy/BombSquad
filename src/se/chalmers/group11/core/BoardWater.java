package se.chalmers.group11.core;

public class BoardWater implements IBoard {

	private int sideLength = 11;
	private GameTile gameTiles[][];
	private GameTile gameTilestmp[][];
	
	public BoardWater() {
		gameTilestmp = new GameTile[sideLength][sideLength];
		gameTiles = new GameTile[sideLength][sideLength];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {

				if (Math.random() > 0.5) {
					gameTiles[i][j] = TileFactory.getBoxTile();
					gameTilestmp[i][j] = TileFactory.getBoxTile();
				} else {
					gameTiles[i][j] = TileFactory.getEmptyTile();
					System.out.println(gameTiles[i][j]);// skriver ut vilken tile det �r
													
				}
			}
		}

		for (int i = 1; i < gameTiles.length - 1; i += 2) {
			for (int j = 1; j < gameTiles[i].length - 1; j += 2) {
				gameTiles[i][j] = TileFactory.getWaterTile();
				gameTilestmp[i][j] = TileFactory.getWaterTile();
			}
		}
		Functions.makeRoomForPlayers(this);
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
		gameTiles[x][y]=tile;
		
	}

	@Override
	public GameTile getTileTmp(int x, int y) {
		return gameTilestmp[x][y];
	}

	@Override
	public void setTmpToTile(int x, int y, GameTile emptyTile) {
		gameTilestmp[x][y]=emptyTile;
		
	}

}