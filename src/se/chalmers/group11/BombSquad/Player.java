package se.chalmers.group11.BombSquad;


public class Player {

	private int x;
	private int y;
	private int amountOfBombs;
	private int firePower;



	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		amountOfBombs = 1;
		firePower = 1;
	}


	

	public void move(int deltaX, int deltaY) {
		x = x + deltaX;
		y = y + deltaY;
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

	public void addFirePower() {
	firePower ++;
	System.out.println("FirePower: " + firePower);
	}

	}

