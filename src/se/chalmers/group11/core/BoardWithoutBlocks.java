package se.chalmers.group11.core;

public class BoardWithoutBlocks extends Board {

/**
 *Generates a board that is without any blocks
 */
	public BoardWithoutBlocks() {
		super();
	}
	

	@Override
	public void generateBoard() {
		for (int i = 0; i < SIDELENGTH; i++) {
			for (int j = 0; j < SIDELENGTH; j++) {
				super.setToTile(i, j, TileFactory.getBoxTile());
				super.setTmpToTile(i, j, TileFactory.getBoxTile());
			}
		}
		Functions.makeRoomForPlayers(this);
		
	}

}
