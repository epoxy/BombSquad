package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player {

	private int x;
	private int y;
	private int amountOfBombs;
	private int firePower;
	private int firePower2;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		firePower2 = 1;
		amountOfBombs = 1;
		firePower = 1;
	}

	public void countDownToExplosion(final int bombX, final int bombY,
			final int playerIndex) {

		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				GameBoard.getInstance().explodeBomb(bombX, bombY, playerIndex);
				System.out.println("Eld ritas ut");
				// fire
			}
		};
		Timer t = new Timer(3000, taskPerformer);
		t.setRepeats(false);
		t.start();
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

	public int getFirePower(int playerIndex) {
		if (playerIndex == 0) {
			return firePower;
		} else {
			return firePower2;
		}
	}

	public void setFirePower(int playerIndex) {
		if (playerIndex == 0) {
			firePower++;
		} else {
			firePower2++;
		}
	}
}
