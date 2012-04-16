package se.chalmers.group11.BombSquad;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameBoard {
	
//	@Test
//	public void testSetPlayerPosition() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetPlayerX() {
		GameBoard gameBoard;
		gameBoard = GameBoard.getInstance();
		Player player = gameBoard.getPlayer(1);
		int t = player.getX();
		gameBoard.setPlayerPosition(1, 0, 1);
		int r = player.getX();
		assertTrue(r-t == 1); // The logical check
	}

//	@Test
//	public void testGetPlayerY() {
//		fail("Not yet implemented");
//	}

}
