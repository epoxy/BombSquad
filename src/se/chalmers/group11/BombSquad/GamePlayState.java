package se.chalmers.group11.BombSquad;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import se.chalmers.group11.BombSquad.GameTile;

public class GamePlayState extends BasicGameState {
	int stateID = -1;
	//private TiledMap map;
	private GameTile gameTile[][] ;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		//map = new TiledMap("lib/TileBoard.tmx");

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		//map.render(0, 0);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return stateID;
	}
	public GameTile getTile(int x, int y)	{
		return gameTile[x][y];
	}
}
