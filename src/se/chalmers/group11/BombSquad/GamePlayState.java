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


	Image bomb = null;
	Image player = null;
	int stateID = 1;

	Image bombImage = null;
	Image grassImage = null;
	Image treeImage = null;
	Image extraFirePower = null;


	private int counter = 50;

	private Animation sprite, up, down, left, right;
	// private Player playerOne = new Player();
	// we don�t use this for now!
	private Game game;

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

		bombImage = new Image("Images/Bomb.jpg");
		grassImage = new Image("Images/grass.jpg");
		treeImage = new Image("Images/treeBox.jpg");
		extraFirePower = new Image("Images/extraFire.jpg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		for (int i = 0; i < /*game.getBoard().getSideLength()*/5; i++) {
			for (int j = 0; j < /*game.getBoard().getSideLength()*/5; j++) {
				if (game.getBoard().getTile(i, j) instanceof BombTile) {
					bombImage.draw(game.getBombX() * 60,
							game.getBombY() * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof EmptyTile) {
					grassImage.getScaledCopy(0.08f)
							.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof BoxTile) {
					treeImage.getScaledCopy(1).draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof PowerItemTile) {
					extraFirePower.draw(i * 60, j * 60, 60, 60);
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			sprite.draw(game.getPlayer(i).getX() * 60, game
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

				game.setPlayerPosition(0, -1, 0);
			}
			if (input.isKeyDown(Input.KEY_UP)) {
				sprite = up;

				game.setPlayerPosition(0, -1, 0);
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
				sprite = left;
				game.setPlayerPosition(-1, 0, 0);
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
				sprite = down;
				game.setPlayerPosition(0, 1, 0);
			}
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				sprite = right;
				game.setPlayerPosition(1, 0, 0);
			}
			if (input.isKeyDown(Input.KEY_SPACE)) {
				game.setBomb(0);
				// playerOne.releaseBomb();
			}
			// System.out.println(gameBoard.getPlayerX() + " " +
			// gameBoard.getPlayerY());
			if (input.isKeyDown(Input.KEY_W)) {
				sprite = up;
				game.setPlayerPosition(0, -1, 1);
			}
			if (input.isKeyDown(Input.KEY_A)) {
				sprite = left;
				game.setPlayerPosition(-1, 0, 1);
			}
			if (input.isKeyDown(Input.KEY_S)) {
				sprite = down;
				game.setPlayerPosition(0, 1, 1);
			}
			if (input.isKeyDown(Input.KEY_D)) {
				sprite = right;
				game.setPlayerPosition(1, 0, 1);
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				game.setBomb(1);
				// playerOne.releaseBomb();
			}
			counter = 45;
		}


		 for (int j = 0; j < 2; j++) {// Loopar igenom spelarens placering och
		 // ser om han ska d� p� rutan han �r
//		 game.getBoard().getTile(game.getPlayer(j).getX(),
//		 game.getPlayer(j).getY()).performOnPlayer(j);
//		 GameTile t = game.getPlayer(j).getX();
		 }


//		for(int j=0; j<2; j++){//Loopar igenom spelarens placering och ser om han ska d� p� rutan han �r
//			gameBoard.getTile(gameBoard.getPlayer(j).getX(), gameBoard.getPlayer(j).
//					getY()).performOnPlayer(j);
//		}

	}

	@Override
	public int getID() {
		return stateID;
	}

}
