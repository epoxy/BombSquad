package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Game {
	private Player player[];
	private static Game game = null;
	private Board gameBoard;
	private final int FIRE_COUNTDOWN = 1000;
	private int bombX;
	private int bombY;
	private int sideLength = 11;
	
	private Game(){
		player = new Player[2];
		player[0] = new Player(0, 0);
		player[1] = new Player(10, 10);
		gameBoard = Board.getInstance();
	}
	public static synchronized Game getInstance() {
		if (game == null) {
			game= new Game();
		}
		return game;
	}
	
	/*
	public void setPlayerPosition(int deltaX, int deltaY, int playerIndex) {
		
		Player p = player[playerIndex];
		if( moveIsPossible(p, deltaX, deltaY)){
			p.move(deltaX, deltaY);
			if( this.checkSomething( getTile ){
				p.kill
			}
		}
		
	}
	
	*/
	
	public void setPlayerPosition(int deltaX, int deltaY, int playerIndex) {

		if (isInbounds(player[playerIndex].getX() + deltaX,
				player[playerIndex].getY() + deltaY)) {

			if (gameBoard.getTile(player[playerIndex].getX() + deltaX, player[playerIndex]
					.getY() + deltaY).canReceivePlayer()){
				
				player[playerIndex].move(deltaX, deltaY);
				
				
				gameBoard.getTile(player[playerIndex].getX() + deltaX, player[playerIndex]
						.getY() + deltaY).performOnPlayer(playerIndex);

				//Ny metod
				gameBoard.setToTile(player[playerIndex].getX(), player[playerIndex]
						.getY(), TileFactory.getEmptyTile());		
			}
		}
	}
	public void setBomb(final int playerIndex) {

		bombX = player[playerIndex].getX();
		bombY = player[playerIndex].getY();
		gameBoard.setToTile(bombX, bombY, TileFactory.getBombTile());	
		player[playerIndex].placeBomb(bombX, bombY, playerIndex);
	}
	public int getBombX() {
		return bombX;
	}

	public int getBombY() {
		return bombY;

	}
	public Player getPlayer(int playerIndex) {
		return player[playerIndex];
	}
	public void explodeBomb(int bombX, int bombY, int playerIndex) {
		int firePower = player[playerIndex].getFirePower(playerIndex);

		gameBoard.setToTile(bombX, bombY, TileFactory.getFireTile());	

		setFireTileToEmptyTile(bombX, bombY);
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX + i, bombY)) {
				if (gameBoard.getTile(bombX + i, bombY) instanceof BoxTile) {

					tryToPutOutFire(bombX + i, bombY);
					break;
				} else if (gameBoard.getTile(bombX + i, bombY) instanceof BlockTile) {
					break;
				}
				// TODO still doesn«t work good, if you hit the fire with a
				// stone the next tile in the same direction should not be fired
				// up! but it does now a bad solution is to do the instanceof
				// check, we have to find a better solution though

			}

			tryToPutOutFire(bombX + i, bombY);
		}

		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX - i, bombY)) {
				if (gameBoard.getTile(bombX - i, bombY) instanceof BoxTile) {

					tryToPutOutFire(bombX - i, bombY);
					break;
				} else if (gameBoard.getTile(bombX - i, bombY) instanceof BlockTile) {
					break;
				}

				tryToPutOutFire(bombX - i, bombY);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY + i)) {
				if (gameBoard.getTile(bombX, bombY + i) instanceof BoxTile) {

					tryToPutOutFire(bombX, bombY + i);
					break;
				} else if (gameBoard.getTile(bombX, bombY + i) instanceof BlockTile) {
					break;
				}

				tryToPutOutFire(bombX, bombY + i);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY - i)) {
				if (gameBoard.getTile(bombX, bombY - i) instanceof BoxTile) {

					tryToPutOutFire(bombX, bombY - i);
					break;
				} else if (gameBoard.getTile(bombX, bombY - i) instanceof BlockTile) {

					break;
				}
				tryToPutOutFire(bombX, bombY - i);
			}

		}
	}
	private void tryToPutOutFire(int bombX, int bombY) {

		if (gameBoard.getTile(bombX, bombY).canReceiveFire()) {
			gameBoard.setToTile(bombX, bombY, TileFactory.getFireTile());
			setFireTileToEmptyTile(bombX, bombY);
		}

	}

	private void setFireTileToEmptyTile(final int bombX, final int bombY) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (gameBoard.getTileTmp(bombX, bombY) instanceof BoxTile
						&& Math.random() > 0.5) {
					gameBoard.setToTile(bombX, bombY, TileFactory.getPowerItemTile());
					gameBoard.setTmpToTile(bombX, bombY, TileFactory.getEmptyTile());
					System.out.println("powerItemTile");
				} else {
					gameBoard.setToTile(bombX, bombY, TileFactory.getEmptyTile());
					System.out.println("emptyTile?");
				}
				gameBoard.setTmpToTile(bombX, bombY, TileFactory.getEmptyTile());
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
	public Board getBoard(){
		return gameBoard;
	}
}
