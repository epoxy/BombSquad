package se.chalmers.group11.BombSquad;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void testExplodeBomb() {
		Game game = Game.getInstance();
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
		Game game = Game.getInstance();
		int s = game.getPlayer(0).getX();
		game.setPlayerPosition(1, 0, 0);//Moves player one step to the right
		int r = game.getPlayer(0).getX();
		assertTrue(r-s == 1); // Difference between destination and source should be 1
	}
	@Test
	public void testExtraFire(){
		Game game = Game.getInstance();
		game.explodeBomb(4, 4, 0);
		
	}
}
