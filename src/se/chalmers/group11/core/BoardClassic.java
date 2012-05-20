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
 * @author Anton Palmqvist
 * @author HenrikAndersson made compatible with abstract class Board
 */
public class BoardClassic extends Board{
	
/**
 *Generates a board with blocktiles on every other tile
 */
	public BoardClassic() {
		super();
	}
	
	@Override
	public void generateBoard(){
		
		for (int i = 0; i < SIDELENGTH; i++) {
			for (int j = 0; j < SIDELENGTH; j++) {

				if (Math.random() > 0.4) {
					super.setTile(i, j, TileFactory.getBoxTile());
					super.setTmpTile(i, j, TileFactory.getBoxTile());
				} else {
					super.setTile(i, j, TileFactory.getEmptyTile());
					
				}
			}
		}
		for (int i = 1; i < SIDELENGTH - 1; i += 2) {
			for (int j = 1; j < SIDELENGTH - 1; j += 2) {
				super.setTile(i, j, TileFactory.getBlockTile());
			}
		}
		Functions.makeRoomForPlayers(this);
	}
}

