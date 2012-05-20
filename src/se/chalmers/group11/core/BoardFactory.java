package se.chalmers.group11.core;

/**
 * Factory class for available Boards
 * 
 */
public class BoardFactory {

	/**
	 * 
	 * @return BoardClassic
	 */
	public static Board getBoardClassic() {
		return new BoardClassic();
	}

	/**
	 * 
	 * @return BoardEmpty
	 */
	public static Board getBoardEmpty() {
		return new BoardEmpty();
	}

	/**
	 * 
	 * @return BoardRandom
	 */
	public static Board getBoardRandom() {
		return new BoardRandom();
	}

	/**
	 * 
	 * @return BoardPower
	 */

	public static Board getBoardPower() {
		return new BoardPower();
	}

	/**
	 * 
	 * @return BoardWater
	 */
	public static Board getBoardWater() {
		return new BoardWater();
	}

	/**
	 * 
	 * @return BoardWithoutBlocks
	 */
	public static Board getBoardWithoutBlocks() {
		return new BoardWithoutBlocks();
	}
}
