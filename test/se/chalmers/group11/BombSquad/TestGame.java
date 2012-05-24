package se.chalmers.group11.bombsquad;

import static org.junit.Assert.*;

import org.junit.Test;
import org.newdawn.slick.SlickException;

import se.chalmers.group11.bombsquadgui.GameOverState;
import se.chalmers.group11.core.BlockTile;
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
 * @version 1.0 23 may 2012
 * 
 * @author Anton Palmqvist
 * @author Tomas Selldén implemented more tests
 * 
 */
public class TestGame {

	@Test
	public void testExplodeBomb() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.explodeBomb(2, 2, 1);// Explodes a bomb at coordinates 2,2
		// Checks that the fire from the bomb is spreading to the five tiles
		// nearby but not further
		
		//The logica check
		assertTrue(game.getBoard().getTile(2, 2) instanceof FireTile); 
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
	// Use case: Move
	public void testSetPlayerPosition() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getPlayer(2).move(-1, 0);// Adjusts player1 so that he can move
										// to the right
		for (int i = 1; i <= 2; i++) {// Testing both players
			int s = game.getPlayer(i).getPosition().getX();
			game.movePlayer(1, 0, i);// Moves players one step to the
										// right
			int r = game.getPlayer(i).getPosition().getX();
			assertTrue(r - s == 1); // Difference between destination and source
									// should be 1 step
		}
	}

	@Test
	// Use case: Move
	public void testSetPlayerPositionToObstacle() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getPlayer(1).move(0, -1);// Adjusts player1 and player2 to so that
										// they can not move to the right
		for (int i = 1; i <= 2; i++) {// Testing both players
			int s = game.getPlayer(i).getPosition().getX();
			game.movePlayer(1, 0, i);// Moves player one step to the
										// right
			int r = game.getPlayer(i).getPosition().getX();
			assertTrue(r - s == 0); // Difference between destination and source
									// should be 1 step
		}
	}

	@Test
	public void pickUpExtraFire() throws SlickException {
		Game game = new Game(new BoardEmpty());
		int firePower = game.getPlayer(1).getFirePower();
		game.getBoard().setTile(1, 0, TileFactory.getExtraFirePowerTile());
		game.movePlayer(1, 0, 1); // Moves player one step to the right
		assertTrue(game.getPlayer(1).getFirePower() == firePower + 1);
	}

	@Test
	public void explodeBombExtraFire() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getBoard().setTile(1, 0, TileFactory.getExtraFirePowerTile());
		game.movePlayer(1, 0, 1);// Moves player one step to the right
		game.explodeBomb(4, 4, 1); // Explodes a bomb with player 1's firepower
		// Fire should be put out on bomb position and on the two tiles next to
		// the position//
		assertTrue(game.getBoard().getTile(4, 4) instanceof FireTile);
		assertTrue(game.getBoard().getTile(5, 4) instanceof FireTile);
		assertTrue(game.getBoard().getTile(6, 4) instanceof FireTile);
		//Fire ends here
		assertFalse(game.getBoard().getTile(7, 4) instanceof FireTile);
	}

	@Test
	public void pickUpExtraBombs() throws SlickException {
		Game game = new Game(new BoardEmpty());
		int amountOfBombs = game.getPlayer(1).getAmountOfBombs(); // Should be 1
		game.getBoard().setTile(1, 0, TileFactory.getExtraBombsTile());
		// Player moves on an ExtraBomb-tile and picks it up
		game.movePlayer(1, 0, 1);
		// Checks that player 1¥s amount of bombs has increased by 1
		assertTrue(game.getPlayer(1).getAmountOfBombs() == amountOfBombs + 1);
	}

	@Test
	public void putOutExtraBombs() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getBoard().setTile(1, 0, TileFactory.getExtraBombsTile());
		// Player moves on an ExtraBomb-tile and picks it up
		game.movePlayer(1, 0, 1);
		game.putBomb(1);// Puts out a bomb
		game.movePlayer(1, 0, 1);// moves to the right
		game.putBomb(1);// Puts out a bomb
		game.movePlayer(1, 0, 1);// moves to the right
		game.putBomb(1);// Tries to Put out a bomb, but should not be able to
		// Checks that the two first tiles has bombs put out on them
		assertTrue(game.getBoard().getTile(1, 0) instanceof BombTile);
		assertTrue(game.getBoard().getTile(2, 0) instanceof BombTile);
		// Checks that the last position is not a bomb
		assertTrue(game.getBoard().getTile(3, 0) instanceof EmptyTile);
	}

	@Test
	public void tryToPutTwoBombsOnTheSamePlace() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getBoard().setTile(1, 0, TileFactory.getExtraBombsTile());
		game.movePlayer(1, 0, 1); // Picks up an ExtraBombTile
		assertTrue(game.getPlayer(1).getAmountOfBombs() == 2); // Able to put
																// out two bombs
		game.putBomb(1); // Putting out one bomb
		assertTrue(game.getPlayer(1).getAmountOfBombs() == 1); // One bomb left
																// to put out
		game.putBomb(1); // Tries to put out a bomb on same position
		/*
		 * The amount of bombs is still one, thereby we know that no second bomb
		 * has been put out
		 */
		assertTrue(game.getPlayer(1).getAmountOfBombs() == 1);
	}

	@Test
	public void enemyKilledByFire() throws SlickException {
		Game game = new Game(new BoardEmpty());
		game.getEnemy().move(4, 1); // moves enemy 4 steps to the right
		game.explodeBomb(10, 6, 1); // explodes bomb at enemyposition
		/*
		 * Forces the tile, which now is a FireTile to perform on the enemy, aka
		 * kill the enem.y
		 */
		game.getBoard().getTile(10, 6).performOnEnemy();

		// When enemy dies it respawns on its starting position x=6 and y=6
		assertTrue(game.getEnemy().getPosition().getX() == 5
				&& game.getEnemy().getPosition().getY() == 5);

	}

	@Test
	public void playerWins() throws SlickException {
		// Test so the counter "playerWins" work correctly
		GameOverState gameOver = new GameOverState(0);
		Player p = new Player(0, 0, 1);
		int testPlayerOneWins1 = gameOver.getPlayerWins(2);
		assertTrue(testPlayerOneWins1 == 0);
		gameOver.onEvent(new Event(Event.Tag.PLAYER_KILLED, p.getPlayerNumber()));
		int testPlayerOneWins2 = gameOver.getPlayerWins(2);
		assertTrue(testPlayerOneWins2 == 1);
	}

	@Test
	public void resetplayerWins() throws SlickException {
		// Test so we can reset the counter "PlayerWins"
		GameOverState gameOver = new GameOverState(0);
		Player p = new Player(0, 0, 1);
		gameOver.onEvent(new Event(Event.Tag.PLAYER_KILLED, p.getPlayerNumber()));
		int testPlayerOneWins = gameOver.getPlayerWins(2);
		assertTrue(testPlayerOneWins == 1);
		gameOver.resetPlayerWins();
		int testPlayerOneWins2 = gameOver.getPlayerWins(2);
		assertTrue(testPlayerOneWins2 == 0);
	}

	@Test
	public void explodeBombTowardsBlockTile() throws SlickException {
		// Test for the explodeBomb method in class game. A bomb with two
		// powerfires explodes beside a blocktile, Checks so the BlockTile
		// doesn´t change to a FireTile and that the tile behind the block still
		// is a emptyTile and not a FireTile, the rest of the tiles nearby
		// should be FireTiles
		Game game = new Game(new BoardEmpty());
		game.getBoard().setTile(1, 0, TileFactory.getExtraFirePowerTile());
		game.movePlayer(1, 0, 1);
		game.explodeBomb(2, 1, 1);
		assertTrue(game.getBoard().getTile(2, 1) instanceof FireTile);
		assertTrue(game.getBoard().getTile(2, 0) instanceof FireTile);
		assertTrue(game.getBoard().getTile(2, 2) instanceof FireTile);
		assertTrue(game.getBoard().getTile(2, 3) instanceof FireTile);
		assertTrue(game.getBoard().getTile(1, 1) instanceof BlockTile);
		assertTrue(game.getBoard().getTile(0, 1) instanceof EmptyTile);
		assertTrue(game.getBoard().getTile(3, 1) instanceof BlockTile);
		assertTrue(game.getBoard().getTile(4, 1) instanceof EmptyTile);

	}
}
