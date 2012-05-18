package se.chalmers.group11.bombsquad;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.SlickException;

import se.chalmers.group11.bombsquadgui.GameOverState;
import se.chalmers.group11.core.BoardEmpty;
import se.chalmers.group11.core.BombTile;
import se.chalmers.group11.core.EmptyTile;
import se.chalmers.group11.core.FireTile;
import se.chalmers.group11.core.Game;
import se.chalmers.group11.core.Player;
import se.chalmers.group11.core.TileFactory;
import se.chalmers.group11.eventbus.Event;

/**
 * This is an integrationstest because all other classes are trivial.
 * 
<<<<<<< HEAD
 * @author Anton Palmqvist
 *
=======
 * @author Epoxy
 * 
>>>>>>> 389d922cb2399547508b81d22e92a73df392df7b
 */
public class TestGame {

	@Test
	public void testExplodeBomb() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.explodeBomb(2, 2, 0);// Explodes a bomb at coordinates 2,2
		// Checks that the fire from the bomb is spreading to the five tiles
		// nearby but not further
		assertTrue(game.getBoard().getTile(2, 2) instanceof FireTile); // The
																		// logical
																		// check
		assertTrue(game.getBoard().getTile(2, 3) instanceof FireTile);
		assertTrue(game.getBoard().getTile(2, 1) instanceof FireTile);
		assertTrue(game.getBoard().getTile(1, 2) instanceof FireTile);
		assertTrue(game.getBoard().getTile(3, 2) instanceof FireTile);
		assertFalse(game.getBoard().getTile(4, 2) instanceof FireTile);
		assertFalse(game.getBoard().getTile(0, 2) instanceof FireTile);
		assertFalse(game.getBoard().getTile(2, 4) instanceof FireTile);
		assertFalse(game.getBoard().getTile(2, 0) instanceof FireTile);
	}

	@Test
	public void testSetPlayerPosition() throws SlickException { // Use case:
																// move
		Game game = new Game(new BoardEmpty());
		game.getPlayer(1).move(-1, 0);// Adjusts player2 to so that he can move
										// to the right
		for (int i = 0; i <= 1; i++) {// Testing both players
			int s = game.getPlayer(i).getX();
			game.setPlayerPosition(1, 0, i);// Moves player one step to the
											// right
			int r = game.getPlayer(i).getX();
			assertTrue(r - s == 1); // Difference between destination and source
									// should be 1 step
		}
	}

	public void testSetPlayerPositionToObstacle() throws SlickException { // Use
																			// case:
																			// move
		Game game = new Game(new BoardEmpty());
		game.getPlayer(0).move(0, -1);// Adjusts player1 and player2 to so that
										// they can not move to the right
		game.getPlayer(1).put(8, 9);
		for (int i = 0; i <= 1; i++) {// Testing both players
			int s = game.getPlayer(i).getX();
			game.setPlayerPosition(1, 0, i);// Moves player one step to the
											// right
			int r = game.getPlayer(i).getX();
			assertTrue(r - s == 0); // Difference between destination and source
									// should be 1 step
		}
	}

	@Test
	public void pickUpExtraFire() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getPlayer(0).put(0, 0);
		int firePower = game.getPlayer(0).getFirePower();
		game.getBoard().setToTile(1, 0, TileFactory.getExtraFirePowerTile());
		game.setPlayerPosition(1, 0, 0); // Moves player one step to the right
		assertTrue(game.getPlayer(0).getFirePower() == firePower + 1);
	}

	@Test
	public void explodeBombExtraFire() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getPlayer(0).put(0, 0);
		game.getBoard().setToTile(1, 0, TileFactory.getExtraFirePowerTile());
		game.setPlayerPosition(1, 0, 0);// Moves player one step to the right
		game.explodeBomb(4, 4, 0);
		assertTrue(game.getBoard().getTile(4, 4) instanceof FireTile);
		assertTrue(game.getBoard().getTile(5, 4) instanceof FireTile);
		assertTrue(game.getBoard().getTile(6, 4) instanceof FireTile);
		assertFalse(game.getBoard().getTile(8, 4) instanceof FireTile);
	}

	@Test
	public void pickUpExtraBombs() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getPlayer(0).put(0, 0);
		int amountOfBombs = game.getPlayer(0).getAmountOfBombs();
		game.getBoard().setToTile(1, 0, TileFactory.getExtraBombsTile());
		game.setPlayerPosition(1, 0, 0);
		assertTrue(game.getPlayer(0).getAmountOfBombs() == amountOfBombs + 1);
	}

	@Test
	public void putOutExtraBombs() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getBoard().setToTile(1, 0, TileFactory.getExtraBombsTile());
		game.setPlayerPosition(1, 0, 0);
		game.setBomb(0);
		game.setPlayerPosition(1, 0, 0);
		game.setBomb(0);
		game.setPlayerPosition(1, 0, 0);
		game.setBomb(0);
		assertTrue(game.getBoard().getTile(1, 0) instanceof BombTile);
		assertTrue(game.getBoard().getTile(2, 0) instanceof BombTile);
		assertTrue(game.getBoard().getTile(3, 0) instanceof EmptyTile);
	}

	@Test
	public void tryToPutTwoBombsOnTheSamePlace() throws SlickException{
		Game game = new Game(new BoardEmpty());
		game.getBoard().setToTile(1, 0, TileFactory.getExtraBombsTile());
		game.setPlayerPosition(1, 0, 0); //Picks up an ExtraBombTile
		assertTrue(game.getPlayer(0).getAmountOfBombs()==2); //Able to put out two bombs
		game.setBomb(0); //Putting out one bomb
		assertTrue(game.getPlayer(0).getAmountOfBombs()==1); //One bomb left to put out
		game.setBomb(0); //Tries to put out a bomb on same position
		/*The amount of bombs is still one, thereby we know that no second bomb has been 
		 * put out*/
		assertTrue(game.getPlayer(0).getAmountOfBombs()==1); 
	}
	@Test
	public void enemyKilledByFire() throws SlickException{
		Game game = new Game(new BoardEmpty());
		//game.explodeBomb(9, 6, 0); //explodes bomb at enemyposition
		game.getEnemy().move(4, 0); //moves enemy 4 steps to the right
		game.explodeBomb(10, 6, 0); //explodes bomb at enemyposition
		/*Forces the tile, which now is a FireTile to perform on the enemy, 
		 * aka kill the enem.y*/
		game.getBoard().getTile(10, 6).performOnEnemy();
		//When enemy dies it respawns on its starting position x=6 and y=6
		assertTrue(game.getEnemy().getX()==6 && game.getEnemy().getY()==6);
	}
	@Test
	public void playerWins() throws SlickException {
		GameOverState gameOver = new GameOverState(0);
		int testPlayerOneWins1 = gameOver.getPlayerWins(2);
		Player p = new Player(0, 0, 1);
		gameOver.onEvent(new Event(Event.Tag.PLAYER_KILLED, p.getPlayerNumber()));
		int testPlayerOneWins2 = gameOver.getPlayerWins(2);
		assertTrue(testPlayerOneWins2 - testPlayerOneWins1 == 1);
	}
	@Test
	public void resetplayerWins() throws SlickException {
		GameOverState gameOver = new GameOverState(0);
		Player p = new Player(0, 0, 1);
		gameOver.onEvent(new Event(Event.Tag.PLAYER_KILLED, p.getPlayerNumber()));
		int testPlayerOneWins = gameOver.getPlayerWins(2);
		assertTrue(testPlayerOneWins == 1);
		gameOver.resetPlayerWins();
		int testPlayerOneWins2= gameOver.getPlayerWins(2);
		assertTrue(testPlayerOneWins2 == 0);
	}
	
}
