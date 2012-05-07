package se.chalmers.group11.core;

public class BoardPower implements IBoard {
	private int sideLength = 11;
	private GameTile gameTiles[][];
	private GameTile gameTilestmp[][];
	
	public BoardPower(){
		gameTiles = new GameTile[sideLength][sideLength];
		gameTilestmp = new GameTile[sideLength][sideLength];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {
				double rand = Math.random();
				if (rand > 0.5) {
					gameTiles[i][j] = TileFactory.getPowerItemTile();
				} else {
					gameTiles[i][j] = TileFactory.getExtraBombs();
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