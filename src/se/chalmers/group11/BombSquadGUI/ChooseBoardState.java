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
import se.chalmers.group11.core.IBoard;
import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.main.Main;

public class ChooseBoardState extends BasicGameState {

	private int classicBoardX = 50;
	private int classicBoardY = 100;
	private int exitX = 50;
	private int exitY = 400;
	private int boxBoardStartX = 250;
	private int boxBoardStartY = 100;
	private int board2X = 250;
	private int board2Y = 400;
	private int powboardX = 450;
	private int powboardY = 100;
	private int waterboardX = 450;
	private int waterboardY = 400;

	private float boardWithoutBlocksImageScale = 0.2f;
	private float classicBoardImageScale = 0.2f;
	private float boardWithBoxes = 0.2f;
	private float randomboard2ImageScale = 0.2f;
	private float powboardImageScale = 0.2f;
	private float waterboardImageScale = 0.2f;
	private float scaleStep = 0.0001f;

	int stateID;
	private Image classicBoard = null;
	private Image boardWithoutBlocks = null;
	private Image boxBoard = null;
	private Image randomboard2 = null;
	private Image powboard = null;
	private Image waterboard = null;

	public ChooseBoardState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		classicBoard = new Image("Images/randomBoard.png");
		boardWithoutBlocks = new Image("Images/boardWithoutBlocks.png");
		boxBoard = new Image("Images/boxBoard.png");
		randomboard2 = new Image("Images/randomBoard2.png");
		powboard = new Image("Images/powboard.png");
		waterboard = new Image("Images/waterboard.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		classicBoard.draw(classicBoardX, classicBoardY, classicBoardImageScale);
		boardWithoutBlocks.draw(exitX, exitY, boardWithoutBlocksImageScale);
		boxBoard.draw(boxBoardStartX, boxBoardStartY, boardWithBoxes);
		randomboard2.draw(board2X, board2Y, randomboard2ImageScale);
		powboard.draw(powboardX, powboardY, powboardImageScale);
		waterboard.draw(waterboardX, waterboardY, waterboardImageScale);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideClassicBoard = false;
		boolean insideExitGame = false;
		boolean insideBoxBoard = false;
		boolean insideRandomBoard = false;
		boolean insidePowBoard = false;
		boolean insideWaterBoard = false;

		if (mouseX >= classicBoardX && mouseX <= classicBoardX + 150
				&& mouseY >= classicBoardY && mouseY <= classicBoardY + 150) {
			insideClassicBoard = true;

		} else if (mouseX >= exitX && mouseX <= exitX + 150 && mouseY >= exitY
				&& mouseY <= exitY + 150) {
			insideExitGame = true;

		} else if (mouseX >= boxBoardStartX && mouseX <= boxBoardStartX + 150
				&& mouseY >= boxBoardStartY && mouseY <= boxBoardStartY + 150) {
			insideBoxBoard = true;
		} else if (mouseX >= board2X && mouseX <= board2X + 150
				&& mouseY >= board2Y && mouseY <= board2Y + 150) {
			insideRandomBoard = true;
		} else if (mouseX >= powboardX && mouseX <= powboardX + 150
				&& mouseY >= powboardY && mouseY <= powboardY + 150) {
			insidePowBoard = true;
		} else if (mouseX >= waterboardX && mouseX <= waterboardX + 150
				&& mouseY >= waterboardY && mouseY <= waterboardY + 150) {
			insideWaterBoard = true;
		}

		if (insideClassicBoard) {
			if (classicBoardImageScale < 0.25f)
				classicBoardImageScale += scaleStep * delta;

			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(1);
				sb.enterState(Main.GAMEPLAYSTATE);
			}
		} else {

			if (classicBoardImageScale > 0.2f) {
				classicBoardImageScale -= scaleStep * delta;

			}
			if (insideExitGame) {
				if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					GameOptions.getInstance().setBoard(0);
					sb.enterState(Main.GAMEPLAYSTATE);
				}

				if (boardWithoutBlocksImageScale < 0.25f)
					boardWithoutBlocksImageScale += scaleStep * delta;
			} else {
				if (boardWithoutBlocksImageScale > 0.2f)
					boardWithoutBlocksImageScale -= scaleStep * delta;
			}
		}
		if (insideRandomBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(4);
				sb.enterState(Main.GAMEPLAYSTATE);
			}
			if (randomboard2ImageScale < 0.25f)
				randomboard2ImageScale += scaleStep * delta;
		} else {
			if (randomboard2ImageScale > 0.2f)
				randomboard2ImageScale -= scaleStep * delta;
		}
		if (insideBoxBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(3);
				sb.enterState(Main.GAMEPLAYSTATE);
			}
			if (boardWithBoxes < 0.25f)
				boardWithBoxes += scaleStep * delta;
		} else {
			if (boardWithBoxes > 0.2f)
				boardWithBoxes -= scaleStep * delta;
		}
		if (insidePowBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(5);
				sb.enterState(Main.GAMEPLAYSTATE);
			}
			if (powboardImageScale < 0.25f)
				powboardImageScale += scaleStep * delta;
		} else {
			if (powboardImageScale > 0.2f)
				powboardImageScale -= scaleStep * delta;
		}
		if (insideWaterBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				GameOptions.getInstance().setBoard(6);
				sb.enterState(Main.GAMEPLAYSTATE);
			}
			if (waterboardImageScale < 0.25f)
				waterboardImageScale += scaleStep * delta;
		} else {
			if (waterboardImageScale > 0.2f)
				waterboardImageScale -= scaleStep * delta;
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sb.enterState(Main.CHOOSECHARACTERSTATE);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}
}