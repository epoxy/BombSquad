package se.chalmers.group11.BombSquad;

import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.group11.core.BoardEmpty;
import se.chalmers.group11.core.FireTile;
import se.chalmers.group11.core.Game;
import se.chalmers.group11.core.TileFactory;

public class TestGame {

	@Test
	public void testExplodeBomb() {
		Game game = new Game(new BoardEmpty());
		game.explodeBomb(2, 2, 0);//Explodes a bomb at coordinates 2,2
		//Checks that the fire from the bomb is spreading to the five tiles nearby but not further
		assertTrue(game.getBoard().getTile(2, 2) instanceof FireTile); // The logical check
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
	public void testSetPlayerPosition() { //Use case: move
		Game game = new Game(new BoardEmpty());
		int s = game.getPlayer(0).getX();
		game.setPlayerPosition(1, 0, 0);//Moves player one step to the right
		int r = game.getPlayer(0).getX();
		assertTrue(r-s == 1); // Difference between destination and source should be 1
	}
	@Test
	public void pickUpExtraFire(){
		Game game = new Game(new BoardEmpty());
		game.getPlayer(0).put(0, 0);
		int fP = game.getPlayer(0).getFirePower();
		game.getBoard().setToTile(1, 0, TileFactory.getPowerItemTile());
		game.setPlayerPosition(1, 0, 0);//Moves player one step to the right
		assertTrue(game.getPlayer(0).getFirePower()==fP+1);
	}
	@Test
	public void explodeBombExtraFire(){
		Game game = new Game(new BoardEmpty());
		game.getPlayer(0).put(0, 0);
		game.getBoard().setToTile(1, 0, TileFactory.getPowerItemTile());
		game.setPlayerPosition(1, 0, 0);//Moves player one step to the right
		game.explodeBomb(4, 4, 0);
		assertTrue(game.getBoard().getTile(4, 4) instanceof FireTile);
		assertTrue(game.getBoard().getTile(5, 4) instanceof FireTile);
		assertTrue(game.getBoard().getTile(6, 4) instanceof FireTile);
		assertFalse(game.getBoard().getTile(8, 4) instanceof FireTile);
	}
}
