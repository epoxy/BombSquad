package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.newdawn.slick.state.StateBasedGame;

public class Game {
	private Player player[];
	private Enemy enemy;
	//private static Game game = null;
	private IBoard gameBoard;
	private final int FIRE_COUNTDOWN = 1000;
	private int sideLength = 11;
	private int amountOfBombs;
	private StateBasedGame sbg;

	public Game(IBoard iB) {
		gameBoard = iB;
		player = new Player[2];
		player[0] = new Player(0, 0, 1);
		player[1] = new Player(10, 10, 2);
		enemy = new Enemy();
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

	public Player getPlayer(int playerIndex) {
		return player[playerIndex];
	}

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

	private void placeFire(int bombX, int bombY) {
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

	private boolean isInbounds(int x, int y) {
		return x >= 0 && x < sideLength && y >= 0 && y < sideLength;
	}

	public IBoard getBoard() {
		return gameBoard;
	}
	public void gameOver(){
		sbg.enterState(2);
	}
	public Enemy getEnemy(){
		return enemy;
	}

	public void moveEnemyRandomly() {
		double rand = Math.random()*4;
				if(rand>=0 && rand<1){
					tryToMoveEnemy(1,0);
				}else if(rand>=1 && rand<2){
					tryToMoveEnemy(0,1);
				}else if(rand>=2 && rand<3){
					tryToMoveEnemy(-1,0);
				}else{
					tryToMoveEnemy(0,-1);
				}		
	}
	private void tryToMoveEnemy(int i, int j) {
		if (gameBoard.getTile(i+enemy.getX(), j+enemy.getY()).canReceivePlayer()) {
			enemy.move(i, j);
		}
	}
}
