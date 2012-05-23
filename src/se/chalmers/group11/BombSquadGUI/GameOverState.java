package se.chalmers.group11.bombsquadgui;

import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.core.GameOptions;
import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;

import se.chalmers.group11.main.Main;
import se.chalmers.group11.utils.SpriteSheets;

/**
 * A menu state that represent the GUI for gameOver state, from here you can
 * choose between exit game, restart match or go back to the main menu state
 * 
 * @author Marcus Thyrén
 * @author Anton Palmqvist, added EventBus methods and GUI-code.
 * 
 * 
 */
public class GameOverState extends BasicGameState implements IEventHandler {

	private int stateID; // Interface requires a gettable stateID, see getID()
	private int menuX = 320;
	private int menuY = 490;
	private int restartX = 485;
	private int restartY = 490;
	private int exitX = 0;
	private int exitY = 550;
	private int resetX = 155;
	private int resetY = 490;

	private Integer loser;

	private float exitImageScale = 1;
	private float restartImageScale = 1;
	private float menuImageScale = 1;
	private float resetImageScale = 1;
	private float scaleStep = 0.0001f;

	private Image restartImage = null;
	private Image exitImage = null;
	private Image menuImage = null;
	private Image winnerPlayer1 = null;
	private Image winnerPlayer2 = null;
	private Image resetScore = null;
	private Image podium = null;

	private final Integer[] playerWins = new Integer[2];

	private TrueTypeFont font;

	private String winnerSkin;
	private String loserSkin;

	public GameOverState(int stateID) {
		this.stateID = stateID;
		EventBus.INSTANCE.register(this);
		playerWins[0] = new Integer(0);
		playerWins[1] = new Integer(0);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		restartImage = new Image("Images/playAgain.png");
		exitImage = new Image("Images/exit.png");
		menuImage = new Image("Images/menuButton.png");
		winnerPlayer1 = new Image("Images/One.png");
		winnerPlayer2 = new Image("Images/Two.png");
		resetScore = new Image("Images/resetScore.png");
		podium = new Image("Images/podium.png");
		font = new TrueTypeFont(new Font("Arial", Font.BOLD, 16), true);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if (loser == 1) {
			winnerPlayer2.draw(0, 0, 1);
		}
		if (loser == 2) {
			winnerPlayer1.draw(0, 0, 1);
		}
		podium.draw(0, 200, 1);
		restartImage.draw(restartX, restartY, restartImageScale);
		exitImage.draw(exitX, exitY, exitImageScale);
		menuImage.draw(menuX, menuY, menuImageScale);
		resetScore.draw(resetX, resetY, resetImageScale);
		font.drawString(10, 10, "Player 1's Score: " + playerWins[0]);
		font.drawString(500, 10, "Player 2's Score: " + playerWins[1]);
		new SpriteSheets(winnerSkin).drawAnimation(295, 180, 90, 90);
		new SpriteSheets(loserSkin).drawAnimation(440, 335, 60, 60);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideRestartGame = false;
		boolean insideExitGame = false;
		boolean insideMenuGame = false;
		boolean insideResetScore = false;

		if (mouseX >= restartX && mouseX <= restartX + 150
				&& mouseY >= restartY && mouseY <= restartY + 150) {
			insideRestartGame = true;

		} else if (mouseX >= exitX && mouseX <= exitX + 150 && mouseY >= exitY
				&& mouseY <= exitY + 150) {
			insideExitGame = true;

		} else if (mouseX >= menuX && mouseX <= menuX + 150 && mouseY >= menuY
				&& mouseY <= menuY + 150) {
			insideMenuGame = true;
		} else if (mouseX >= resetX && mouseX <= resetX + 150
				&& mouseY >= resetY && mouseY <= resetY + 150) {
			insideResetScore = true;
		}

		// keeps track of the cursor location
		if (insideRestartGame) {
			if (restartImageScale < 1.1f) {
				restartImageScale += scaleStep * delta;
			}
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sbg.enterState(Main.GAMEPLAYSTATE);
			}
		} else {
			if (restartImageScale > 1f) {
				restartImageScale -= scaleStep * delta;
			}
		}
		if (insideMenuGame) {
			if (menuImageScale < 1.1f) {
				menuImageScale += scaleStep * delta;
			}
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sbg.enterState(Main.SPLASHSCREENSTATE);
			}
		} else {

			if (menuImageScale > 1f) {
				menuImageScale -= scaleStep * delta;
			}
		}
		if (insideExitGame) {
			if (exitImageScale < 1.1f) {
				exitImageScale += scaleStep * delta;
			}
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				gc.exit();
			}
		} else {
			if (exitImageScale > 1f)
				exitImageScale -= scaleStep * delta;
		}
		if (insideResetScore) {
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				resetPlayerWins();
			}

			if (resetImageScale < 1.1f)
				resetImageScale += scaleStep * delta;
		} else {
			if (resetImageScale > 1f)
				resetImageScale -= scaleStep * delta;
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(Main.SPLASHSCREENSTATE);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

	/**
	 * playerNumber one represents playerIndex zero
	 * 
	 * @param playerNumber
	 *            variable representing one of the two players
	 * @return playerWins number of wins a player has
	 */
	public Integer getPlayerWins(int playerNumber) {
		return playerWins[playerNumber - 1];
	}

	public void resetPlayerWins() {
		playerWins[0] = 0;
		playerWins[1] = 0;
	}

	@Override
	public void onEvent(Event evt) {
		if (evt.getTag() == Event.Tag.PLAYER_KILLED) {
			loser = (Integer) evt.getValue();
			playerWins[loser % 2] += 1; // loser%2 equals the arraynumber of the
										// winner
			if (loser == 2) {
				winnerSkin = GameOptions.getInstance().getPlayerOneSkin();
				loserSkin = GameOptions.getInstance().getPlayerTwoSkin();
			}
			if (loser == 1) {
				winnerSkin = GameOptions.getInstance().getPlayerTwoSkin();
				loserSkin = GameOptions.getInstance().getPlayerOneSkin();
			}
		}
	}
}