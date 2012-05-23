package se.chalmers.group11.core;

public class BoardWithoutBlocks extends Board {

	/**
	 * Generates a board without any blocks
	 */
	public BoardWithoutBlocks() {
		super();
	}

	@Override
	public void generateBoard() {
		for (int i = 0; i < SIDELENGTH; i++) {
			for (int j = 0; j < SIDELENGTH; j++) {
				super.setTile(i, j, TileFactory.getBoxTile());
				super.setTmpTile(i, j, TileFactory.getBoxTile());
			}
		}
		Functions.makeRoomForPlayers(this);

	}

}
