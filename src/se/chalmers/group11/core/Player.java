package se.chalmers.group11.core;

public class Player {

	private int x;
	private int y;
	private int playerNumber;
	private int amountOfBombs;
	private int firePower;

	public Player(int x, int y, int playerNumber) {
		this.x = x;
		this.y = y;
		this.playerNumber=playerNumber;
		amountOfBombs = 1;
		firePower = 1;
	}

	public void move(int deltaX, int deltaY) {
		x = x + deltaX;
		y = y + deltaY;
	}
	public void put(int x, int y){
		this.x=x;
		this.y=y;
	}
/**
 * 
 * @return players x coordinate
 */
	public int getX() {
		return x;
	}
/**
 * 
 * @return players y coordinate
 */
	public int getY() {
		return y;
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
