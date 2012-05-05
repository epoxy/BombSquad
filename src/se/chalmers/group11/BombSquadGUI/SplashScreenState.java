package se.chalmers.group11.BombSquadGUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.core.Board;
import se.chalmers.group11.core.BoardEmpty;
import se.chalmers.group11.core.Game;
import se.chalmers.group11.core.IBoard;
import se.chalmers.group11.main.Main;

public class SplashScreenState extends BasicGameState {

	private int startX = 440;
	private int startY = 150;
	private int exitX = 440;
	private int exitY = 550;


	private float exitImageScale = 1;
	private float startImageScale = 0.5f;
	private float scaleStep = 0.0001f;

	int stateID = 3;
	private Image startImage = null;
	private Image exitImage = null;
	
	public SplashScreenState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		startImage = new Image("Images/start.png");
		exitImage = new Image("Images/exit.jpg");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		startImage.draw(startX, startY, startImageScale);
		exitImage.draw(exitX, exitY, exitImageScale);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideStartGame = false;
		boolean insideExitGame = false;

		if (mouseX >= startX && mouseX <= startX + startImage.getWidth()
				&& mouseY >= startY
				&& mouseY <= startY + startImage.getHeight()) {
			insideStartGame = true;

		} else if (mouseX >= exitX && mouseX <= exitX + exitImage.getWidth()
				&& mouseY >= exitY && mouseY <= exitY + exitImage.getHeight()) {
			insideExitGame = true;
		}
		if (insideStartGame) {
			if (startImageScale < 0.55f)
				startImageScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sb.enterState(Main.CHOOSEBOARDERSTATE);
			}
		} else {

			if (startImageScale > 0.5f) {
				startImageScale -= scaleStep * delta;

			}
		}
		if (insideExitGame) {
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				gc.exit();
			}

			if (exitImageScale < 1.05f){
				exitImageScale += scaleStep * delta;
			} else {
				if (exitImageScale > 1.0f)
					exitImageScale -= scaleStep * delta;
			}
		}
	}
	@Override
	public int getID() {
		return stateID;
	}
//	public void enter(GameContainer gc, StateBasedGame sb) throws SlickException
//    {
//        super.enter(gc, sb);
//        iB = new Board();
//	}
}