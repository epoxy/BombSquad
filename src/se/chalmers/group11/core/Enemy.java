/*
 * Enemy
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
        
Class representing the enemy in the game. Knows the position 
of the enemy and can move it to new positions.
 *
 * @version      
        
1.0 15 May 2012
 * @author          
        
Anton Palmqvist
 */	
public class Enemy implements IMovable{
	
	private Position p;
	
	/**
	 * Constructor for making an enemy.
	 * 
	 * @param x startingposition x-wise
	 * @param y startingposition y-wise
	 */
	public Enemy(){
		p = new Position(5,5); //Sets the startingposition to x=5 and y=5
	}
	@Override
	public void move(int deltaX, int deltaY) {
		p.move(deltaX, deltaY);
	}

	@Override
	public void put(int x, int y) {
		p.setPosition(x, y);
	}
	@Override
	public Position getPosition(){
		return p;
	}
}
