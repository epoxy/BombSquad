package se.chalmers.group11.bombsquadgui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.core.BlockTile;
import se.chalmers.group11.core.BombTile;
import se.chalmers.group11.core.BoxTile;
import se.chalmers.group11.core.EmptyTile;
import se.chalmers.group11.core.ExtraBombsTile;
import se.chalmers.group11.core.FireTile;
import se.chalmers.group11.core.Game;
import se.chalmers.group11.core.GameOptions;
import se.chalmers.group11.core.ExtraFirePowerTile;
import se.chalmers.group11.core.LoserKeeper;
import se.chalmers.group11.core.WaterTile;
import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.Event.Tag;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;
import se.chalmers.group11.main.Main;
import se.chalmers.group11.utils.InitMusic;
import se.chalmers.group11.utils.InitSound;
import se.chalmers.group11.utils.SpriteSheets;

/**
 * A state that handles the GUI for the game BombSquad and also the controller,
 * takes care of the input from the user
 * 
 * 
 */
public class GamePlayState extends BasicGameState implements IEventHandler {

	private int stateID; // Interface requires a gettable stateID, see getID()
	private Image bombImage = null;
	private Image grassImage = null;
	private Image boxImage = null;
	private Image fireUpImage = null;
	private Image blockImage = null;
	private Image bombUpImage = null;
	private Image fireImage = null;
	private Image waterImage = null;

	private SpriteSheets sprite1;
	private SpriteSheets sprite2;
	private SpriteSheets sprite3;
	private Game game;
	private int enemyDelay = 1;
	private StateBasedGame sbg;

	private LoserKeeper t = null;
	private InitMusic music = null;
	private InitSound sound = null;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
		EventBus.INSTANCE.register(this);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

		bombImage = new Image("Images/Bomb.png");
		grassImage = new Image("Images/grass.jpg");
		boxImage = new Image("Images/treeBox.jpg");
		fireUpImage = new Image("Images/extrafire.png");
		blockImage = new Image("Images/rocks.png");
		bombUpImage = new Image("Images/rocket.png");
		fireImage = new Image("Images/Fire.png");
		waterImage = new Image("Images/tile_water.jpg");
		sound = new InitSound();

		sprite1 = new SpriteSheets("Anton");
		sprite2 = new SpriteSheets("Anton");
		sprite3 = new SpriteSheets("Devil");
		t = new LoserKeeper(sbg);
		music = new InitMusic();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		for (int i = 0; i < game.getBoard().getSideLength(); i++) {
			for (int j = 0; j < game.getBoard().getSideLength(); j++) {
				if (game.getBoard().getTile(i, j) instanceof BombTile) {
					grassImage.getScaledCopy(0.08f)
							.draw(i * 60, j * 60, 60, 60);
					bombImage.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof EmptyTile) {
					grassImage.getScaledCopy(0.08f)
							.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof BoxTile) {
					boxImage.getScaledCopy(1).draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof ExtraFirePowerTile) {
					grassImage.getScaledCopy(0.08f)
							.draw(i * 60, j * 60, 60, 60);
					fireUpImage.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof BlockTile) {
					blockImage.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof ExtraBombsTile) {
					grassImage.getScaledCopy(0.08f)
							.draw(i * 60, j * 60, 60, 60);
					bombUpImage.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof FireTile) {
					grassImage.getScaledCopy(0.08f)
							.draw(i * 60, j * 60, 60, 60);
					fireImage.draw(i * 60, j * 60, 60, 60);
				}
				if (game.getBoard().getTile(i, j) instanceof WaterTile) {
					waterImage.draw(i * 60, j * 60, 60, 60);
				}
			}
		}

		sprite1.drawAnimation(game.getPlayer(1).getPosition().getX() * 60, game
				.getPlayer(1).getPosition().getY() * 60, 60, 60);

		sprite2.drawAnimation(game.getPlayer(2).getPosition().getX() * 60, game
				.getPlayer(2).getPosition().getY() * 60, 60, 60);

		sprite3.drawAnimation(game.getEnemy().getPosition().getX() * 60, game
				.getEnemy().getPosition().getY() * 60, 60, 60);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_UP)) {
			sprite1.animationUp();
			game.movePlayer(0, -1, 1);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			sprite1.animationLeft();
			game.movePlayer(-1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			sprite1.animationDown();
			game.movePlayer(0, 1, 1);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			sprite1.animationRight();
			game.movePlayer(1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			game.putBomb(1);
		}
		if (input.isKeyPressed(Input.KEY_W)) {
			sprite2.animationUp();
			game.movePlayer(0, -1, 2);
		}
		if (input.isKeyPressed(Input.KEY_A)) {
			sprite2.animationLeft();
			game.movePlayer(-1, 0, 2);
		}
		if (input.isKeyPressed(Input.KEY_S)) {
			sprite2.animationDown();
			game.movePlayer(0, 1, 2);
		}
		if (input.isKeyPressed(Input.KEY_D)) {
			sprite2.animationRight();
			game.movePlayer(1, 0, 2);
		}
		if (input.isKeyPressed(Input.KEY_LCONTROL)) {
			game.putBomb(2);
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(Main.SPLASHSCREENSTATE);
		}

		for (int j = 1; j <= 2; j++) {// Loopar igenom spelarens placering och
			// ser om han ska dö på rutan han är
			game.getBoard()
					.getTile(game.getPlayer(j).getPosition().getX(),
							game.getPlayer(j).getPosition().getY())
					.performOnPlayer(game.getPlayer(j));
		}

		// Checks the enemyposition and kills the enemy if there is fire there
		game.getBoard()
				.getTile(game.getEnemy().getPosition().getX(),
						game.getEnemy().getPosition().getY()).performOnEnemy();

		for (int j = 1; j <= 2; j++) {// Loops through the players positions and
			// checks if it corresponds with position of enemy, If so, kill
			// player
			if (game.getPlayer(j).getPosition()
					.equals(game.getEnemy().getPosition())) {
				EventBus.INSTANCE.publish(new Event(Event.Tag.PLAYER_KILLED,
						game.getPlayer(j).getPlayerNumber()));
			}
		}

		enemyDelay++;
		if (enemyDelay % 50 == 1) {
			game.moveEnemyRandomly();
			enemyDelay = 1;
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void enter(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		super.enter(gc, sbg);
		EventBus.INSTANCE.publish(new Event(Event.Tag.MUSIC_STARTER));
		game = new Game(GameOptions.getInstance().getBoard());
		game.getPlayer(2).put(0, 0);
		game.getPlayer(1).put(10, 10);
		sprite1 = new SpriteSheets(GameOptions.getInstance().getPlayerOneSkin());
		sprite2 = new SpriteSheets(GameOptions.getInstance().getPlayerTwoSkin());
	}

	@Override
	public void leave(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		super.enter(gc, sbg);
		EventBus.INSTANCE.publish(new Event(Event.Tag.MUSIC_STOPPER));
		EventBus.INSTANCE.publish(new Event(Event.Tag.WINNINGMUSIC_STARTER));
	}

	@Override
	public void onEvent(Event evt) {
		if (evt.getTag() == Tag.ENEMYSPRITE_DOWN) {
			sprite3.animationDown();
		}
		if (evt.getTag() == Tag.ENEMYSPRITE_UP) {
			sprite3.animationUp();
		}
		if (evt.getTag() == Tag.ENEMYSPRITE_RIGHT) {
			sprite3.animationRight();
		}
		if (evt.getTag() == Tag.ENEMYSPRITE_LEFT) {
			sprite3.animationLeft();
		}
	}
}
