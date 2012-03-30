package se.chalmers.group11.BombSquad;

import java.awt.event.ActionListener;

public class GameBoard {

	private Player playerOne;

	private static GameBoard gameBoard = null;
	private int sideLength = 12;
	private GameTile gameTiles[][];// ändra till private!

	private GameBoard() {
		playerOne = new Player();
		gameTiles = new GameTile[sideLength][sideLength];
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[i].length; j++) {
				gameTiles[i][j] = new EmptyTile();
				System.out.println(gameTiles[i][j]);// skriver ut vilken tile
													// det
													// är
			}
			gameTiles[1][1] = new BlockTile();
			gameTiles[2][2] = new FireTile();
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

	public void setPlayerPosition(int deltaX, int deltaY) {
		// int newPositionOfPlayerX = playerOne.getX();
		// int newPositionOfPlayerY = playerOne.getY();
		if (playerOne.getX() + deltaX >= 0
				&& playerOne.getX() + deltaX < sideLength
				&& playerOne.getY() + deltaY >= 0
				&& playerOne.getY() + deltaY < sideLength) {

			if (gameTiles[playerOne.getX() + deltaX][playerOne.getY() + deltaY]
					.recievesPlayer()) {
				playerOne.move(deltaX, deltaY);
				gameTiles[playerOne.getX()][playerOne.getY()].performOnPlayer();

			}

		}

	}

	public void setBomb(BombTile b) {
		gameTiles[b.getX()][b.getY()] = b;
	}

	public int getSideLength() {
		return sideLength;
	}

	public int getPlayerX() {

		return playerOne.getX();
	}

	public int getPlayerY() {

		return playerOne.getY();
	}
}
