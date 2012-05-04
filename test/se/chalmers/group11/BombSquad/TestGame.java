package se.chalmers.group11.BombSquad;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void testExplodeBomb() {
		Game game = Game.getInstance();
		game.explodeBomb(2, 2, 0);
		game.getBoard().setToTile(2, 7, new EmptyTile());//Sets to EmptyTile since it otherwise is random
		GameTile gT = game.getBoard().getTile(2, 3);
		GameTile gT2 = game.getBoard().getTile(2, 7);
		assertTrue(gT instanceof FireTile && gT2 instanceof EmptyTile); // The logical check
	}

}
