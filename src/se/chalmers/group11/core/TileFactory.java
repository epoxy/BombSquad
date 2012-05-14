package se.chalmers.group11.core;

/**
 * Factory class for available tiles
 */
public class TileFactory {
	/**
	 * 
	 * @return a BombTile
	 */
	public static GameTile getBombTile() {
		return new BombTile();
	}

	/**
	 * 
	 * @return a FireTile
	 */
	public static GameTile getFireTile() {
		return new FireTile();
	}

	/**
	 * 
	 * @return a BoxTile
	 */
	public static GameTile getBoxTile() {
		return new BoxTile();
	}

	/**
	 * 
	 * @return a BlockTile
	 */
	public static GameTile getBlockTile() {
		return new BlockTile();
	}

	/**
	 * 
	 * @return a EmptyTile
	 */
	public static GameTile getEmptyTile() {
		return new EmptyTile();
	}

	/**
	 * 
	 * @return a PowerItemTile
	 */
	public static GameTile getPowerItemTile() {
		return new ExtraFirePowerTile();
	}

	/**
	 * 
	 * @return a ExtraBombsTile
	 */
	public static GameTile getExtraBombs() {
		return new ExtraBombsTile();
	}

	/**
	 * 
	 * @return a WaterTile
	 */
	public static GameTile getWaterTile() {
		return new WaterTile();
	}
}
