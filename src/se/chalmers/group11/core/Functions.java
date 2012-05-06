package se.chalmers.group11.core;

public class Functions {

/**
 * 	@makeRoomForPlayers makes sure that the players
 *  isn't locked in at the beginning
 * @param iB the board
 */
	public static void makeRoomForPlayers(IBoard iB){
		iB.setToTile(0, 0, TileFactory.getEmptyTile());
		iB.setToTile(1, 0, TileFactory.getEmptyTile());
		iB.setToTile(0, 1, TileFactory.getEmptyTile());
		iB.setTmpToTile(0, 0, TileFactory.getEmptyTile());
		iB.setTmpToTile(1, 0, TileFactory.getEmptyTile());
		iB.setTmpToTile(0, 1, TileFactory.getEmptyTile());
		double rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			iB.setToTile(2, 0, TileFactory.getEmptyTile());
			iB.setTmpToTile(2, 0, TileFactory.getEmptyTile());
		}
		else{
			iB.setToTile(0, 2, TileFactory.getEmptyTile());
			iB.setTmpToTile(0, 2, TileFactory.getEmptyTile());
		}
		iB.setToTile(10, 10, TileFactory.getEmptyTile());
		iB.setToTile(10, 9, TileFactory.getEmptyTile());
		iB.setToTile(9, 10, TileFactory.getEmptyTile());
		iB.setTmpToTile(10, 10, TileFactory.getEmptyTile());
		iB.setTmpToTile(10, 9, TileFactory.getEmptyTile());
		iB.setTmpToTile(9, 10, TileFactory.getEmptyTile());
		rand = Math.random();
		if(rand<0.5){//Randomizing the last emptyTile
			iB.setToTile(8, 10, TileFactory.getEmptyTile());
			iB.setTmpToTile(8, 10, TileFactory.getEmptyTile());
		}
		else{
			iB.setToTile(10, 8, TileFactory.getEmptyTile());
			iB.setTmpToTile(10, 8, TileFactory.getEmptyTile());
		}

	}
}