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
import se.chalmers.group11.core.BoardWithoutBlocks;
import se.chalmers.group11.core.Game;
import se.chalmers.group11.core.IBoard;
import se.chalmers.group11.main.Main;

public class ChooseBoarderState extends BasicGameState {

	private int startX = 50;
	private int startY = 100;
	private int exitX = 50;
	private int exitY = 400;
	private int boxBoardStartX = 250;
	private int boxBoardStartY = 100;
	private static int boardChooser = 1;

	private float boardWithoutBlocksImageScale = 0.2f;
	private float randomBoardImageScale = 0.2f;
	private float boardWithBoxes = 0.2f;
	private float scaleStep = 0.0001f;

	int stateID = 0;
	private Image randomBoard = null;
	private Image boardWithoutBlocks = null;
	private Image boxBoard = null;

	private static IBoard iB;

	public ChooseBoarderState(int stateID) {
		this.stateID = stateID;
		// setBoard(boardChooser);
		// // iB = getBoard();
		// iB = new Board();
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		randomBoard = new Image("Images/randomBoard.png");
		boardWithoutBlocks = new Image("Images/boardWithoutBlocks.png");
		boxBoard = new Image("Images/boxBoard.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		randomBoard.draw(startX, startY, randomBoardImageScale);
		boardWithoutBlocks.draw(exitX, exitY, boardWithoutBlocksImageScale);
		boxBoard.draw(boxBoardStartX, boxBoardStartY, boardWithBoxes);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideStartGame = false;
		boolean insideExitGame = false;
		boolean insideBoxBoard = false;

		if (mouseX >= startX && mouseX <= startX + 150 && mouseY >= startY
				&& mouseY <= startY + 150) {
			insideStartGame = true;

		} else if (mouseX >= exitX && mouseX <= exitX + 150 && mouseY >= exitY
				&& mouseY <= exitY + 150) {
			insideExitGame = true;

		} else if (mouseX >= boxBoardStartX
				&& mouseX <= boxBoardStartX + 150
				&& mouseY >= boxBoardStartY && mouseY <= boxBoardStartY + 150) {
			insideBoxBoard = true;
		}
		if (insideStartGame) {
			if (randomBoardImageScale < 0.25f)
				randomBoardImageScale += scaleStep * delta;

			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				sb.enterState(Main.GAMEPLAYSTATE);
			}
		} else {

			if (randomBoardImageScale > 0.2f) {
				randomBoardImageScale -= scaleStep * delta;

			}
			if (insideExitGame) {
				if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					boardChooser = 0;
					sb.enterState(Main.GAMEPLAYSTATE);
				}

				if (boardWithoutBlocksImageScale < 0.25f)
					boardWithoutBlocksImageScale += scaleStep * delta;
			} else {
				if (boardWithoutBlocksImageScale > 0.2f)
					boardWithoutBlocksImageScale -= scaleStep * delta;
			}
		}
		if (insideBoxBoard) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				boardChooser = 3;
				sb.enterState(Main.GAMEPLAYSTATE);
			}
			if (boardWithBoxes < 0.25f)
				boardWithBoxes += scaleStep * delta;
		} else {
			if (boardWithBoxes > 0.2f)
				boardWithBoxes -= scaleStep * delta;
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

	public static IBoard getBoard() {
		if (boardChooser == 1) {
			return new Board();
		} else if (boardChooser == 0) {
			return new BoardEmpty();
		} else {
			return new BoardWithoutBlocks();
		}
	}

	public void enter(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		super.enter(gc, sb);
		iB = new Board();
	}
}