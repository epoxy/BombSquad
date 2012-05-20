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
		iB.setToTile(0, 0, TileFactory.getEmptyTile());
		iB.setToTile(1, 0, TileFactory.getEmptyTile());
		iB.setToTile(0, 1, TileFactory.getEmptyTile());
		/*The three tmpTiles in the upper left corner are also being set to
		 * EmptyTiles. This is done in case any of the tmpTiles were set to a 
		 * box before and therefore, if not turned to an EmptyTile, could be 
		 * turned into at powerup when blown up*/
		iB.setTmpToTile(0, 0, TileFactory.getEmptyTile());
		iB.setTmpToTile(1, 0, TileFactory.getEmptyTile());
		iB.setTmpToTile(0, 1, TileFactory.getEmptyTile());
		
		/*A randomisation determines which should be the last EmptyTile 
		 * in the L-shape.*/
		double rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			iB.setToTile(2, 0, TileFactory.getEmptyTile());
			iB.setTmpToTile(2, 0, TileFactory.getEmptyTile());
		}
		else{
			iB.setToTile(0, 2, TileFactory.getEmptyTile());
			iB.setTmpToTile(0, 2, TileFactory.getEmptyTile());
		}
		
		/*The three tiles in the lower right corner are being set to
		 * EmptyTiles*/
		iB.setToTile(10, 10, TileFactory.getEmptyTile());
		iB.setToTile(10, 9, TileFactory.getEmptyTile());
		iB.setToTile(9, 10, TileFactory.getEmptyTile());
		
		/*The three tmpTiles in the lower right corner are also being set to
		 * EmptyTiles. This is done in case any of the tmpTiles were set to a 
		 * box before and therefore, if not turned to an EmptyTile, could be 
		 * turned into at powerup when blown up*/
		iB.setTmpToTile(10, 10, TileFactory.getEmptyTile());
		iB.setTmpToTile(10, 9, TileFactory.getEmptyTile());
		iB.setTmpToTile(9, 10, TileFactory.getEmptyTile());
		
		/*A randomisation determines which should be the last EmptyTile 
		 * in the L-shape.*/
		rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			iB.setToTile(8, 10, TileFactory.getEmptyTile());
			iB.setTmpToTile(8, 10, TileFactory.getEmptyTile());
		}
		else{
			iB.setToTile(10, 8, TileFactory.getEmptyTile());
			iB.setTmpToTile(10, 8, TileFactory.getEmptyTile());
		}

	}
}