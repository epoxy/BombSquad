package se.chalmers.group11.core;

public class Enemy {
	private int x=5;
	private int y=5;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void move(int deltaX, int deltaY) {
		x+=deltaX;
		y+=deltaY;
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
