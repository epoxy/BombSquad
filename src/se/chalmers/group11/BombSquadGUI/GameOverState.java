package se.chalmers.group11.bombsquadgui;

import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.eventbus.IEventHandler;

import se.chalmers.group11.main.Main;


public class GameOverState extends BasicGameState implements IEventHandler{
	
	private int menuX = 0;
	private int menuY = 300;
	private int restartX = 200;
	private int restartY = 300;
	private int exitX = 425;
	private int exitY = 300;
	private Integer loser;

	private float exitImageScale = 1;
	private float restartImageScale = 1;
	private float menuImageScale = 1;
	private float scaleStep = 0.0001f;

	private Image restartImage = null;
	private Image exitImage = null;
	private Image menuImage = null;
	private Image winnerPlayer1 = null;
	private Image winnerPlayer2 = null;
	
	private final Integer[] playerWins = new Integer[2];
	
	int stateID = 2; //Förkalring
	
	public GameOverState(int stateID){
		this.stateID = stateID;
		EventBus.INSTANCE.register(this);
		playerWins[0] = new Integer(0);
		playerWins[1] = new Integer(0);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		restartImage = new Image("Images/reset.jpg");
		exitImage = new Image("Images/exit.jpg");
		menuImage = new Image("Images/menubutton.jpg");
		winnerPlayer1 = new Image("Images/One.png");
		winnerPlayer2 = new Image("Images/Two.png");
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		restartImage.draw(restartX, restartY, restartImageScale);
		exitImage.draw(exitX, exitY, exitImageScale);
		menuImage.draw(menuX, menuY, menuImageScale);
		if(loser==1){
			winnerPlayer2.draw(20, 20, menuImageScale);
		}
		if(loser==2){
			winnerPlayer1.draw(20, 20, menuImageScale);
		}
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
		
		if (mouseX >= restartX && mouseX <= restartX + 150
				&& mouseY >= restartY
				&& mouseY <= restartY + 150) {
			insideRestartGame = true;

		} else if (mouseX >= exitX && mouseX <= exitX + 150
				&& mouseY >= exitY 
				&& mouseY <= exitY + 150) {
			insideExitGame = true;
			
		} else if (mouseX >= menuX && mouseX <= menuX + 150
				&& mouseY >= menuY 
				&& mouseY <= menuY + 150) {
			insideMenuGame = true;
		}	
		//keeps track of the cursor location
		if (insideRestartGame) {
			if (restartImageScale < 1.1f)
				restartImageScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				game.enterState(Main.GAMEPLAYSTATE);
			}
		} else {

			if (restartImageScale > 1f) {
				restartImageScale -= scaleStep * delta;

			}
			if (insideMenuGame) {
				if (menuImageScale < 1.1f)
					menuImageScale += scaleStep * delta;

				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					game.enterState(Main.SPLASHSCREENSTATE);
				}
			} else {

				if (menuImageScale > 1f) {
					menuImageScale -= scaleStep * delta;

				}
			
			if (insideExitGame) {
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
					container.exit();

				if (exitImageScale < 1.1f)
					exitImageScale += scaleStep * delta;
			} else {
				if (exitImageScale > 1f)
					exitImageScale -= scaleStep * delta;
				}
			}
		}
	}	
	@Override
	public int getID() {
		return stateID;
	}
	@Override
	public void onEvent(Event evt) {
		if(evt.getTag()==Event.Tag.PLAYER_KILLED){
			loser=(Integer)evt.getValue(); 
			playerWins[loser-1]+=1;
			System.out.println("\nAntal förluster p1: " + playerWins[0] + "\nAntal förluster p2: " + playerWins[1] + "\n");
		}
	}
}