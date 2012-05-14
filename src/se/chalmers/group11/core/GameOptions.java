package se.chalmers.group11.core;

public class GameOptions {
	
	private static GameOptions gameOptions;
	private String playerOneSkin = "Devil";
	private String playerTwoSkin = "BombMan";
	
	private int boardChooser = 1;
	
	
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
		if (boardChooser == 1) {
			return new BoardClassic();
		} else if (boardChooser == 0) {
			return new BoardEmpty();
		} else if (boardChooser == 4) {
			return new BoardRandom();
		}else if (boardChooser == 5) {
			return new BoardPower();
		}else if (boardChooser == 6) {
			return new BoardWater();	
		}else {
			return new BoardWithoutBlocks();
		}
	}
	
	public void setBoard(int i){
		boardChooser = i;
	}
	
}
