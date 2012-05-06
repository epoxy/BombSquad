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
import se.chalmers.group11.core.BoardClassic;
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

	private SpriteSheets sprite1;
	private SpriteSheets sprite2;
	private SpriteSheets sprite3;
	private Game game;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	
		bombImage = new Image("Images/Bomb.png");
		grassImage = new Image("Images/grass.jpg");
		treeImage = new Image("Images/treeBox.jpg");
		extraFirePower = new Image("Images/extraFire.jpg");
		blockImage = new Image("Images/rocks.png");
		extrabomb = new Image("Images/rocket.png");
		fireImage = new Image("Images/Fire.png");
		sound = new InitSound();
		sprite1 = new SpriteSheets();
		sprite2 = new SpriteSheets();
		sprite3 = new SpriteSheets();
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
		
			sprite1.drawAnimation(game.getPlayer(0).getX() * 60,
					game.getPlayer(0).getY() * 60, 60, 60);
		
			sprite2.drawAnimation(game.getPlayer(1).getX() * 60,
					game.getPlayer(1).getY() * 60, 60, 60);
			
			sprite3.drawAnimation(game.getEnemy().getX() * 60,
					game.getEnemy().getY() * 60, 60, 60);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_UP)) {
			sprite1.AnimationUp();
			game.setPlayerPosition(0, -1, 0);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			sprite1.AnimationLeft();
			game.setPlayerPosition(-1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			sprite1.AnimationDown();
			game.setPlayerPosition(0, 1, 0);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			sprite1.AnimationRight();
			game.setPlayerPosition(1, 0, 0);
		}
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			sound.startPlayBombSound();
			game.setBomb(0);
		}
		if (input.isKeyPressed(Input.KEY_W)) {
			sprite2.AnimationUp();
			game.setPlayerPosition(0, -1, 1);
		}
		if (input.isKeyPressed(Input.KEY_A)) {
			sprite2.AnimationLeft();
			game.setPlayerPosition(-1, 0, 1);
		}
		if (input.isKeyPressed(Input.KEY_S)) {
			sprite2.AnimationDown();
			game.setPlayerPosition(0, 1, 1);
		}
		if (input.isKeyPressed(Input.KEY_D)) {
			sprite2.AnimationRight();
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
		game.moveEnemyRandomly();
		
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
