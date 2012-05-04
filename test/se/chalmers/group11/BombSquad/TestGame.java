package se.chalmers.group11.BombSquad;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void testGetBoard() {
		Game game = Game.getInstance();
		game.getBoard().getTile(game.getPlayer(1).getX(),
		game.getPlayer(1).getY()).performOnPlayer(1);
	}

}
