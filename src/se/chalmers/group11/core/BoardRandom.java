package se.chalmers.group11.core;

public class BoardRandom implements IBoard{
	
	private GameTile gameTiles[][];
	private GameTile gameTilestmp[][];
/**
 *Generates a board with random placed blocks and boxes 	
 */
	public BoardRandom(){
		gameTiles = new GameTile[SIDELENGTH][SIDELENGTH];
		gameTilestmp = new GameTile[SIDELENGTH][SIDELENGTH];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {
				double rand = Math.random();
				if (rand > 0.5) {
					gameTiles[i][j] = TileFactory.getBoxTile();
					gameTilestmp[i][j] = TileFactory.getBoxTile();
				} else if(0.2 <= rand && rand <= 0.5){
					gameTiles[i][j] = TileFactory.getEmptyTile();
				}
				else{
					gameTiles[i][j] = TileFactory.getBlockTile();
				}
			}
		}
		Functions.makeRoomForPlayers(this);
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
		gameTiles[x][y]= tile;
	}

	@Override
	public GameTile getTileTmp(int x, int y) {
		return gameTilestmp[x][y];
	}

	@Override
	public void setTmpToTile(int x, int y, GameTile emptyTile) {
		gameTilestmp[x][y] = emptyTile;
		
	}
	
}