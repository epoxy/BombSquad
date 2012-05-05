package se.chalmers.group11.BombSquadGUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.main.Main;


public class GameOverState extends BasicGameState {
	
	private int menuX = 0;
	private int menuY = 0;
	private int restartX = 200;
	private int restartY = 300;
	private int exitX = 500;
	private int exitY = 500;

	private float exitImageScale = 1;
	private float restartImageScale = 1;
	private float menuImageScale = 1;
	private float scaleStep = 0.0001f;

	private Image restartImage = null;
	private Image exitImage = null;
	private Image menuImage = null;
	
	int stateID = 2;
	
	public GameOverState(int stateID){
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		restartImage = new Image("Images/reset.jpg");
		exitImage = new Image("Images/exit.jpg");
		menuImage = new Image("Images/menubutton.jpg");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		restartImage.draw(restartX, restartY, restartImageScale);
		exitImage.draw(exitX, exitY, exitImageScale);
		menuImage.draw(menuX, menuY, menuImageScale);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input = container.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideRestartGame = false;
		boolean insideExitGame = false;
		boolean insideMenuGame = false;
		
		if (mouseX >= restartX && mouseX <= restartX + restartImage.getWidth()
				&& mouseY >= restartY
				&& mouseY <= restartY + restartImage.getHeight()) {
			insideRestartGame = true;

		} else if (mouseX >= exitX && mouseX <= exitX + exitImage.getWidth()
				&& mouseY >= exitY 
				&& mouseY <= exitY + exitImage.getHeight()) {
			insideExitGame = true;
			
		} else if (mouseX >= menuX && mouseX <= menuX + menuImage.getWidth()
				&& mouseY >= menuY 
				&& mouseY <= menuY + menuImage.getHeight()) {
			insideMenuGame = true;
		}	
		//keeps track of the cursor location
		if (insideRestartGame) {
			if (restartImageScale < 1)
				restartImageScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				game.enterState(Main.GAMEPLAYSTATE);
			}
		} else {

			if (restartImageScale > 0.5f) {
				restartImageScale -= scaleStep * delta;

			}
			if (insideMenuGame) {
				if (menuImageScale < 1)
					menuImageScale += scaleStep * delta;

				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					game.enterState(Main.CHOOSEBOARDERSTATE);
				}
			} else {

				if (menuImageScale > 0.5f) {
					menuImageScale -= scaleStep * delta;

				}
			
			if (insideExitGame) {
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
					container.exit();

				if (exitImageScale < 0.85f)
					exitImageScale += scaleStep * delta;
			} else {
				if (exitImageScale > 1.0f)
					exitImageScale -= scaleStep * delta;
				}
			
			}
		}
	}	
	@Override
	public int getID() {
		return stateID;
	}
}