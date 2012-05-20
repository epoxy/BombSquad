/*
 * Player
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
        
Class representing a position in the game.
 *
 * @version      
        
1.0 15 May 2012
 * @author          
        
Anton Palmqvist
 * @author          
        
Henrik Andersson
 */	
public class Position {
	
	// Varibles containing the position.
	private int x;
	private int y;
	
	/**
	 * Constructor for making a position.
	 * 
	 * @param x startingposition x-wise
	 * @param y startingposition y-wise
	 */
	public Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Moves to a new position according to the parameters.
	 * 
	 * @param dX the steps that will be taken x-wise
	 * @param dY the steps that will be taken y-wise
	 */
	public void move(int dX, int dY){
		x=x+dX;
		y=y+dY;
	}
	
	/**
	 * Sets a new position according to the parameters.
	 * 
	 * @param x the x-wise position that will be changed to
	 * @param y the y-wise position that will be changed to
	 */
	public void setPosition(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Getter for the x-coordinate.
	 * 
	 * @return the x-wise position
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Getter for the y-coordinate.
	 * 
	 * @return the y-wise position
	 */
	public int getY(){
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
