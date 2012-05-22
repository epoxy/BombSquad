/*
 * Game
 * 
 * Version 1.0
 *
 * Date 2012-05-15
 * 
 * No rights reserved
 */

package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.Event.Tag;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;
import se.chalmers.group11.utils.InitSound;

/**
 *  
        
Class containing all logical operations of the game. 
Handels the current board, the players and the enemy.
The logical operations are movement of the players and enemy, 
the putting out of bombs, the explosion of the bombs and the 
logic of their spreading fire and the elimination of obstacles, 
players and enemy when hit by fire.
 *
 * @version      
        
1.0 15 May 2012
 * @author          
        
ProjectEleven
 */	

public class Game implements IEventHandler {
	private Player player[];
	private Enemy enemy;
	private Board gameBoard;
	private final int FIRE_COUNTDOWN = 1000;
	private int amountOfBombs;
	private StateBasedGame sbg;
	private InitSound sound;

	/**
	 * Creates two player start positions and a board
	 * @param b
	 *            the board
	 * @throws SlickException 
	 */
	public Game(Board b) throws SlickException {
		gameBoard = b;
		player = new Player[2];
		player[0] = new Player(0, 0, 1);
		player[1] = new Player(10, 10, 2);
		enemy = new Enemy();
		sound = new InitSound();
		EventBus.INSTANCE.register(this);
	}
	/**
	 * 
	 * @param deltaX
	 *            the x direction the player will take
	 * @param deltaY
	 *            the y direction the player will take
	 * @param playerNumber
	 *            variable representing the two players
	 * @setPlayerPosition moves the player
	 */
	public void movePlayer(int deltaX, int deltaY, int playerNumber) {
		Player p = player[playerNumber-1];
		int nextPosX = p.getPosition().getX() + deltaX;
		int nextPosY = p.getPosition().getY() + deltaY;
		if (isInbounds(nextPosX, nextPosY)) {

			if (gameBoard.getTile(nextPosX, nextPosY).canReceivePlayer()) {
				p.move(deltaX, deltaY);
				gameBoard.getTile(nextPosX, nextPosY).performOnPlayer(p);

				// Ny metod
				gameBoard.setTile(p.getPosition().getX(), p.getPosition().getY(),
						TileFactory.getEmptyTile());
			}
		}
	}

	/**
	 * @setBomb place bombs on the board
	 * @param playerNumber
	 *            variable representing the two players
	 */
	public void putBomb(final int playerNumber) {
		amountOfBombs = player[playerNumber-1].getAmountOfBombs();
		if (amountOfBombs > 0) {
			int bombX = player[playerNumber-1].getPosition().getX();
			int bombY = player[playerNumber-1].getPosition().getY();
			
			/*Only able to put out bomb if the tile is an EmptyTile*/
			if(gameBoard.getTile(bombX, bombY) instanceof EmptyTile){ 
				gameBoard.setTile(bombX, bombY, TileFactory.getBombTile());
				EventBus.INSTANCE.publish(new Event(Event.Tag.PLACE_BOMB, sound));
				player[playerNumber-1].decrementBombs();
				bombCountdown(bombX, bombY, playerNumber);
			}
		}
	}

	/**
	 * 
	 * @param playerNumber
	 *            variable representing one of the two players
	 * @return return player
	 */
	public Player getPlayer(int playerNumber) {
		return player[playerNumber-1];
	}

