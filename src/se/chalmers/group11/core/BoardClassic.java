/*
 * BoardClassic
 * 
 * Version 1.0
 *
 * Date 2012-05-15
 * 
 * No rights reserved
 */
package se.chalmers.group11.core;

/**
 *  
        
A class representing a classic board with blocks symmetrically placed with one tile 
between each other. The other tiles are randomized and can either contain a box or be empty.
 *
 * @version
        
1.0 18 May 2012
 * @author          
        
Anton Palmqvist
 */
public class BoardClassic implements IBoard{
	
	/* A class implementation comment can go here. */

	private GameTile gameTiles[][];
	private GameTile gameTilestmp[][];
/**
 *Generates a board with blocktiles on every other tile
 */
	public BoardClassic() {
		gameTilestmp = new GameTile[SIDELENGTH][SIDELENGTH];
		gameTiles = new GameTile[SIDELENGTH][SIDELENGTH];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {

				if (Math.random() > 0.4) {
					gameTiles[i][j] = TileFactory.getBoxTile();
					gameTilestmp[i][j] = TileFactory.getBoxTile();
				} else {
					gameTiles[i][j] = TileFactory.getEmptyTile();
					
				}
			}
		}
		for (int i = 1; i < gameTiles.length - 1; i += 2) {
			for (int j = 1; j < gameTiles[i].length - 1; j += 2) {
				gameTiles[i][j] = TileFactory.getBlockTile();
			}
		}
		Functions.makeRoomForPlayers(this);
	}
/**
 * @return the tile on that position
 * @param int x the x coordinate in board array
 * @param int y the y coordinate in board array
 */
	public GameTile getTile(int x, int y) {
		return gameTiles[x][y];
	}
	
	public GameTile getTileTmp(int x, int y) {
		return gameTilestmp[x][y];
	}
/**
 * @return the SIDELENGTH of the board
 */
	public void setToTile(int x, int y, GameTile tile) {
		gameTiles[x][y] = tile;		
	}
	public void setTmpToTile(int x, int y, GameTile tile) {
		gameTilestmp[x][y] = tile;		
	}
	@Override
	public int getSideLength() {
		return SIDELENGTH;
	}
}
