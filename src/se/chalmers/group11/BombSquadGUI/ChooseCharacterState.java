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
	private int stateID; // Interface requires a gettable stateID, see getID()
	private int nextButtonX = 500;
	private int nextButtonY = 500;
	private int thumbsY = 120;
	private int thumbsY2 = 200;
	private int thumbsY3 = 280;
	private int thumbsY4 = 400;
	private int p1DevilX = 50;
	private int p2DevilX = 360;
	private int p1WizardX = 120;
	private int p2WizardX = 430;
	private int p1GingerX = 190;
	private int p2GingerX = 500;
	private int p1KingX = 50;
	private int p2KingX = 360;
	private int p1BluehoodX = 120;
	private int p2BluehoodX = 430;
	private int p1DogX = 190;
	private int p2DogX = 500;
	private int p1MackanX = 50;
	private int p2MackanX = 360;
	private int p1AntonX = 120;
	private int p2AntonX = 430;
	private int p1TomasX = 50;
	private int p2TomasX = 360;
	private int p1HenrikX = 120;
	private int p2HenrikX = 430;

	private float nextButtonScale = 0.5f;
	private float nextButtonScaleStep = 0.0001f;
	private float p1DevilScale = 1.5f;
	private float p2DevilScale = 1.5f;
	private float p1WizardScale = 1.5f;
	private float p2WizardScale = 1.5f;
	private float p1GingerScale = 1.5f;
	private float p2GingerScale = 1.5f;
	private float p1KingScale = 1.5f;
	private float p2KingScale = 1.5f;
	private float p1BluehoodScale = 1.5f;
	private float p2BluehoodScale = 1.5f;
	private float p1DogScale = 1.5f;
	private float p2DogScale = 1.5f;
	private float thumbsScaleStep = 0.0005f;
	private float p1MackanScale = 1.5f;
	private float p2MackanScale = 1.5f;
	private float p1AntonScale = 1.5f;
	private float p2AntonScale = 1.5f;
	private float p1TomasScale = 1.5f;
	private float p2TomasScale = 1.5f;
	private float p1HenrikScale = 1.5f;
	private float p2HenrikScale = 1.5f;

	private Image nextButton;
	private Image playerOneText;
	private Image playerTwoText;
	private Image devil;
	private Image wizard;
	private Image ginger;
	private Image king;
	private Image bluehood;
	private Image dog;
	private Image mackan;
	private Image anton;
	private Image tomas;
	private Image henrik;

	public ChooseCharacterState(int stateID) {
		this.stateID = stateID;

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		nextButton = new Image("Images/PlayerIcon.png");
		playerOneText = new Image("Images/playerOneText.png");
		playerTwoText = new Image("Images/playerTwoText.png");
		devil = new Image("Images/devilDOWN.gif");
		wizard = new Image("Images/bombManDOWN.gif");
		ginger = new Image("Images/gingerDOWN.gif");
		king = new Image("Images/kingDOWN.gif");
		bluehood = new Image("Images/manDOWN.gif");
		dog = new Image("Images/mantwoDOWN.gif");
		mackan = new Image("Images/mackanDOWN.png");
		anton = new Image("Images/antonDOWN.png");
		tomas = new Image("Images/tomasDOWN.png");
		henrik = new Image("Images/henkeDOWN.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		nextButton.draw(nextButtonX, nextButtonY, nextButtonScale);
		playerOneText.draw(50, 40);
		playerTwoText.draw(360, 40);
		devil.draw(p1DevilX, thumbsY, p1DevilScale);
		wizard.draw(p1WizardX, thumbsY, p1WizardScale);
		ginger.draw(p1GingerX, thumbsY, p1GingerScale);
		devil.draw(p2DevilX, thumbsY, p2DevilScale);
		wizard.draw(p2WizardX, thumbsY, p2WizardScale);
		ginger.draw(p2GingerX, thumbsY, p2GingerScale);
		king.draw(p2KingX, thumbsY2, p2KingScale);
		king.draw(p1KingX, thumbsY2, p1KingScale);
		bluehood.draw(p1BluehoodX, thumbsY2, p1BluehoodScale);
		bluehood.draw(p2BluehoodX, thumbsY2, p2BluehoodScale);
		dog.draw(p1DogX, thumbsY2, p1DogScale);
		dog.draw(p2DogX, thumbsY2, p2DogScale);
		mackan.draw(p1MackanX, thumbsY3, p1MackanScale);
		mackan.draw(p2MackanX, thumbsY3, p2MackanScale);
		anton.draw(p1AntonX, thumbsY3, p1AntonScale);
		anton.draw(p2AntonX, thumbsY3, p2AntonScale);
		tomas.draw(p1TomasX, thumbsY4, p1TomasScale);
		tomas.draw(p2TomasX, thumbsY4, p2TomasScale);
		henrik.draw(p1HenrikX, thumbsY4, p1HenrikScale);
		henrik.draw(p2HenrikX, thumbsY4, p2HenrikScale);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideNextButton = false;
		boolean insideP1Devil = false;
		boolean insideP2Devil = false;
		boolean insideP1Wizard = false;
		boolean insideP2Wizard = false;
		boolean insideP1Ginger = false;
		boolean insideP2Ginger = false;
		boolean insideP1King = false;
		boolean insideP2King = false;
		boolean insideP1Bluehood = false;
		boolean insideP2Bluehood = false;
		boolean insideP1Dog = false;
		boolean insideP2Dog = false;
		boolean insideP1Mackan = false;
		boolean insideP2Mackan = false;
		boolean insideP1Anton = false;
		boolean insideP2Anton = false;
		boolean insideP1Tomas = false;
		boolean insideP2Tomas = false;
		boolean insideP1Henrik = false;
		boolean insideP2Henrik = false;

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
		if (mouseX >= p1WizardX
				&& mouseX <= p1WizardX + wizard.getWidth() * p1WizardScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + wizard.getHeight() * p1WizardScale) {
			insideP1Wizard = true;
		}
		if (mouseX >= p2WizardX
				&& mouseX <= p2WizardX + wizard.getWidth() * p2WizardScale
				&& mouseY >= thumbsY
				&& mouseY <= thumbsY + wizard.getHeight() * p2WizardScale) {
			insideP2Wizard = true;
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
			insideP1King = true;
		}
		if (mouseX >= p2KingX
				&& mouseX <= p2KingX + king.getWidth() * p2KingScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + king.getHeight() * p2KingScale) {
			insideP2King = true;
		}
		if (mouseX >= p1BluehoodX && mouseX <= p1BluehoodX + bluehood.getWidth() * p1BluehoodScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + bluehood.getHeight() * p1BluehoodScale) {
			insideP1Bluehood = true;
		}
		if (mouseX >= p2BluehoodX && mouseX <= p2BluehoodX + bluehood.getWidth() * p2BluehoodScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + bluehood.getHeight() * p2BluehoodScale) {
			insideP2Bluehood = true;
		}
		if (mouseX >= p1DogX
				&& mouseX <= p1DogX + dog.getWidth() * p1BluehoodScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + dog.getHeight() * p1BluehoodScale) {
			insideP1Dog = true;
		}
		if (mouseX >= p2DogX
				&& mouseX <= p2DogX + dog.getWidth() * p2BluehoodScale
				&& mouseY >= thumbsY2
				&& mouseY <= thumbsY2 + dog.getHeight() * p2BluehoodScale) {
			insideP2Dog = true;
		}
		if (mouseX >= p1MackanX
				&& mouseX <= p1MackanX + mackan.getWidth() * p1MackanScale
				&& mouseY >= thumbsY3
				&& mouseY <= thumbsY3 + mackan.getHeight() * p1MackanScale) {
			insideP1Mackan = true;
		}
		if (mouseX >= p2MackanX
				&& mouseX <= p2MackanX + mackan.getWidth() * p2MackanScale
				&& mouseY >= thumbsY3
				&& mouseY <= thumbsY3 + mackan.getHeight() * p2MackanScale) {
			insideP2Mackan = true;
		}
		if (mouseX >= p1AntonX
				&& mouseX <= p1AntonX + anton.getWidth() * p1AntonScale
				&& mouseY >= thumbsY3
				&& mouseY <= thumbsY3 + anton.getHeight() * p1AntonScale) {
			insideP1Anton = true;
		}
		if (mouseX >= p2AntonX
				&& mouseX <= p2AntonX + anton.getWidth() * p2AntonScale
				&& mouseY >= thumbsY3
				&& mouseY <= thumbsY3 + anton.getHeight() * p2AntonScale) {
			insideP2Anton = true;
		}
		if (mouseX >= p1TomasX
				&& mouseX <= p1TomasX + tomas.getWidth() * p1TomasScale
				&& mouseY >= thumbsY4
				&& mouseY <= thumbsY4 + tomas.getHeight() * p1TomasScale) {
			insideP1Tomas = true;
		}
		if (mouseX >= p2TomasX
				&& mouseX <= p2TomasX + tomas.getWidth() * p2TomasScale
				&& mouseY >= thumbsY4
				&& mouseY <= thumbsY4 + tomas.getHeight() * p2TomasScale) {
			insideP2Tomas = true;
		}
		if (mouseX >= p1HenrikX
				&& mouseX <= p1HenrikX + henrik.getWidth() * p1HenrikScale
				&& mouseY >= thumbsY4
				&& mouseY <= thumbsY4 + henrik.getHeight() * p1HenrikScale) {
			insideP1Henrik = true;
		}
		if (mouseX >= p2HenrikX
				&& mouseX <= p2HenrikX + henrik.getWidth() * p2HenrikScale
				&& mouseY >= thumbsY4
				&& mouseY <= thumbsY4 + henrik.getHeight() * p2HenrikScale) {
			insideP2Henrik = true;
		}
		if (insideNextButton) {
			if (nextButtonScale < 0.55f)
				nextButtonScale += nextButtonScaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sbg.enterState(Main.CHOOSEBOARDSTATE);
			}
		} else {

			if (nextButtonScale > 0.5f) {
				nextButtonScale -= nextButtonScaleStep * delta;

			}
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(Main.SPLASHSCREENSTATE);
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
		if (insideP1Wizard) {
			if (p1WizardScale < 1.65f)
				p1WizardScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("Wizard");

			}
		} else {

			if (p1WizardScale > 1.5f) {
				p1WizardScale -= thumbsScaleStep * delta;
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
		if (insideP2Wizard) {
			if (p2WizardScale < 1.65f)
				p2WizardScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("Wizard");
			}
		} else {

			if (p2WizardScale > 1.5f) {
				p2WizardScale -= thumbsScaleStep * delta;
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
		if (insideP1King) {
			if (p1KingScale < 1.65f)
				p1KingScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("King");
			}
		} else {
			if (p1KingScale > 1.5f) {
				p1KingScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2King) {
			if (p2KingScale < 1.65f)
				p2KingScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("King");
			}
		} else {
			if (p2KingScale > 1.5f) {
				p2KingScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1Bluehood) {
			if (p1BluehoodScale < 1.65f)
				p1BluehoodScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("Bluehood");
			}
		} else {
			if (p1BluehoodScale > 1.5f) {
				p1BluehoodScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Bluehood) {
			if (p2BluehoodScale < 1.65f)
				p2BluehoodScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("Bluehood");
			}
		} else {
			if (p2BluehoodScale > 1.5f) {
				p2BluehoodScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1Dog) {
			if (p1DogScale < 1.65f)
				p1DogScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("Dog");
			}
		} else {
			if (p1DogScale > 1.5f) {
				p1DogScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Dog) {
			if (p2DogScale < 1.65f)
				p2DogScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("Dog");
			}
		} else {
			if (p2DogScale > 1.5f) {
				p2DogScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1Mackan) {
			if (p1MackanScale < 1.65f)
				p1MackanScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("mackan");
			}
		} else {
			if (p1MackanScale > 1.5f) {
				p1MackanScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Mackan) {
			if (p2MackanScale < 1.65f)
				p2MackanScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("mackan");
			}
		} else {
			if (p2MackanScale > 1.5f) {
				p2MackanScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1Anton) {
			if (p1AntonScale < 1.65f)
				p1AntonScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("anton");
			}
		} else {
			if (p1AntonScale > 1.5f) {
				p1AntonScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Anton) {
			if (p2AntonScale < 1.65f)
				p2AntonScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("anton");
			}
		} else {
			if (p2AntonScale > 1.5f) {
				p2AntonScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1Tomas) {
			if (p1TomasScale < 1.65f)
				p1TomasScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("tomas");
			}
		} else {
			if (p1TomasScale > 1.5f) {
				p1TomasScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Tomas) {
			if (p2TomasScale < 1.65f)
				p2TomasScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("tomas");
			}
		} else {
			if (p2TomasScale > 1.5f) {
				p2TomasScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP1Henrik) {
			if (p1HenrikScale < 1.65f)
				p1HenrikScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerOneSkin("henrik");
			}
		} else {
			if (p1HenrikScale > 1.5f) {
				p1HenrikScale -= thumbsScaleStep * delta;
			}
		}
		if (insideP2Henrik) {
			if (p2HenrikScale < 1.65f)
				p2HenrikScale += thumbsScaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setPlayerTwoSkin("henrik");
			}
		} else {
			if (p2HenrikScale > 1.5f) {
				p2HenrikScale -= thumbsScaleStep * delta;
			}
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
