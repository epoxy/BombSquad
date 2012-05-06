package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.newdawn.slick.state.StateBasedGame;

public class Game {
	private Player player[];
	//private static Game game = null;
	private IBoard gameBoard;
	private final int FIRE_COUNTDOWN = 1000;
	private int sideLength = 11;
	private int amountOfBombs;
	private StateBasedGame sbg;
/**
 * @constructor creates two player start positions and a board
 * @param iB the board
 */
	public Game(IBoard iB) {
		gameBoard = iB;
		player = new Player[2];
		player[0] = new Player(0, 0, 1);
		player[1] = new Player(10, 10, 2);
	}

//	public static synchronized Game getInstance(IBoard iB) {
//		if (game == null) {
//			game = new Game(iB);
//		}
//		return game;
//	}

	/*
	 * public void setPlayerPosition(int deltaX, int deltaY, int playerIndex) {
	 * 
	 * Player p = player[playerIndex]; if( moveIsPossible(p, deltaX, deltaY)){
	 * p.move(deltaX, deltaY); if( this.checkSomething( getTile ){ p.kill } }
	 * 
	 * }
	 */
/**
 * 
 * @param deltaX the x direction the player will take
 * @param deltaY the y direction the player will take
 * @param playerIndex variable representing the two players
 * @setPlayerPosition moves the player
 */
	public void setPlayerPosition(int deltaX, int deltaY, int playerIndex) {
		Player p = player[playerIndex];
		int nextPosX = p.getX() + deltaX;
		int nextPosY = p.getY() + deltaY;

		if (isInbounds(nextPosX, nextPosY)) {

			if (gameBoard.getTile(nextPosX, nextPosY).canReceivePlayer()) {

				p.move(deltaX, deltaY);

				gameBoard.getTile(nextPosX, nextPosY).performOnPlayer(p, sbg);

				// Ny metod
				gameBoard.setToTile(p.getX(), p.getY(),
						TileFactory.getEmptyTile());
			}
		}
	}
/**
 * @setBomb place bombs on the board
 * @param playerIndex variable representing the two players
 */
	public void setBomb(final int playerIndex) {
		amountOfBombs = player[playerIndex].getAmountOfBombs();
		if (amountOfBombs > 0) {
			int bombX = player[playerIndex].getX();
			int bombY = player[playerIndex].getY();
			gameBoard.setToTile(bombX, bombY, TileFactory.getBombTile());
			player[playerIndex].decrementBombs();
			bombCountdown(bombX, bombY, playerIndex);
			// doNothing
		} else if (amountOfBombs < 1) {
			;
		}
	}
/**
 * 
 * @param playerIndex variable representing the two players
 * @return return player
 */
	public Player getPlayer(int playerIndex) {
		return player[playerIndex];
	}
/**
 * 
 * @param bombX x coordinate for placed bomb
 * @param bombY y coordinate for  placed bomb
 * @param playerIndex variable representing the two players
 * @bombCountdown starts bombtimer
 */
	public void bombCountdown(final int bombX, final int bombY,
			final int playerIndex) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				explodeBomb(bombX, bombY, playerIndex);
				System.out.println("Eld ritas ut");
				// fire
			}
		};

		Timer t = new Timer(3000, taskPerformer);

		t.setRepeats(false);
		t.start();
	}
/**
 * 
 * @param bombX x coordinate for placed bomb
 * @param bombY y coordinate for placed bomb
 * @param playerIndex variable representing the two players
 * @explodeBomb checks tiles next to the placed bomb and explodes
 */
	public void explodeBomb(int bombX, int bombY, int playerIndex) {
		int firePower = player[playerIndex].getFirePower();

		placeFire(bombX, bombY);

		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX + i, bombY)) {
				if (gameBoard.getTile(bombX + i, bombY) instanceof BoxTile) {

					placeFire(bombX + i, bombY);
					break;
				} else if (gameBoard.getTile(bombX + i, bombY) instanceof BlockTile) {
					break;
				}
				// TODO still doesn«t work good, if you hit the fire with a
				// stone the next tile in the same direction should not be fired
				// up! but it does now a bad solution is to do the instanceof
				// check, we have to find a better solution though

				placeFire(bombX + i, bombY);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX - i, bombY)) {
				if (gameBoard.getTile(bombX - i, bombY) instanceof BoxTile) {

					placeFire(bombX - i, bombY);
					break;
				} else if (gameBoard.getTile(bombX - i, bombY) instanceof BlockTile) {
					break;
				}

				placeFire(bombX - i, bombY);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY + i)) {
				if (gameBoard.getTile(bombX, bombY + i) instanceof BoxTile) {

					placeFire(bombX, bombY + i);
					break;
				} else if (gameBoard.getTile(bombX, bombY + i) instanceof BlockTile) {
					break;
				}

				placeFire(bombX, bombY + i);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY - i)) {
				if (gameBoard.getTile(bombX, bombY - i) instanceof BoxTile) {

					placeFire(bombX, bombY - i);
					break;
				} else if (gameBoard.getTile(bombX, bombY - i) instanceof BlockTile) {

					break;
				}
				placeFire(bombX, bombY - i);
			}

		}
		player[playerIndex].incrementBombs();
	}
/**
 * 
 * @param bombX x coordinate of placed bomb
 * @param bombY y coordinate of placed bomb
 * @placeFire place fire on bomb coordinates
 */
	private void placeFire(int bombX, int bombY) {
		if (gameBoard.getTile(bombX, bombY).canReceiveFire()) {
			gameBoard.setToTile(bombX, bombY, TileFactory.getFireTile());
			setFireTileToEmptyTile(bombX, bombY);
		}

	}
/**
 * 
 * @param bombX x coordinate of placed bomb
 * @param bombY y coordinate of placed bomb
 * @setFireTileToEmptyTile changes the tiles touched by fire to either poweritemtiles or just emptytiles
 */
	private void setFireTileToEmptyTile(final int bombX, final int bombY) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (gameBoard.getTileTmp(bombX, bombY) instanceof BoxTile
						&& Math.random() > 0.3) {
					gameBoard.setToTile(bombX, bombY,
							TileFactory.getPowerItemTile());

					System.out.println("powerItemTile");
				} else if (gameBoard.getTileTmp(bombX, bombY) instanceof BoxTile
						&& Math.random() > 0.5) {
					gameBoard.setToTile(bombX, bombY,
							TileFactory.getExtraBombs());
				} else {
					gameBoard.setToTile(bombX, bombY,
							TileFactory.getEmptyTile());
					System.out.println("emptyTile?");
				}
				gameBoard
						.setTmpToTile(bombX, bombY, TileFactory.getEmptyTile());
				System.out.println("emptyTile?");

				// fire
			}
		};
		Timer t = new Timer(FIRE_COUNTDOWN, taskPerformer);
		t.setRepeats(false);
		t.start();
	}
/**
 * 
 * @param x the x coordinate
 * @param y the y coordinate
 * @return true if it is inside the board limits
 */
	private boolean isInbounds(int x, int y) {
		return x >= 0 && x < sideLength && y >= 0 && y < sideLength;
	}
/**
 * 
 * @return board
 */
	public IBoard getBoard() {
		return gameBoard;
	}
}
