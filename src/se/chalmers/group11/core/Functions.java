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
        
Class made to contain various functions usable for the game.
 *
 * @version      
        
1.0 15 May 2012
 * @author          
        
Anton Palmqvist
 */	
public class Functions {
	
	/**
	 * Makes sure that the players aren't locked in at the beginning.
	 * @param b the board
	 */
	public static void makeRoomForPlayers(Board b){
		
		/*The three tiles in the upper left corner are being set to
		 * EmptyTiles*/
		b.setTile(0, 0, TileFactory.getEmptyTile());
		b.setTile(1, 0, TileFactory.getEmptyTile());
		b.setTile(0, 1, TileFactory.getEmptyTile());
		/*The three tmpTiles in the upper left corner are being set to
		 * null. This is done in case any of the tmpTiles were set to a 
		 * box before and therefore, if not turned to null, could be 
		 * turned into at powerup when blown up*/
		b.setTmpTile(0, 0, null);
		b.setTmpTile(1, 0, null);
		b.setTmpTile(0, 1, null);
		
		/*A randomisation determines which should be the last EmptyTile 
		 * in the L-shape.*/
		double rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			b.setTile(2, 0, TileFactory.getEmptyTile());
			b.setTmpTile(2, 0, null);
		}
		else{
			b.setTile(0, 2, TileFactory.getEmptyTile());
			b.setTmpTile(0, 2, null);
		}
		
		/*The three tiles in the lower right corner are being set to
		 * EmptyTiles*/
		b.setTile(10, 10, TileFactory.getEmptyTile());
		b.setTile(10, 9, TileFactory.getEmptyTile());
		b.setTile(9, 10, TileFactory.getEmptyTile());
		
		/*The three tmpTiles in the lower right corner are being set to
		 * null. This is done in case any of the tmpTiles were set to a 
		 * box before and therefore, if not turned to null, could be 
		 * turned into at powerup when blown up*/
		b.setTmpTile(10, 10, null);
		b.setTmpTile(10, 9, null);
		b.setTmpTile(9, 10, null);
		
		/*A randomisation determines which should be the last EmptyTile 
		 * in the L-shape.*/
		rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			b.setTile(8, 10, TileFactory.getEmptyTile());
			b.setTmpTile(8, 10, null);
		}
		else{
			b.setTile(10, 8, TileFactory.getEmptyTile());
			b.setTmpTile(10, 8, null);
		}

	}
}