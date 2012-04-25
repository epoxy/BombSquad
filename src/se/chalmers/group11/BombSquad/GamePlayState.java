package se.chalmers.group11.BombSquad;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlayState extends BasicGameState {

<<<<<<< HEAD
	Image bomb = null;
	Image player = null;
	int stateID = 1;
=======
	Image bombImage = null;
	Image grassImage = null;
	Image treeImage = null;
	Image extraFirePower = null;
	int stateID = 0;
>>>>>>> origin/master

	private int counter = 50;

	private Animation sprite, up, down, left, right;
	// private Player playerOne = new Player();
	// we don«t use this for now!
	private GameBoard gameBoard;

	public GamePlayState(int stateID) {
		this.stateID = stateID;

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

		Image[] movementUp = { new Image("Images/bombManUP.gif"),
				new Image("Images/bombManUP2.gif") };
		Image[] movementDown = { new Image("Images/bombManDOWN.gif"),
				new Image("Images/bombManDOWN2.gif") };
		Image[] movementLeft = { new Image("Images/bombManLEFT.gif"),
				new Image("Images/bombManLEFT2.gif") };
		Image[] movementRight = { new Image("Images/bombManRIGHT.gif"),
				new Image("Images/bombManRIGHT2.gif") };
		int[] duration = { 150, 150 };
		up = new Animation(movementUp, duration, true);
		down = new Animation(movementDown, duration, false);
		left = new Animation(movementLeft, duration, false);
		right = new Animation(movementRight, duration, false);

		sprite = right;

		gameBoard = GameBoard.getInstance();
		bombImage = new Image("Images/Bomb.jpg");
		grassImage = new Image("Images/grass.jpg");
		treeImage = new Image("Images/treeBox.jpg");
		extraFirePower = new Image("Images/extraFire.jpg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		for (int i = 0; i < gameBoard.getSideLength(); i++) {
			for (int j = 0; j < gameBoard.getSideLength(); j++) {
				if (gameBoard.getTile(i, j) instanceof BombTile) {
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
				if (gameBoard.getTile(i, j) instanceof PowerItemTile) {
					extraFirePower.draw(i * 60, j * 60, 60, 60);
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			sprite.draw(gameBoard.getPlayer(i).getX() * 60, gameBoard
					.getPlayer(i).getY() * 60, 60, 60);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		counter -= 1;
		if (counter < 0) {
			if (input.isKeyDown(Input.KEY_UP)) {
				sprite = up;

				gameBoard.setPlayerPosition(0, -1, 0);
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
				sprite = left;
				gameBoard.setPlayerPosition(-1, 0, 0);
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
				sprite = down;
				gameBoard.setPlayerPosition(0, 1, 0);
			}
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				sprite = right;
				gameBoard.setPlayerPosition(1, 0, 0);
			}
			if (input.isKeyDown(Input.KEY_SPACE)) {
				gameBoard.setBomb(0);
				// playerOne.releaseBomb();
			}
			// System.out.println(gameBoard.getPlayerX() + " " +
			// gameBoard.getPlayerY());
			if (input.isKeyDown(Input.KEY_W)) {
				sprite = up;
				gameBoard.setPlayerPosition(0, -1, 1);
			}
			if (input.isKeyDown(Input.KEY_A)) {
				sprite = left;
				gameBoard.setPlayerPosition(-1, 0, 1);
			}
			if (input.isKeyDown(Input.KEY_S)) {
				sprite = down;
				gameBoard.setPlayerPosition(0, 1, 1);
			}
			if (input.isKeyDown(Input.KEY_D)) {
				sprite = right;
				gameBoard.setPlayerPosition(1, 0, 1);
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				gameBoard.setBomb(1);
				// playerOne.releaseBomb();
			}
			counter = 45;
		}


		// for (int j = 0; j < 2; j++) {// Loopar igenom spelarens placering och
		// // ser om han ska dö på rutan han är
		// gameBoard.getTile(gameBoard.getPlayer(j).getX(),
		// gameBoard.getPlayer(j).getY()).performOnPlayer(j);
		// }


//		for(int j=0; j<2; j++){//Loopar igenom spelarens placering och ser om han ska dö på rutan han är
//			gameBoard.getTile(gameBoard.getPlayer(j).getX(), gameBoard.getPlayer(j).
//					getY()).performOnPlayer(j);
//		}

	}

	@Override
	public int getID() {
		return stateID;
	}

}
