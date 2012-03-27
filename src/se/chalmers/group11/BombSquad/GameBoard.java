package se.chalmers.group11.BombSquad;

public class GameBoard {

	private static GameBoard gameBoard = null;

	private GameTile gameTiles[][];

	private GameBoard() {
		gameTiles = new GameTile[12][12];
		for(int i = 0; i<gameTiles.length; i++){
			for (int j = 0; j < gameTiles[i].length; j++) {
				gameTiles[i][j] = new EmptyTile();
				System.out.print(gameTiles[i][j]);//skriver ut vilken tile det är
			}
			gameTiles[1][1] = new BlockTile();
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
}
