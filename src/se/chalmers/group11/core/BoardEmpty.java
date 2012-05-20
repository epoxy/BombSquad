package se.chalmers.group11.core;

public class BoardEmpty extends Board{

	/**
	 *Generates a board without any boxes	
	 */
	public BoardEmpty() {
		super();		
	}

	@Override
	public void generateBoard() {
		for (int i = 0; i < SIDELENGTH; i++) {
			for (int j = 0; j < SIDELENGTH; j++) {
				super.setToTile(i, j, TileFactory.getEmptyTile());
			}
		}
		for (int i = 1; i < SIDELENGTH - 1; i += 2) {
			for (int j = 1; j < SIDELENGTH - 1; j += 2) {
				super.setToTile(i, j, TileFactory.getBlockTile());
			}
		}
	}
}
