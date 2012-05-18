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
        
A class representing a player in the game. Handels 
the movements of the player. Also handels the maximum 
amount of bombs the player can have putted out at the 
same time. PLayer also keeps count of the fire range, made
by the explosions of the bombs put out by the player. 
Both above mentioned counters are regulated by the amount
of power-ups picked up by the player.
The player also knows if it is player 1 or player 2.
 *
 * @version      
        
1.0 18 May 2012
 * @author          
        
Anton Palmqvist
 */
public class Player {

//	private int x;
//	private int y;
	private Position p;
	private int playerNumber;
	private int amountOfBombs;
	private int firePower;

	/**
	 * Constructor for making a player.
	 * 
	 * @param x startingposition x-wise
	 * @param y startingposition y-wise
	 * @param playerNumber number of the player
	 */
	public Player(int x, int y, int playerNumber) {
//		this.x = x;
//		this.y = y;
		p = new Position(x, y);
		this.playerNumber=playerNumber;
		/*amount of bombs and fire power are set to 1 by default when player is constructed*/
		amountOfBombs = 1;
		firePower = 1;
	}
	
	/**
	 * Method for moving player to a relative position. Is determined by the amount of steps 
	 * x- and y-wise.
	 * 
	 * @param deltaX players new relative position x-wise
	 * @param deltaY players new relative position y-wise
	 */
	public void move(int deltaX, int deltaY) {
//		x = x + deltaX;
//		y = y + deltaY;
		p.setPosition(deltaX, deltaY);
	}
	
	/**
	 * Method for putting a player on an absolute position. Mostly used in 
	 * testing to make movement efficient.
	 * 
	 * @param x players new position x-wise
	 * @param y players new position y-wise
	 */
	public void put(int x, int y){
//		this.x=x;
//		this.y=y;
		p.setAbsolutePosition(x, y);
	}
/**
 * Getter of the x-position
 * 
// * @return players x coordinate
// */
//	public int getX() {
//		return x;
//	}
///**
// * Getter of the y-position
// * 
// * @return players y coordinate
// */
//	public int getY() {
//		return y;
//	}
	public Position getPosition(){
		return p;
	}
/**
 * 
 * @return players amount of bombs
 */
	public int getAmountOfBombs() {
		return amountOfBombs;
	}
/**
 * 
 * @return players amount of firepower
 */
	public int getFirePower() {
		return firePower;
	}
/**
 * 	
 * @return number of the player
 */
	public int getPlayerNumber(){
		return playerNumber;
	}
/**
 * @addFirepower increases the players firepower
 */
	public void addFirePower() {
		firePower++;
		System.out.println("FirePower: " + firePower);
	}
/**
 * @incrementBombs increases players amount of bombs
 */
	public void incrementBombs() {
		amountOfBombs++;
		System.out.println("AmountOfBombs " + amountOfBombs);
	}
/**
 * @decrementBombs decreases players amount of bombs
 */
	public void decrementBombs() {
		amountOfBombs--;
		System.out.println("AmountOfBombs " + amountOfBombs);
	}
}
