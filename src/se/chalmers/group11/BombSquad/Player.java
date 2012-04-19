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

	public Player() {
		x = 0;
		y = 0;
		firePower2 = 3;
		amountOfBombs = 1;
		firePower = 3;
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

	public int getFirePower(int playerindex) {
		if (playerindex == 0) {
			return firePower;
		} else {
			return firePower2;
		}
	}
}
