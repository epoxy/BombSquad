package se.chalmers.group11.BombSquad;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlayState extends BasicGameState {

	Image bomb = null;
	Image player = null;
	int stateID = -1;

	// private Player playerOne = new Player();
	// we don«t use this for now!
	private GameBoard gameBoard;

	public GamePlayState(int stateID) {
		this.stateID = stateID;

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		gameBoard = GameBoard.getInstance();
		player = new Image("Images/PlayerIcon.png");
		bomb = new Image("Images/Bomb.jpg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		player.draw(gameBoard.getPlayerX() * 60, gameBoard.getPlayerY() * 60,
				60, 60);
		

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_UP)) {
			gameBoard.setPlayerPosition(0, -1);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			gameBoard.setPlayerPosition(-1, 0);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			gameBoard.setPlayerPosition(0, 1);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			gameBoard.setPlayerPosition(1, 0);
		}
		if (input.isKeyPressed(Input.KEY_SPACE)) {
		gameBoard.setBomb();
		//playerOne.releaseBomb();
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
