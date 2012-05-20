package se.chalmers.group11.core;

public class BoardPower implements IBoard {
	private GameTile gameTiles[][];
	private GameTile gameTilestmp[][];
	/**
	 * Generates a board with only powerUps
	 */
	public BoardPower(){
		gameTiles = new GameTile[SIDELENGTH][SIDELENGTH];
		gameTilestmp = new GameTile[SIDELENGTH][SIDELENGTH];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {
				double rand = Math.random();
				if (rand > 0.5) {
					gameTiles[i][j] = TileFactory.getExtraFirePowerTile();
				} else {
					gameTiles[i][j] = TileFactory.getExtraBombsTile();
				}
				
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
		return SIDELENGTH;
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
