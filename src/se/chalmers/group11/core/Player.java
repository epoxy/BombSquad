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
public class Player implements IMovable{

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
		p = new Position(x, y);
		this.playerNumber=playerNumber;
		/*amount of bombs and fire power are set to 1 by default when player is constructed*/
		amountOfBombs = 1;
		firePower = 1;
	}
	
	@Override
	public void move(int deltaX, int deltaY) {
		p.move(deltaX, deltaY);
	}
	
	@Override
	public void put(int x, int y){
		p.setPosition(x, y);
	}

	@Override
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
