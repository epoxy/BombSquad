package se.chalmers.group11.core;

public class BoardWater extends Board {

	/**
	 * Generates a board that with watertiles
	 */
	public BoardWater() {
		super();
	}

	@Override
	public void generateBoard() {
		for (int i = 0; i < SIDELENGTH; i++) {
			for (int j = 0; j < SIDELENGTH; j++) {

				if (Math.random() > 0.4) {
					super.setTile(i, j, TileFactory.getBoxTile());
					super.setTmpTile(i, j, TileFactory.getBoxTile());
				} else {
					super.setTile(i, j, TileFactory.getEmptyTile());											
				}
			}
		}

		for (int i = 1; i < SIDELENGTH - 1; i += 2) {
			for (int j = 1; j < SIDELENGTH - 1; j += 2) {
				super.setTile(i, j, TileFactory.getWaterTile());
				super.setTmpTile(i, j, TileFactory.getWaterTile());
			}
		}
		Functions.makeRoomForPlayers(this);
	}

}
