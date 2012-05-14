package se.chalmers.group11.core;

public class GameOptions {
	
	private static GameOptions gameOptions;
	private String playerOneSkin = "Devil";
	private String playerTwoSkin = "BombMan";
	
	private int chosenBoard = 1;
	
	
	public static GameOptions getInstance() {
	      if(gameOptions == null) {
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
	
	public void setPlayerOneSkin(String s){
		playerOneSkin = s;
	}
	public void setPlayerTwoSkin(String s){
		playerTwoSkin = s;
	}
	
	public IBoard getBoard() {
		if (chosenBoard == 1) {
			return new BoardClassic();
		} else if (chosenBoard == 0) {
			return new BoardEmpty();
		} else if (chosenBoard == 4) {
			return new BoardRandom();
		}else if (chosenBoard == 5) {
			return new BoardPower();
		}else if (chosenBoard == 6) {
			return new BoardWater();	
		}else {
			return new BoardWithoutBlocks();
		}
	}
	
	public void setBoard(int i){
		chosenBoard = i;
	}
	
}
