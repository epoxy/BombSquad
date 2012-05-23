package se.chalmers.group11.bombsquadgui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.core.BoardClassic;
import se.chalmers.group11.core.BoardEmpty;
import se.chalmers.group11.core.BoardPower;
import se.chalmers.group11.core.BoardRandom;
import se.chalmers.group11.core.BoardWater;
import se.chalmers.group11.core.BoardWithoutBlocks;
import se.chalmers.group11.core.Game;
import se.chalmers.group11.core.GameOptions;
import se.chalmers.group11.core.Board;
import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.main.Main;

public class ChooseBoardState extends BasicGameState {

	private int stateID; //Interface requires a gettable stateID, see getID()
	private int classicBoardX = 50;
	private int classicBoardY = 130;
	private int emptyBoardX = 50;
	private int emptyBoardY = 400;
	private int boxBoardStartX = 250;
	private int boxBoardStartY = 130;
	private int randomBoardX = 250;
	private int randomBoardY = 400;
	private int powerBoardX = 450;
	private int powerBoardY = 130;
	private int waterBoardX = 450;
	private int waterBoardY = 400;

	private float emptyBoardImageScale = 0.2f;
	private float classicBoardImageScale = 0.2f;
	private float boxBoardImageScale = 0.2f;
	private float randomBoardImageScale = 0.2f;
	private float powerBoardImageScale = 0.2f;
	private float waterBoardImageScale = 0.2f;
	private float scaleStep = 0.0001f;

	private Image classicBoard = null;
	private Image emptyBoard = null;
	private Image boxBoard = null;
	private Image randomBoard = null;
	private Image powerBoard = null;
	private Image waterBoard = null;
	private Image chooseBoard = null;

	public ChooseBoardState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		classicBoard = new Image("Images/randomBoard.png");
		emptyBoard = new Image("Images/boardWithoutBlocks.png");
		boxBoard = new Image("Images/boxBoard.png");
		randomBoard = new Image("Images/randomBoard2.png");
		powerBoard = new Image("Images/powboard.png");
		waterBoard = new Image("Images/waterboard.png");
		chooseBoard = new Image("Images/chooseBoard.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		chooseBoard.draw(0, 0, 1);
		classicBoard.draw(classicBoardX, classicBoardY, classicBoardImageScale);
		emptyBoard.draw(emptyBoardX, emptyBoardY, emptyBoardImageScale);
		boxBoard.draw(boxBoardStartX, boxBoardStartY, boxBoardImageScale);
		randomBoard.draw(randomBoardX, randomBoardY, randomBoardImageScale);
		powerBoard.draw(powerBoardX, powerBoardY, powerBoardImageScale);
		waterBoard.draw(waterBoardX, waterBoardY, waterBoardImageScale);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideClassicBoard = false;
		boolean insideEmptyBoard = false;
		boolean insideBoxBoard = false;
		boolean insideRandomBoard = false;
		boolean insidePowerBoard = false;
		boolean insideWaterBoard = false;

		if (mouseX >= classicBoardX && mouseX <= classicBoardX + 150
				&& mouseY >= classicBoardY && mouseY <= classicBoardY + 150) {
			insideClassicBoard = true;

		} else if (mouseX >= emptyBoardX && mouseX <= emptyBoardX + 150 && mouseY >= emptyBoardY
				&& mouseY <= emptyBoardY + 150) {
			insideEmptyBoard = true;

		} else if (mouseX >= boxBoardStartX && mouseX <= boxBoardStartX + 150
				&& mouseY >= boxBoardStartY && mouseY <= boxBoardStartY + 150) {
			insideBoxBoard = true;
		} else if (mouseX >= randomBoardX && mouseX <= randomBoardX + 150
				&& mouseY >= randomBoardY && mouseY <= randomBoardY + 150) {
			insideRandomBoard = true;
		} else if (mouseX >= powerBoardX && mouseX <= powerBoardX + 150
				&& mouseY >= powerBoardY && mouseY <= powerBoardY + 150) {
			insidePowerBoard = true;
		} else if (mouseX >= waterBoardX && mouseX <= waterBoardX + 150
				&& mouseY >= waterBoardY && mouseY <= waterBoardY + 150) {
			insideWaterBoard = true;
		}

		if (insideClassicBoard) {
			if (classicBoardImageScale < 0.25f)
				classicBoardImageScale += scaleStep * delta;

			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(1);
				sbg.enterState(Main.GAMEPLAYSTATE);
			}
		} else {

			if (classicBoardImageScale > 0.2f) {
				classicBoardImageScale -= scaleStep * delta;

			}
			if (insideEmptyBoard) {
				if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					GameOptions.getInstance().setBoard(0);
					sbg.enterState(Main.GAMEPLAYSTATE);
				}

				if (emptyBoardImageScale < 0.25f)
					emptyBoardImageScale += scaleStep * delta;
			} else {
				if (emptyBoardImageScale > 0.2f)
					emptyBoardImageScale -= scaleStep * delta;
			}
		}
		if (insideRandomBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(4);
				sbg.enterState(Main.GAMEPLAYSTATE);
			}
			if (randomBoardImageScale < 0.25f)
				randomBoardImageScale += scaleStep * delta;
		} else {
			if (randomBoardImageScale > 0.2f)
				randomBoardImageScale -= scaleStep * delta;
		}
		if (insideBoxBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(3);
				sbg.enterState(Main.GAMEPLAYSTATE);
			}
			if (boxBoardImageScale < 0.25f)
				boxBoardImageScale += scaleStep * delta;
		} else {
			if (boxBoardImageScale > 0.2f)
				boxBoardImageScale -= scaleStep * delta;
		}
		if (insidePowerBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(5);
				sbg.enterState(Main.GAMEPLAYSTATE);
			}
			if (powerBoardImageScale < 0.25f)
				powerBoardImageScale += scaleStep * delta;
		} else {
			if (powerBoardImageScale > 0.2f)
				powerBoardImageScale -= scaleStep * delta;
		}
		if (insideWaterBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(6);
				sbg.enterState(Main.GAMEPLAYSTATE);
			}
			if (waterBoardImageScale < 0.25f)
				waterBoardImageScale += scaleStep * delta;
		} else {
			if (waterBoardImageScale > 0.2f)
				waterBoardImageScale -= scaleStep * delta;
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(Main.CHOOSECHARACTERSTATE);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}
}