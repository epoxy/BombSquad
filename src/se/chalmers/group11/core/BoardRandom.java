package se.chalmers.group11.core;

public class BoardRandom extends Board{

/**
 *Generates a board with random placed blocks and boxes 	
 */
	public BoardRandom(){
	super();
	}

	@Override
	public void generateBoard() {
		for (int i = 0; i < SIDELENGTH; i++) {
			for (int j = 0; j < SIDELENGTH; j++) {
				double rand = Math.random();
				if (rand > 0.5) {
					super.setTile(i, j, TileFactory.getBoxTile());
					super.setTmpTile(i, j, TileFactory.getBoxTile());
				} else if(0.2 <= rand && rand <= 0.5){
					super.setTile(i, j, TileFactory.getEmptyTile());
				}
				else{
					super.setTile(i, j, TileFactory.getBlockTile());
				}
			}
		}
		Functions.makeRoomForPlayers(this);
		
	}
	
}