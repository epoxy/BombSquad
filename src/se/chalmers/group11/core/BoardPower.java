package se.chalmers.group11.core;

public class BoardPower extends Board {
	
	/**
	 * Generates a board with only powerUps
	 * 
	 * @version 1.0 23 may 2012
	 * 
	 * @author Marcus Thyrén
	 * 
	 */
	public BoardPower(){
		super();		
	}
	
	@Override
	public void generateBoard() {
		for (int i = 0; i < SIDELENGTH; i++) {
			for (int j = 0; j < SIDELENGTH; j++) {
				double rand = Math.random();
				if (rand > 0.5) {
					super.setTile(i, j, TileFactory.getExtraFirePowerTile());
				} else {
					super.setTile(i, j, TileFactory.getExtraBombsTile());}
				
			}
		}
		Functions.makeRoomForPlayers(this);
		
	}
}
