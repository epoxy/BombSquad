/*
 * IBoard
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
        
The abstract class used for making boards.
 *
 * @version      
        
1.0 18 May 2012
 * @author Anton Palmqvist
 * @author Henrik Andersson made abstract class instead of interface, extracted the generation of the tiles into a method
 */
public abstract class Board {
	
	private GameTile gameTiles[][];
	private GameTile gameTilestmp[][];
	final int SIDELENGTH=11;
	/**
	 *Generates a board with a specified side length
	 */
		public Board() {
			gameTilestmp = new GameTile[SIDELENGTH][SIDELENGTH];
			gameTiles = new GameTile[SIDELENGTH][SIDELENGTH];
			generateBoard();
		}
		/**
		 * Generates all tiles in a new board
		 */
		public abstract void generateBoard();
		
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
			public int getSideLength() {
				return SIDELENGTH;
			}
		/**
		 * @return the SIDELENGTH of the board
		 */
			public void setTile(int x, int y, GameTile tile) {
				gameTiles[x][y] = tile;		
			}
			public void setTmpTile(int x, int y, GameTile tile) {
				gameTilestmp[x][y] = tile;		
			}
			
		
		

}