package se.chalmers.group11.BombSquad;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlayState extends BasicGameState {

	Image bombImage = null;
	Image playerImage = null;
	Image grassImage = null;
	Image treeImage = null;
	int stateID = 0;

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
		playerImage = new Image("Images/PlayerIcon.png");
		bombImage = new Image("Images/Bomb.jpg");
		grassImage = new Image("Images/grass.jpg");
		treeImage = new Image("Images/treeBox.jpg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		for (int i = 0; i < gameBoard.getSideLength(); i++) {
			for (int j = 0; j < gameBoard.getSideLength(); j++) {
				if (GameBoard.getInstance().getTile(i, j) instanceof BombTile) {
					bombImage.draw(gameBoard.getBombX() * 60,
							gameBoard.getBombY() * 60, 60, 60);
				}
				if (gameBoard.getTile(i, j) instanceof EmptyTile) {
					grassImage.getScaledCopy(0.08f)
							.draw(i * 60, j * 60, 60, 60);
				}
				if (gameBoard.getTile(i, j) instanceof BoxTile) {
					treeImage.getScaledCopy(1).draw(i * 60, j * 60, 60, 60);
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			playerImage.draw(gameBoard.getPlayer(i).getX() * 60, gameBoard
					.getPlayer(i).getY() * 60, 60, 60);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_UP)) {
			gameBoard.setPlayerPosition(0, -1, 0);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			gameBoard.setPlayerPosition(-1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			gameBoard.setPlayerPosition(0, 1, 0);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			gameBoard.setPlayerPosition(1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			gameBoard.setBomb(0);
			// playerOne.releaseBomb();
		}
		// System.out.println(gameBoard.getPlayerX() + " " +
		// gameBoard.getPlayerY());
		if (input.isKeyPressed(Input.KEY_W)) {
			gameBoard.setPlayerPosition(0, -1, 1);
		}
		if (input.isKeyPressed(Input.KEY_A)) {
			gameBoard.setPlayerPosition(-1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_S)) {
			gameBoard.setPlayerPosition(0, 1, 1);
		}
		if (input.isKeyPressed(Input.KEY_D)) {
			gameBoard.setPlayerPosition(1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_Q)) {
			gameBoard.setBomb(1);
			// playerOne.releaseBomb();
		}
		for (int j = 0; j < 2; j++) {// Loopar igenom spelarens placering och
										// ser om han ska dö på rutan han är
			gameBoard.getTile(gameBoard.getPlayer(j).getX(),
					gameBoard.getPlayer(j).getY()).performOnPlayer(j);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