	/**
	 * 
	 * @param bombX
	 *            x coordinate for placed bomb
	 * @param bombY
	 *            y coordinate for placed bomb
	 * @param playerNumber
	 *            variable representing the two players
	 * @bombCountdown starts bombtimer
	 */
	public void bombCountdown(final int bombX, final int bombY,
			final int playerNumber) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (gameBoard.getTile(bombX, bombY) instanceof BombTile) {
					explodeBomb(bombX, bombY, playerNumber);
					System.out.println("Eld ritas ut");
					// fire
				}
			}
		};

		Timer t = new Timer(3000, taskPerformer);

		t.setRepeats(false);
		t.start();
	}

	/**
	 * 
	 * @param bombX
	 *            x coordinate for placed bomb
	 * @param bombY
	 *            y coordinate for placed bomb
	 * @param playerNumber
	 *            variable representing the two players
	 * @explodeBomb checks tiles next to the placed bomb and explodes
	 */
	public void explodeBomb(int bombX, int bombY, int playerNumber) {
		int firePower = player[playerNumber-1].getFirePower();
		int playerWhoPutOutTheBomb = playerNumber;
		gameBoard.setTile(bombX, bombY, TileFactory.getFireTile());
		setFireTileToEmptyTile(bombX, bombY);
		EventBus.INSTANCE.publish(new Event(Event.Tag.EXPLODE_BOMB, 4));
		// TODO refakrorisera, samla till en loop
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX + i, bombY)) {
				if (gameBoard.getTile(bombX + i, bombY) instanceof BoxTile) {

					placeFire(bombX + i, bombY, playerWhoPutOutTheBomb);
					break;
				} else if (gameBoard.getTile(bombX + i, bombY) instanceof BlockTile) {
					break;
				}

				placeFire(bombX + i, bombY, playerWhoPutOutTheBomb);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX - i, bombY)) {
				if (gameBoard.getTile(bombX - i, bombY) instanceof BoxTile) {

					placeFire(bombX - i, bombY, playerWhoPutOutTheBomb);
					break;
				} else if (gameBoard.getTile(bombX - i, bombY) instanceof BlockTile) {
					break;
				}

				placeFire(bombX - i, bombY, playerWhoPutOutTheBomb);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY + i)) {
				if (gameBoard.getTile(bombX, bombY + i) instanceof BoxTile) {

					placeFire(bombX, bombY + i, playerWhoPutOutTheBomb);
					break;
				} else if (gameBoard.getTile(bombX, bombY + i) instanceof BlockTile) {
					break;
				}

				placeFire(bombX, bombY + i, playerWhoPutOutTheBomb);
			}
		}
		for (int i = 1; i <= firePower; i++) {
			if (isInbounds(bombX, bombY - i)) {
				if (gameBoard.getTile(bombX, bombY - i) instanceof BoxTile) {

					placeFire(bombX, bombY - i, playerWhoPutOutTheBomb);
					break;
				} else if (gameBoard.getTile(bombX, bombY - i) instanceof BlockTile) {

					break;
				}
				placeFire(bombX, bombY - i, playerWhoPutOutTheBomb);
			}

		}
		player[playerNumber-1].incrementBombs();
	}

	/**
	 * 
	 * @param bombX
	 *            x coordinate of placed bomb
	 * @param bombY
	 *            y coordinate of placed bomb
	 * @placeFire place fire on bomb coordinates
	 */
	private void placeFire(int bombX, int bombY, int playerNumber) {
		if (gameBoard.getTile(bombX, bombY) instanceof BombTile) {
			explodeBomb(bombX, bombY, playerNumber);
		}
		if (gameBoard.getTile(bombX, bombY).canReceiveFire()) {
			gameBoard.setTile(bombX, bombY, TileFactory.getFireTile());
			setFireTileToEmptyTile(bombX, bombY);
		}
	}

	/**
	 * 
	 * @param fireX
	 *            x coordinate of placed bomb
	 * @param fireY
	 *            y coordinate of placed bomb
	 * @setFireTileToEmptyTile changes the tiles touched by fire to either
	 *                         poweritemtiles or just emptytiles
	 */
	private void setFireTileToEmptyTile(final int fireX, final int fireY) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (gameBoard.getTileTmp(fireX, fireY) instanceof BoxTile
						&& Math.random() > 0.7) {
					gameBoard.setTile(fireX, fireY,
							TileFactory.getExtraFirePowerTile());
					gameBoard.setTmpTile(fireX, fireY,
							null);

					System.out.println("powerItemTile");
				} else if (gameBoard.getTileTmp(fireX, fireY) instanceof BoxTile
						&& Math.random() > 0.5) {
					gameBoard.setTile(fireX, fireY,
							TileFactory.getExtraBombsTile());
					gameBoard.setTmpTile(fireX, fireY,
							null);
				}

				else {
					if (gameBoard.getTileTmp(fireX, fireY) instanceof WaterTile) {
						gameBoard.setTile(fireX, fireY,
								TileFactory.getWaterTile());
						System.out.println("watertile");
					} else {
						gameBoard.setTile(fireX, fireY,
								TileFactory.getEmptyTile());
						System.out.println("emptyTile?");

						gameBoard.setTmpTile(fireX, fireY,
								TileFactory.getEmptyTile());
						System.out.println("emptyTile?");
					}
				}
			}
		};
		Timer t = new Timer(FIRE_COUNTDOWN, taskPerformer);
		t.setRepeats(false);
		t.start();
	}

	/**
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @return true if it is inside the board limits
	 */
	private boolean isInbounds(int x, int y) {
		return x >= 0 && x < gameBoard.getSideLength() && y >= 0 && y < gameBoard.getSideLength();
	}

	/**
	 * 
	 * @return board
	 */
	public Board getBoard() {
		return gameBoard;
	}

	public void gameOver() {
		sbg.enterState(2);
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void moveEnemyRandomly() {
		double rand = Math.random() * 4;
		if (rand >= 0 && rand < 1) {
			tryToMoveEnemy(1, 0);
			EventBus.INSTANCE.publish(new Event(Event.Tag.ENEMYSPRITE_RIGHT));
		} else if (rand >= 1 && rand < 2) {
			tryToMoveEnemy(0, 1);
			EventBus.INSTANCE.publish(new Event(Event.Tag.ENEMYSPRITE_DOWN));
		} else if (rand >= 2 && rand < 3) {
			tryToMoveEnemy(-1, 0);
			EventBus.INSTANCE.publish(new Event(Event.Tag.ENEMYSPRITE_LEFT));
		} else {
			tryToMoveEnemy(0, -1);
			EventBus.INSTANCE.publish(new Event(Event.Tag.ENEMYSPRITE_UP));
		}
	}

	private void tryToMoveEnemy(int i, int j) {
		if (isInbounds(i + enemy.getPosition().getX(), j + enemy.getPosition().getY())) {
			if (gameBoard.getTile(i + enemy.getPosition().getX(), j + enemy.getPosition().getY())
					.canReceivePlayer()) {
				enemy.move(i, j);
			}
		}
	}

	@Override
	public void onEvent(Event evt) {
		if (evt.getTag() == Tag.ENEMY_KILLED) {
			enemy.put(5, 5);
		}

	}
}
