package se.chalmers.group11.core;

/**
 * Interface for player movement
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 *
 */
public interface IMovable {

	/**
	 * Method for moving player to a relative position. Is determined by the
	 * amount of steps x- and y-wise.
	 * 
	 * @param deltaX
	 *            players new relative position x-wise
	 * @param deltaY
	 *            players new relative position y-wise
	 */
	public void move(int dX, int dY);

	/**
	 * Method for putting a player on an absolute position. Mostly used in
	 * testing to make movement efficient.
	 * 
	 * @param x
	 *            players new position x-wise
	 * @param y
	 *            players new position y-wise
	 */
	public void put(int x, int y);

	/**
	 * Getter of the x-position.
	 * 
	 * @return players x coordinate
	 */
	public Position getPosition();
}
