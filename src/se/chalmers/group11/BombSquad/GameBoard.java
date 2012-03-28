package se.chalmers.group11.BombSquad;

import java.awt.event.ActionListener;

public class GameBoard {

	private static GameBoard gameBoard = null;
	private int sideLength = 12;
	private GameTile[][] gameTiles;// ändra till praivate!

	private GameBoard() {
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

	public void setBomb(BombTile b) {
		gameTiles[b.getX()][b.getY()] = b;
	}

	public int getSideLength() {
		return sideLength;
	}

}
