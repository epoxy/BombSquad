package se.chalmers.group11.BombSquad;

public class GameBoard {

	private static GameBoard gameBoard = null;

	private GameTile gameTiles[][];

	private GameBoard() {
		gameTiles = new GameTile[12][12];
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
}
