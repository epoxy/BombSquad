package se.chalmers.group11.BombSquad;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlayState extends BasicGameState {

	int stateID = -1;
	private Player playerOne = new Player();
	// we don«t use this for now!
	private GameBoard gameBoard;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_W)) {
			playerOne.setPosition(0, -1);
		}
		if (input.isKeyPressed(Input.KEY_A)) {
			playerOne.setPosition(-1, 0);
		}
		if (input.isKeyPressed(Input.KEY_S)) {
			playerOne.setPosition(0, 1);
		}
		if (input.isKeyPressed(Input.KEY_D)) {
			playerOne.setPosition(1, 0);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
