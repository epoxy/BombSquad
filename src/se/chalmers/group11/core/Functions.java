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
	 * @param iB the board
	 */
	public static void makeRoomForPlayers(Board iB){
		
		/*The three tiles in the upper left corner are being set to
		 * EmptyTiles*/
		iB.setTile(0, 0, TileFactory.getEmptyTile());
		iB.setTile(1, 0, TileFactory.getEmptyTile());
		iB.setTile(0, 1, TileFactory.getEmptyTile());
		/*The three tmpTiles in the upper left corner are being set to
		 * null. This is done in case any of the tmpTiles were set to a 
		 * box before and therefore, if not turned to null, could be 
		 * turned into at powerup when blown up*/
		iB.setTmpTile(0, 0, null);
		iB.setTmpTile(1, 0, null);
		iB.setTmpTile(0, 1, null);
		
		/*A randomisation determines which should be the last EmptyTile 
		 * in the L-shape.*/
		double rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			iB.setTile(2, 0, TileFactory.getEmptyTile());
			iB.setTmpTile(2, 0, null);
		}
		else{
			iB.setTile(0, 2, TileFactory.getEmptyTile());
			iB.setTmpTile(0, 2, null);
		}
		
		/*The three tiles in the lower right corner are being set to
		 * EmptyTiles*/
		iB.setTile(10, 10, TileFactory.getEmptyTile());
		iB.setTile(10, 9, TileFactory.getEmptyTile());
		iB.setTile(9, 10, TileFactory.getEmptyTile());
		
		/*The three tmpTiles in the lower right corner are being set to
		 * null. This is done in case any of the tmpTiles were set to a 
		 * box before and therefore, if not turned to null, could be 
		 * turned into at powerup when blown up*/
		iB.setTmpTile(10, 10, null);
		iB.setTmpTile(10, 9, null);
		iB.setTmpTile(9, 10, null);
		
		/*A randomisation determines which should be the last EmptyTile 
		 * in the L-shape.*/
		rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			iB.setTile(8, 10, TileFactory.getEmptyTile());
			iB.setTmpTile(8, 10, null);
		}
		else{
			iB.setTile(10, 8, TileFactory.getEmptyTile());
			iB.setTmpTile(10, 8, null);
		}

	}
}