package se.chalmers.group11.core;

/**
 * An interface representing different tiles. 
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 */

public interface GameTile {
	/**
	 * checks if the tile can recieve a player or not
	 * 
	 * @return boolean
	 */
	public boolean canReceivePlayer();

	/**
	 * checks if the tile can recieve fire or not
	 * 
	 * @return boolean
	 */
	public boolean canReceiveFire();

	/**
	 * 
	 * @param p
	 *            The player that we will perform different things at
	 */
	public void performOnPlayer(Player p);

	public void performOnEnemy();

}
