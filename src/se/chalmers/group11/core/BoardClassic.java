package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class BoardClassic implements IBoard{
	
	private int sideLength = 11;
	private GameTile gameTiles[][];// ändra till private!
	private GameTile gameTilestmp[][];
/**
 * @constructor generates a board with blocktiles on every other tile
 */
	public BoardClassic() {
		gameTilestmp = new GameTile[sideLength][sideLength];
		gameTiles = new GameTile[sideLength][sideLength];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {

				if (Math.random() > 0.8) {
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
 * @return the sideLength of the board
 */
	public int getSideLength() {
		return sideLength;
	}

	public void setToTile(int x, int y, GameTile tile) {
		gameTiles[x][y] = tile;		
	}
	public void setTmpToTile(int x, int y, GameTile tile) {
		gameTilestmp[x][y] = tile;		
	}
	
		
	
}
