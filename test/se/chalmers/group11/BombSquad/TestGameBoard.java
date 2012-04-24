package se.chalmers.group11.BombSquad;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameBoard {

	@Test
	public void testSetPlayerPosition() { //Use case: move
		GameBoard gameBoard;
		gameBoard = GameBoard.getInstance();
		Player player = gameBoard.getPlayer(0);
		int t = player.getX();
		gameBoard.setPlayerPosition(1, 0, 0);//Moves player one step to the right
		int r = player.getX();
		assertTrue(r-t == 1); // The logical check
	}

}
