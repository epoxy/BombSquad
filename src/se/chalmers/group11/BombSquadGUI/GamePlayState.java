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

public class GamePlayState extends BasicGameState implements IEventHandler{

	private int stateID = 1;

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
	private int enemyDelayer = 1;
	private StateBasedGame sb;

	private LoserKeeper t = null;
	private InitMusic music = null;
	private InitSound sound = null;

	public GamePlayState(int stateID){
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

		sprite1 = new SpriteSheets("anton");
		sprite2 = new SpriteSheets("mackan");
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

		sprite1.drawAnimation(game.getPlayer(0).getX() * 60, game.getPlayer(0)
				.getY() * 60, 60, 60);

		sprite2.drawAnimation(game.getPlayer(1).getX() * 60, game.getPlayer(1)
				.getY() * 60, 60, 60);

		sprite3.drawAnimation(game.getEnemy().getX() * 60, game.getEnemy()
				.getY() * 60, 60, 60);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_UP)) {
			sprite1.animationUp();
			game.setPlayerPosition(0, -1, 0);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			sprite1.animationLeft();
			game.setPlayerPosition(-1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			sprite1.animationDown();
			game.setPlayerPosition(0, 1, 0);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			sprite1.animationRight();
			game.setPlayerPosition(1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			game.setBomb(0);
		}
		if (input.isKeyPressed(Input.KEY_W)) {
			sprite2.animationUp();
			game.setPlayerPosition(0, -1, 1);
		}
		if (input.isKeyPressed(Input.KEY_A)) {
			sprite2.animationLeft();
			game.setPlayerPosition(-1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_S)) {
			sprite2.animationDown();
			game.setPlayerPosition(0, 1, 1);
		}
		if (input.isKeyPressed(Input.KEY_D)) {
			sprite2.animationRight();
			game.setPlayerPosition(1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_LCONTROL)) {
			game.setBomb(1);
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(Main.SPLASHSCREENSTATE);
		}

		for (int j = 0; j < 2; j++) {// Loopar igenom spelarens placering och
			// ser om han ska d� p� rutan han �r
			game.getBoard()
					.getTile(game.getPlayer(j).getX(), game.getPlayer(j).getY())
					.performOnPlayer(game.getPlayer(j));
		}
		
		//Checks the enemyposition and kills the enemy if there is fire there
		game.getBoard().getTile(game.getEnemy().getX(), game.getEnemy().getY())
		.performOnEnemy();
		
		for (int j = 0; j < 2; j++) {// Loops through the players positions and 
			//checks if it corresponds with position of enemy, If so, kill player
			if(game.getPlayer(j).getX()==game.getEnemy().getX() && 
			game.getPlayer(j).getY()==game.getEnemy().getY()){
				EventBus.INSTANCE.publish(new Event(Event.Tag.PLAYER_KILLED, 
						game.getPlayer(j).getPlayerNumber()));
			}
		}
		
		enemyDelayer++;
		if (enemyDelayer % 50 == 1) {
			game.moveEnemyRandomly();
			enemyDelayer = 1;
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
		EventBus.INSTANCE.publish(new Event(Event.Tag.MUSIC_STARTER, 4));
		game = new Game(GameOptions.getInstance().getBoard());
		game.getPlayer(0).put(0, 0);
		game.getPlayer(1).put(10, 10);
		sprite1 = new SpriteSheets(GameOptions.getInstance().getPlayerOneSkin());
		sprite2 = new SpriteSheets(GameOptions.getInstance().getPlayerTwoSkin());
		// this.sb=sb;
	}

	@Override
	public void leave(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		super.enter(gc, sb);
		EventBus.INSTANCE.publish(new Event(Event.Tag.MUSIC_STOPPER, 3));
		EventBus.INSTANCE.publish(new Event(Event.Tag.WINNINGMUSIC_STARTER, 4));
	}

	@Override
	public void onEvent(Event evt) {
		if(evt.getTag()==Tag.ENEMYSPRITE_DOWN){
			sprite3.animationDown();
		}
		if(evt.getTag()==Tag.ENEMYSPRITE_UP){
			sprite3.animationUp();
		}
		if(evt.getTag()==Tag.ENEMYSPRITE_RIGHT){
			sprite3.animationRight();
		}
		if(evt.getTag()==Tag.ENEMYSPRITE_LEFT){
			sprite3.animationLeft();
		}
	}
}
