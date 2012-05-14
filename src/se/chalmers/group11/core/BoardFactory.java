package se.chalmers.group11.core;

public class BoardFactory {

	/**
	 * 
	 * @return BoardClassic
	 */
	public static IBoard getBoardClassic() {
		return new BoardClassic();
	}

	/**
	 * 
	 * @return BoardEmpty
	 */
	public static IBoard getBoardEmpty() {
		return new BoardEmpty();
	}

	/**
	 * 
	 * @return BoardRandom
	 */
	public static IBoard getBoardRandom() {
		return new BoardRandom();
	}

	/**
	 * 
	 * @return BoardPower
	 */

	public static IBoard getBoardPower() {
		return new BoardPower();
	}

	/**
	 * 
	 * @return BoardWater
	 */
	public static IBoard getBoardWater() {
		return new BoardWater();
	}

	/**
	 * 
	 * @return BoardWithoutBlocks
	 */
	public static IBoard getBoardWithoutBlocks() {
		return new BoardWithoutBlocks();
	}
}
