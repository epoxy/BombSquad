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
        
The interface used for making different boards.
 *
 * @version      
        
1.0 18 May 2012
 * @author          
        
Anton Palmqvist
 */
public interface IBoard {
	final int SIDELENGTH=11;
	public GameTile getTile(int x, int y);
	public int getSideLength();
	public void setToTile(int x, int y, GameTile tile);
	public GameTile getTileTmp(int x, int y);
	public void setTmpToTile(int x, int y, GameTile emptyTile);
}