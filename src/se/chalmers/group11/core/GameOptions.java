package se.chalmers.group11.core;

public class GameOptions {

	private static GameOptions gameOptions;
	private String playerOneSkin = "Devil";
	private String playerTwoSkin = "Wizard";

	private int chosenBoard = 1;

	public static GameOptions getInstance() {
		if (gameOptions == null) {
			gameOptions = new GameOptions();
		}
		return gameOptions;
	}

	public String getPlayerOneSkin() {
		return playerOneSkin;
	}

	public String getPlayerTwoSkin() {
		return playerTwoSkin;
	}

	public void setPlayerOneSkin(String s) {
		playerOneSkin = s;
	}

	public void setPlayerTwoSkin(String s) {
		playerTwoSkin = s;
	}

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

	public void setBoard(int i) {
		chosenBoard = i;
	}

}
