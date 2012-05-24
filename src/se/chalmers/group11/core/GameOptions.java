package se.chalmers.group11.core;

/**
 * Class that handles character and board options. Implements the singleton pattern.
 * 
 * @version 1.0 23 may 2012
 * 
 * @author Henrik Andersson
 *
 */

public class GameOptions {

	private static GameOptions gameOptions;
	private String playerOneSkin = "Devil";
	private String playerTwoSkin = "Wizard";

	private int chosenBoard = 1;
	/**
	 * Returns the singleton instance of the class
	 * @return the singleton instance of the class
	 */
	public static GameOptions getInstance() {
		if (gameOptions == null) {
			gameOptions = new GameOptions();
		}
		return gameOptions;
	}
	/**
	 * Returns the name tag of the skin for player one
	 * @return the name tag of the skin for player one
	 */
	public String getPlayerOneSkin() {
		return playerOneSkin;
	}
	/**
	 * Returns the name tag of the skin for player two
	 * @return the name tag of the skin for player two
	 */
	public String getPlayerTwoSkin() {
		return playerTwoSkin;
	}
	/**
	 * Sets the name tag for player one
	 * @param s the name tag to be set for player one
	 */
	public void setPlayerOneSkin(String s) {
		playerOneSkin = s;
	}
	/**
	 * Sets the name tag for player two
	 * @param s the name tag to be set for player two
	 */
	public void setPlayerTwoSkin(String s) {
		playerTwoSkin = s;
	}
	/**
	 * Returns the game board that has been set.
	 * @return the game board that has been set
	 */
	public Board getBoard() {
		if (chosenBoard == 1) {
			return BoardFactory.getBoardClassic();
		} else if (chosenBoard == 0) {
			return BoardFactory.getBoardEmpty();
		} else if (chosenBoard == 4) {
			return BoardFactory.getBoardRandom();
		} else if (chosenBoard == 5) {
			return BoardFactory.getBoardPower();
		} else if (chosenBoard == 6) {
			return BoardFactory.getBoardWater();
		} else {
			return BoardFactory.getBoardWithoutBlocks();
		}
	}
	/**
	 * Sets which board to be used.
	 * @param i the board that should be used
	 */
	public void setBoard(int i) {
		chosenBoard = i;
	}

}
