package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameBoard {

	private Player playerOne;
	private static GameBoard gameBoard = null;
	private int sideLength = 12;
	private GameTile gameTiles[][];// ändra till private!
	private final int BOMB_COUNTDOWN = 3000;

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
//TODO fixa för flera spelare
	public void setPlayerPosition(int deltaX, int deltaY) {
		// int newPositionOfPlayerX = playerOne.getX();
		// int newPositionOfPlayerY = playerOne.getY();
		if (isInbounds(playerOne.getX() + deltaX, playerOne.getY() + deltaY)) {

			if (gameTiles[playerOne.getX() + deltaX][playerOne.getY() + deltaY]
					.canReceivePlayer()) {
				playerOne.move(deltaX, deltaY);
				gameTiles[playerOne.getX()][playerOne.getY()].performOnPlayer();

			}

		}

	}

	public void setBomb() {
		final int bombX = playerOne.getX();
		final int bombY = playerOne.getY();
		gameTiles[bombX][bombY] = new BombTile();
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				explodeBomb(bombX, bombY);
				System.out.println("Eld ritas ut");
				// fire
			}
		};
		Timer t = new Timer(BOMB_COUNTDOWN, taskPerformer);
		t.setRepeats(false);
		t.start();
	}

	public int getSideLength() {
		return sideLength;
	}
	public Player getPlayer(){
		return playerOne;
	}
	
	public int getPlayerX() {

		return playerOne.getX();
	}

	public int getPlayerY() {

		return playerOne.getY();
	}
	public void explodeBomb(int bombX, int bombY){
		int firePower = playerOne.getFirePower();
		gameTiles[bombX][bombY] = new FireTile();
		for(int i=1; i<=firePower; i++){
			if(!gameTiles[bombX][bombY+i].canReceiveFire() || !isInbounds(bombX, bombY+i)){
				break;
			}
			if(gameTiles[bombX][bombY+i] instanceof BoxTile){
				//gameTiles[bombX][bombY+i] = new FireTile();
				//TODO Fixa eld och animation senare
				gameTiles[bombX][bombY+i] = new EmptyTile();
				break;
			}
			gameTiles[bombX][bombY+i] = new FireTile();
		}
		for(int i=1; i<=firePower; i++){
			gameTiles[bombX+i][bombY] = new FireTile();
		}
		for(int i=1; i<=firePower; i++){
			gameTiles[bombX][bombY-i] = new FireTile();
		}
		for(int i=1; i<=firePower; i++){
			gameTiles[bombX-i][bombY] = new FireTile();
		}
	}
	
	private boolean isInbounds(int x, int y){
		return x>= 0 && x < sideLength && y >= 0 && y < sideLength;
	}
}
