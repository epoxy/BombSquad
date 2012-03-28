package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BombTile implements GameTile {
	private int x, y;
	private int aa;

	public BombTile(int x, int y) {
		this.x = x;
		this.y = y;
		GameBoard.getInstance().setBomb(this);

		// GameBoard.gameTiles[b.getX()][b.getY()] = b;
		// GameBoard.getInstance().setTile(this);

		System.out.println("Bomb läggs ut" + x + " " + y);
		int delay = 3000; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Eld ritas ut" + getX() + " " + getY());

				// fire
			}
		};
		Timer t = new Timer(delay, taskPerformer);
		t.setRepeats(false);
		t.start();
	}

	@Override
	public boolean recievesPlayer() {
		return false;
	}

	@Override
	public void receivesFire() {
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer() {
		// TODO Auto-generated method stub

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}