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
public class Enemy {
	
	/*Varibles containing the instance's position. Also sets 
	 * the starting position to coordinates x=6 and y=6.*/
//	private int x;
//	private int y;
	private Position p;
	
	public Enemy(){
		p = new Position(6,6);
	}
	
//	/**
//	 * Getter for the enemys x-coordinate.
//	 * 
//	 * @return the x-position of the enemy
//	 */
//	public int getX() {
//		return x;
//	}
//	
//	/**
//	 * Getter for the enemys y-coordinate.
//	 * 
//	 * @return the y-position of the enemy
//	 */
//	public int getY() {
//		return y;
//	}
	
	public Position getPosition(){
		return p;
	}
	
	/**
	 * Moves the enemy to the new position according to the parameters.
	 * 
	 * @param deltaX the amount of steps the enemy will go x-wise
	 * @param deltaY the amount of steps the enemy will go y-wise
	 */
	public void move(int deltaX, int deltaY) {
//		x+=deltaX;
//		y+=deltaY;
		p.setPosition(deltaX, deltaY);
	}
}
