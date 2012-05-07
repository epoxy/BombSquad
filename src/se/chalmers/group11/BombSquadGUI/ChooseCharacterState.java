package se.chalmers.group11.BombSquadGUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.main.Main;

public class ChooseCharacterState extends BasicGameState {
	private int stateID;
	private int nextButtonX = 500;
	private int nextButtonY = 500;
	private int thumbsY = 120;
	private int p1DevilX = 50;
	private int p2DevilX = 360;
	private int p1BombManX = 120;
	private int p2BombManX = 430;
	private int p1GingerX = 190;
	private int p2GingerX = 500;
	private float nextButtonScale = 0.5f;
	private float nextButtonScaleStep = 0.0001f;
	private float p1DevilScale = 1.5f;
	private float p2DevilScale = 1.5f;
	private float p1BombManScale = 1.5f;
	private float p2BombManScale = 1.5f;
	private float p1GingerScale = 1.5f;
	private float p2GingerScale = 1.5f;
	private float thumbsScaleStep = 0.0005f;
	private Image nextButton;
	private Image playerOneText;
	private Image playerTwoText;
	private Image devil;
	private Image bombMan;
	private Image ginger;
	private static String playerOneSkin = "Devil";
	private static String playerTwoSkin = "BombMan";
	public ChooseCharacterState(int stateID) {
		this.stateID = stateID;

	}

	public static String getPlayerOneSkin(){
		return playerOneSkin;
		
	}
	public static String getPlayerTwoSkin(){
		return playerTwoSkin;
	}


	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		nextButton = new Image("Images/PlayerIcon.png");
		playerOneText = new Image("Images/playerOneText.png");
		playerTwoText = new Image("Images/playerTwoText.png");
		devil = new Image("Images/devilDOWN.gif");
		bombMan = new Image("Images/bombManDOWN.gif");
		ginger = new Image("Images/gingerDOWN.gif");

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		nextButton.draw(nextButtonX, nextButtonY, nextButtonScale);
		playerOneText.draw(50, 40);
		playerTwoText.draw(360, 40);
		devil.draw(p1DevilX, thumbsY, p1DevilScale);
		bombMan.draw(p1BombManX, thumbsY, p1BombManScale);
		ginger.draw(p1GingerX, thumbsY, p1GingerScale);
		devil.draw(p2DevilX, thumbsY, p2DevilScale);
		bombMan.draw(p2BombManX, thumbsY, p2BombManScale);
		ginger.draw(p2GingerX, thumbsY, p2GingerScale);


	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideNextButton = false;
		boolean insideP1Devil = false;
		boolean insideP2Devil = false;
		boolean insideP1BombMan = false;
		boolean insideP2BombMan = false;
		boolean insideP1Ginger = false;
		boolean insideP2Ginger = false;


		if (mouseX >= nextButtonX && mouseX <= nextButtonX + nextButton.getWidth()*nextButtonScale
				&& mouseY >= nextButtonY
				&& mouseY <= nextButtonY + nextButton.getHeight()*nextButtonScale) {
			insideNextButton = true;
		}
		if (mouseX >= p1DevilX && mouseX <= p1DevilX + devil.getWidth()*p1DevilScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + devil.getHeight()*p1DevilScale) {
			insideP1Devil = true;
		}
		if (mouseX >= p2DevilX && mouseX <= p2DevilX + devil.getWidth()*p2DevilScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + devil.getHeight()*p2DevilScale) {
			insideP2Devil = true;
		}
		if (mouseX >= p1BombManX && mouseX <= p1BombManX + bombMan.getWidth()*p1BombManScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + bombMan.getHeight()*p1BombManScale) {
			insideP1BombMan = true;
		}
		if (mouseX >= p2BombManX && mouseX <= p2BombManX + bombMan.getWidth()*p2BombManScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + bombMan.getHeight()*p2BombManScale) {
			insideP2BombMan = true;
		}
		if (mouseX >= p1GingerX && mouseX <= p1GingerX + ginger.getWidth()*p1GingerScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + ginger.getHeight()*p1GingerScale) {
			insideP1Ginger = true;
		}
		if (mouseX >= p2GingerX && mouseX <= p2GingerX + ginger.getWidth()*p2GingerScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + ginger.getHeight()*p2GingerScale) {
			insideP2Ginger = true;
		}



		if (insideNextButton) {
			if (nextButtonScale < 0.55f)
				nextButtonScale += nextButtonScaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sb.enterState(Main.CHOOSEBOARDERSTATE);
			}
		} else {

			if (nextButtonScale > 0.5f) {
				nextButtonScale -= nextButtonScaleStep * delta;

			}
		}
		if (insideP1Devil) {
			if (p1DevilScale < 1.65f)
				p1DevilScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				playerOneSkin = "Devil";		
			}
		} else {
			if (p1DevilScale > 1.5f) {
				p1DevilScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1BombMan) {
			if (p1BombManScale < 1.65f)
				p1BombManScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				playerOneSkin = "BombMan";	
				
			}
		} else {

			if (p1BombManScale > 1.5f) {
				p1BombManScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1Ginger) {
			if (p1GingerScale < 1.65f)
				p1GingerScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				playerOneSkin = "Ginger";	
				System.out.println("p1 ginger");
			}
		} else {
			if (p1GingerScale > 1.5f) {
				p1GingerScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Devil) {
			if (p2DevilScale < 1.65f)
				p2DevilScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				playerTwoSkin = "Devil";		
			}
		} else {
			if (p2DevilScale > 1.5f) {
				p2DevilScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2BombMan) {
			if (p2BombManScale < 1.65f)
				p2BombManScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				playerTwoSkin = "BombMan";			
			}
		} else {

			if (p2BombManScale > 1.5f) {
				p2BombManScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Ginger) {
			if (p2GingerScale < 1.65f)
				p2GingerScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				playerTwoSkin = "Ginger";			
				System.out.println("p2 ginger");
			}
		} else {
			if (p2GingerScale > 1.5f) {
				p2GingerScale -= thumbsScaleStep * delta;
			}
		}

	}
	


	@Override
	public int getID() {
		return stateID;
	}

}
