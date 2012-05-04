package se.chalmers.group11.BombSquad;

public class TileFactory {
	public static GameTile getBombTile() {
		return new BombTile();
	}

	public static GameTile getFireTile() {
		return new FireTile();
	}

	public static GameTile getBoxTile() {
		return new BoxTile();
	}

	public static GameTile getBlockTile() {
		return new BlockTile();
	}

	public static GameTile getEmptyTile() {
		return new EmptyTile();
	}

	public static GameTile getPowerItemTile() {
		return new PowerItemTile();
	}

	public static GameTile getExtraBombs() {
		return new ExtraBombsTile();
	}
}
