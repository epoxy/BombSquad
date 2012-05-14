package se.chalmers.group11.bombsquadgui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.core.GameOptions;
import se.chalmers.group11.main.Main;

public class ChooseCharacterState extends BasicGameState {
	private int stateID;
	private int nextButtonX = 500;
	private int nextButtonY = 500;
	private int thumbsY = 120;
	private int thumbsY2 = 200;
	private int p1DevilX = 50;
	private int p2DevilX = 360;
	private int p1BombManX = 120;
	private int p2BombManX = 430;
	private int p1GingerX = 190;
	private int p2GingerX = 500;
	private int p1KingX = 50;
	private int p2kingX = 360;
	private int p1manX = 120;
	private int p2manX = 430;
	private int p1mantwoX = 190;
	private int p2mantwoX = 500;
	private float nextButtonScale = 0.5f;
	private float nextButtonScaleStep = 0.0001f;
	private float p1DevilScale = 1.5f;
	private float p2DevilScale = 1.5f;
	private float p1BombManScale = 1.5f;
	private float p2BombManScale = 1.5f;
	private float p1GingerScale = 1.5f;
	private float p2GingerScale = 1.5f;
	private float p1KingScale = 1.5f;
	private float p2KingScale = 1.5f;
	private float p1ManScale = 1.5f;
	private float p2ManScale = 1.5f;
	private float p1ManTwoScale = 1.5f;
	private float p2ManTwoScale = 1.5f;
	private float thumbsScaleStep = 0.0005f;
	private Image nextButton;
	private Image playerOneText;
	private Image playerTwoText;
	private Image devil;
	private Image bombMan;
	private Image ginger;
	private Image king;
	private Image man;
	private Image manTwo;


	public ChooseCharacterState(int stateID) {
		this.stateID = stateID;

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
		king = new Image("Images/kingDOWN.gif");
		man = new Image("Images/manDOWN.gif");
		manTwo = new Image("Images/mantwoDOWN.gif");

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
		king.draw(p2kingX, thumbsY2, p2KingScale);
		king.draw(p1KingX, thumbsY2, p1KingScale);
		man.draw(p1manX, thumbsY2, p1ManScale);
		man.draw(p2manX, thumbsY2, p2ManScale);
		manTwo.draw(p1mantwoX, thumbsY2, p1ManTwoScale);
		manTwo.draw(p2mantwoX, thumbsY2, p2ManTwoScale);

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
		boolean insideP1king = false;
		boolean insideP2king = false;
		boolean insideP1man = false;
		boolean insideP2man = false;
		boolean insideP1manTwo = false;
		boolean insideP2manTwo = false;

		if (mouseX >= nextButtonX
				&& mouseX <= nextButtonX + nextButton.getWidth()
						* nextButtonScale
				&& mouseY >= nextButtonY
				&& mouseY <= nextButtonY + nextButton.getHeight()
						* nextButtonScale) {
			insideNextButton = true;
		}
		if (mouseX >= p1DevilX
				&& mouseX <= p1DevilX + devil.getWidth() * p1DevilScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + devil.getHeight() * p1DevilScale) {
			insideP1Devil = true;
		}
		if (mouseX >= p2DevilX
				&& mouseX <= p2DevilX + devil.getWidth() * p2DevilScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + devil.getHeight() * p2DevilScale) {
			insideP2Devil = true;
		}
		if (mouseX >= p1BombManX
				&& mouseX <= p1BombManX + bombMan.getWidth() * p1BombManScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + bombMan.getHeight() * p1BombManScale) {
			insideP1BombMan = true;
		}
		if (mouseX >= p2BombManX
				&& mouseX <= p2BombManX + bombMan.getWidth() * p2BombManScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + bombMan.getHeight() * p2BombManScale) {
			insideP2BombMan = true;
		}
		if (mouseX >= p1GingerX
				&& mouseX <= p1GingerX + ginger.getWidth() * p1GingerScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + ginger.getHeight() * p1GingerScale) {
			insideP1Ginger = true;
		}
		if (mouseX >= p2GingerX
				&& mouseX <= p2GingerX + ginger.getWidth() * p2GingerScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + ginger.getHeight() * p2GingerScale) {
			insideP2Ginger = true;
		}
		if (mouseX >= p1KingX
				&& mouseX <= p1KingX + king.getWidth() * p1KingScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + king.getHeight() * p1KingScale) {
			insideP1king = true;
		}
		if (mouseX >= p2kingX
				&& mouseX <= p2kingX + king.getWidth() * p2KingScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + king.getHeight() * p2KingScale) {
			insideP2king = true;
		}
		if (mouseX >= p1manX && mouseX <= p1manX + man.getWidth() * p1ManScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + man.getHeight() * p1ManScale) {
			insideP1man = true;
		}
		if (mouseX >= p2manX && mouseX <= p2manX + man.getWidth() * p2ManScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + man.getHeight() * p2ManScale) {
			insideP2man = true;
		}
		if (mouseX >= p1mantwoX
				&& mouseX <= p1mantwoX + man.getWidth() * p1ManScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + man.getHeight() * p1ManScale) {
			insideP1manTwo = true;
		}
		if (mouseX >= p2mantwoX
				&& mouseX <= p2mantwoX + man.getWidth() * p2ManScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + man.getHeight() * p2ManScale) {
			insideP2manTwo = true;
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
				GameOptions.getInstance().setPlayerOneSkin("Devil");
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
				GameOptions.getInstance().setPlayerOneSkin("BombMan");

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
				GameOptions.getInstance().setPlayerOneSkin("Ginger");
				
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
				GameOptions.getInstance().setPlayerTwoSkin("Devil");
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
				GameOptions.getInstance().setPlayerTwoSkin("BombMan");
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
				GameOptions.getInstance().setPlayerTwoSkin("Ginger");
				System.out.println("p2 ginger");
			}
		} else {
			if (p2GingerScale > 1.5f) {
				p2GingerScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1king) {
			if (p1KingScale < 1.65f)
				p1KingScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("king");
			}
		} else {
			if (p1KingScale > 1.5f) {
				p1KingScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2king) {
			if (p2KingScale < 1.65f)
				p2KingScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("king");
			}
		} else {
			if (p2KingScale > 1.5f) {
				p2KingScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1man) {
			if (p1ManScale < 1.65f)
				p1ManScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("man");
			}
		} else {
			if (p1ManScale > 1.5f) {
				p1ManScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2man) {
			if (p2ManScale < 1.65f)
				p2ManScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("man");
			}
		} else {
			if (p2ManScale > 1.5f) {
				p2ManScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1manTwo) {
			if (p1ManTwoScale < 1.65f)
				p1ManTwoScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("manTwo");
			}
		} else {
			if (p1ManTwoScale > 1.5f) {
				p1ManTwoScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2manTwo) {
			if (p2ManTwoScale < 1.65f)
				p2ManTwoScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("manTwo");
			}
		} else {
			if (p2ManTwoScale > 1.5f) {
				p2ManTwoScale -= thumbsScaleStep * delta;
			}
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
