package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameBoard {

	private Player player[];
	private static GameBoard gameBoard = null;
	private int sideLength = 11;
	private GameTile gameTiles[][];// ändra till private!

	private final int FIRE_COUNTDOWN = 1000;

	private int bombX;
	private int bombY;

	private GameBoard() {
		player = new Player[2];
		player[0] = new Player();
		player[1] = new Player();
		gameTiles = new GameTile[sideLength][sideLength];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {
				if (Math.random() > 0.8) {
					gameTiles[i][j] = new BoxTile();
				} else {
					gameTiles[i][j] = new EmptyTile();
					System.out.println(gameTiles[i][j]);// skriver ut vilken
														// tile
					// det
					// är
				}
			}
		}

		for (int i = 1; i < gameTiles.length - 1; i += 2) {
			for (int j = 1; j < gameTiles[i].length - 1; j += 2) {
				gameTiles[i][j] = new BlockTile();
			}
		}
	}

	public static synchronized GameBoard getInstance() {
		if (gameBoard == null) {
			gameBoard = new GameBoard();
		}
		return gameBoard;
	}

	public GameTile getTile(int x, int y) {
		return gameTiles[x][y];
	}

	// TODO fixa för flera spelare
	public void setPlayerPosition(int deltaX, int deltaY, int playerIndex) {
		// int newPositionOfPlayerX = playerOne.getX();
		// int newPositionOfPlayerY = playerOne.getY();
		if (isInbounds(player[playerIndex].getX() + deltaX,
				player[playerIndex].getY() + deltaY)) {

			if (gameTiles[player[playerIndex].getX() + deltaX][player[playerIndex]
					.getY() + deltaY].canReceivePlayer()) {
				player[playerIndex].move(deltaX, deltaY);
				gameTiles[player[playerIndex].getX()][player[playerIndex]
						.getY()].performOnPlayer(playerIndex);

			}
		}
	}

	public void setBomb(final int playerIndex) {
		bombX = player[playerIndex].getX();
		bombY = player[playerIndex].getY();
		gameTiles[bombX][bombY] = new BombTile();
		player[playerIndex].countDownToExplosion(bombX, bombY, playerIndex);

	}

	public int getBombX() {
		return bombX;
	}

	public int getBombY() {
		return bombY;
	}

	public int getSideLength() {
		return sideLength;
	}

	public Player getPlayer(int playerIndex) {
		return player[playerIndex];
	}

	public void explodeBomb(int bombX, int bombY, int playerIndex) {
		int firePower = player[playerIndex].getFirePower(playerIndex);
		gameTiles[bombX][bombY] = new FireTile();
		setFireTileToEmptyTile(bombX, bombY);
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX + i, bombY)) {
				if (gameTiles[bombX + i][bombY] instanceof BoxTile) {
					tryToPutOutFire(bombX + i, bombY);
					break;
				} else if (gameTiles[bombX + i][bombY] instanceof BlockTile) {
					break;
				}
				// TODO still doesn«t work good, if you hit the fire with a
				// stone the next tile in the same direction should not be fired
				// up! but it does now a bad solution is to do the instanceof
				// check, we have to find a better solution though

				tryToPutOutFire(bombX + i, bombY);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX - i, bombY)) {
				if (gameTiles[bombX - i][bombY] instanceof BoxTile) {
					tryToPutOutFire(bombX - i, bombY);
					break;
				} else if (gameTiles[bombX - i][bombY] instanceof BlockTile) {
					break;
				}

				tryToPutOutFire(bombX - i, bombY);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY + i)) {
				if (gameTiles[bombX][bombY + i] instanceof BoxTile) {
					tryToPutOutFire(bombX, bombY + i);
					break;
				} else if (gameTiles[bombX][bombY + i] instanceof BlockTile) {
					break;
				}

				tryToPutOutFire(bombX, bombY + i);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY - i)) {
				if (gameTiles[bombX][bombY - i] instanceof BoxTile) {
					tryToPutOutFire(bombX, bombY - i);
					break;
				} else if (gameTiles[bombX][bombY - i] instanceof BlockTile) {
					break;
				}
				tryToPutOutFire(bombX, bombY - i);
			}
		}
	}

	private void tryToPutOutFire(int bombX, int bombY) {

		if (gameTiles[bombX][bombY].canReceiveFire()) {

			gameTiles[bombX][bombY] = new FireTile();
			setFireTileToEmptyTile(bombX, bombY);

		}
	}

	private void setFireTileToEmptyTile(final int bombX, final int bombY) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameTiles[bombX][bombY] = new EmptyTile();
				System.out.println("emptyTile?");
				// fire
			}
		};
		Timer t = new Timer(FIRE_COUNTDOWN, taskPerformer);
		t.setRepeats(false);
		t.start();
	}

	private boolean isInbounds(int x, int y) {
		return x >= 0 && x < sideLength && y >= 0 && y < sideLength;
	}
}
