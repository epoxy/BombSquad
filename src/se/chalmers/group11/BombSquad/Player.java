package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player {

	private final int BOMB_COUNTDOWN = 3000;
	private int x;
	private int y;
	private int amountOfBombs;
	private int firePower;
	private int firePower2;

	public Player() {
		x = 0;
		y = 0;
		firePower2 = 1;
		amountOfBombs = 1;
		firePower = 5;
	}

	public void placeBomb(final int bombX, final int bombY,
			final int playerIndex) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBoard.getInstance().explodeBomb(bombX, bombY, playerIndex);
				System.out.println("Eld ritas ut");
				// fire
			}
		};
		Timer t = new Timer(BOMB_COUNTDOWN, taskPerformer);
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
}
