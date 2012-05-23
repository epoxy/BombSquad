package se.chalmers.group11.bombsquadgui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

//import se.chalmers.group11.core.Game;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.main.Main;
import se.chalmers.group11.utils.InitMusic;

/**
 * A state that represent the GUI for our main menu, from here you can start the
 * game or exit the game
 * 
 * 
 */
public class SplashScreenState extends BasicGameState {

	private int stateID; // Interface requires a gettable stateID, see getID()
	private int startX = 300;
	private int startY = 475;
	private int exitX = 10;
	private int exitY = 578;

	private float exitImageScale = 1;
	private float startImageScale = 1;
	private float scaleStep = 0.0001f; // How fast the scale will increase or
										// decrease

	private Image startImage = null;
	private Image exitImage = null;
	private Image splashImage = null;

	public SplashScreenState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		startImage = new Image("Images/start.png");
		exitImage = new Image("Images/exit.png");
		splashImage = new Image("Images/BombSquad.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		splashImage.draw(0, 0, 1); // constant placement and scale, no need for
									// variables
		startImage.draw(startX, startY, startImageScale);
		exitImage.draw(exitX, exitY, exitImageScale);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideStartGame = false;
		boolean insideExitGame = false;

		// Checks if the mousepointer is at the startbutton
		if (mouseX >= startX && mouseX <= startX + startImage.getWidth()
				&& mouseY >= startY
				&& mouseY <= startY + startImage.getHeight()) {
			insideStartGame = true;

			// Checks if the mousepointer is at the exitbutton
		} else if (mouseX >= exitX && mouseX <= exitX + exitImage.getWidth()
				&& mouseY >= exitY && mouseY <= exitY + exitImage.getHeight()) {
			insideExitGame = true;
		}

		// Increase imagesize if mousepointer is at startImagepicture
		if (insideStartGame) {
			if (startImageScale < 1.05f)
				startImageScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sbg.enterState(Main.CHOOSECHARACTERSTATE);
			}

			// Decrease imagesize if mousepointer is not at startImagepicture
		} else {
			if (startImageScale > 1) {
				startImageScale -= scaleStep * delta;
			}
		}
		if (insideExitGame) {
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				gc.exit();
			}
			if (exitImageScale < 1.05f) {
				exitImageScale += scaleStep * delta;
			}
		} else {
			if (exitImageScale > 1.0f) {
				exitImageScale -= scaleStep * delta;
			}
			if (input.isKeyPressed(Input.KEY_ESCAPE)) {
				gc.exit();
			}
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

	public void enter(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		EventBus.INSTANCE.publish(new Event(Event.Tag.MENUMUSIC_STARTER));
	}
}