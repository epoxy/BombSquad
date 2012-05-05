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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAmountOfBombs() {
		return amountOfBombs;
	}

	public int getFirePower() {
		return firePower;
	}
	public int getPlayerNumber(){
		return playerNumber;
	}

	public void addFirePower() {
		firePower++;
		System.out.println("FirePower: " + firePower);
	}

	public void incrementBombs() {
		amountOfBombs++;
		System.out.println("AmountOfBombs " + amountOfBombs);
	}

	public void decrementBombs() {
		amountOfBombs--;
		System.out.println("AmountOfBombs " + amountOfBombs);
	}
}
