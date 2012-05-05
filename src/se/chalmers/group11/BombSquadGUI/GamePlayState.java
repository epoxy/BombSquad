package se.chalmers.group11.BombSquadGUI;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.core.BlockTile;
import se.chalmers.group11.core.Board;
import se.chalmers.group11.core.BombTile;
import se.chalmers.group11.core.BoxTile;
import se.chalmers.group11.core.EmptyTile;
import se.chalmers.group11.core.ExtraBombsTile;
import se.chalmers.group11.core.FireTile;
import se.chalmers.group11.core.Game;
import se.chalmers.group11.core.IBoard;
import se.chalmers.group11.core.PowerItemTile;
import se.chalmers.group11.main.Main;
import se.chalmers.group11.utils.InitSound;
import se.chalmers.group11.utils.SpriteSheets;

public class GamePlayState extends BasicGameState {

	Image bomb = null;
	Image player = null;
	int stateID = 1;

	Image bombImage = null;
	Image grassImage = null;
	Image treeImage = null;
	Image extraFirePower = null;
	Image blockImage = null;
	Image extrabomb = null;
	Image fireImage = null;

	InitSound sound = null;

	private SpriteSheets sprite;
	private Game game;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// game = Game.getInstance(MainMenuState.getBoard());
		// game.getPlayer(0).put(0, 0);//Reset Playerpositions Funkar inte! TODO
		// game.getPlayer(1).put(10, 10);

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
		bombImage = new Image("Images/Bomb.png");
		grassImage = new Image("Images/grass.jpg");
		treeImage = new Image("Images/treeBox.jpg");
		extraFirePower = new Image("Images/extraFire.jpg");
		blockImage = new Image("Images/rocks.png");
		extrabomb = new Image("Images/rocket.png");
		fireImage = new Image("Images/Fire.png");
		sound = new InitSound();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		for (int i = 0; i < game.getBoard().getSideLength(); i++) {
			for (int j = 0; j < game.getBoard().getSideLength(); j++) {
				if (game.getBoard().getTile(i, j) instanceof BombTile) {
					bombImage.draw(i * 60, j * 60, 60, 60);
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
				if (game.getBoard().getTile(i, j) instanceof BlockTile) {
					blockImage.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof ExtraBombsTile) {
					extrabomb.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof FireTile) {
					fireImage.draw(i * 60, j * 60, 60, 60);
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			sprite.drawAnimation(game.getPlayer(i).getX() * 60,
					game.getPlayer(i).getY() * 60, 60, 60);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_UP)) {
			sprite.AnimationUp();
			game.setPlayerPosition(0, -1, 0);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			sprite.AnimationLeft();
			game.setPlayerPosition(-1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			sprite.AnimationDown();
			game.setPlayerPosition(0, 1, 0);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			sprite.AnimationRight();
			game.setPlayerPosition(1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			sound.startPlayBombSound();
			game.setBomb(0);
		}
		if (input.isKeyPressed(Input.KEY_W)) {
			sprite.AnimationUp();
			game.setPlayerPosition(0, -1, 1);
		}
		if (input.isKeyPressed(Input.KEY_A)) {
			sprite.AnimationDown();
			game.setPlayerPosition(-1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_S)) {
			sprite.AnimationDown();
			game.setPlayerPosition(0, 1, 1);
		}
		if (input.isKeyPressed(Input.KEY_D)) {
			sprite.AnimationRight();
			game.setPlayerPosition(1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_Q)) {
			sound.startPlayBombSound();
			game.setBomb(1);
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(Main.GAMEOVERSTATE);
		}

		for (int j = 0; j < 2; j++) {// Loopar igenom spelarens placering och
										// ser om han ska dö på rutan han är
			game.getBoard()
					.getTile(game.getPlayer(j).getX(), game.getPlayer(j).getY())
					.performOnPlayer(game.getPlayer(j), sbg);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void enter(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		super.enter(gc, sb);
		game = new Game(ChooseBoarderState.getBoard());
		game.getPlayer(0).put(0, 0);// Reset Playerpositions Funkar nu! TODO
		game.getPlayer(1).put(10, 10);

	}
}
