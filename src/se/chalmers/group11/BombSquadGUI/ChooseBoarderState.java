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

public class ChooseBoarderState extends BasicGameState {

	private int startX = 50;
	private int startY = 10;
	private int exitX = 50;
	private int exitY = 400;
	private static int boardChooser = 1;

	private float boardOneImageScale = 0.2f;
	private float boardTwoImageScale = 0.2f;
	private float scaleStep = 0.0001f;

	int stateID = 0;
	private Image randomBoard = null;
	private Image boardWithoutBlocks = null;

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
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		randomBoard.draw(startX, startY, boardTwoImageScale);
		boardWithoutBlocks.draw(exitX, exitY, boardOneImageScale);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideStartGame = false;
		boolean insideExitGame = false;

		if (mouseX >= startX && mouseX <= startX + 100 && mouseY >= startY
				&& mouseY <= startY + 100) {
			insideStartGame = true;

		} else if (mouseX >= exitX && mouseX <= exitX + 100 && mouseY >= exitY
				&& mouseY <= exitY + 100) {
			insideExitGame = true;
		}
		if (insideStartGame) {
			if (boardTwoImageScale < 0.25f)
				boardTwoImageScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sb.enterState(Main.GAMEPLAYSTATE);
			}
		} else {

			if (boardTwoImageScale > 0.2f) {
				boardTwoImageScale -= scaleStep * delta;

			}
			if (insideExitGame) {
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					boardChooser = 0;
					sb.enterState(Main.GAMEPLAYSTATE);
				}

				if (boardOneImageScale < 0.25f)
					boardOneImageScale += scaleStep * delta;
			} else {
				if (boardOneImageScale > 0.2f)
					boardOneImageScale -= scaleStep * delta;
			}
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

	public void setBoard(int boardChooser) {
		if (boardChooser == 2) {
			iB = new Board();
		} else {
			iB = new BoardEmpty();
		}
	}

	// public void setBoardEmpty(){
	// iB = new BoardEmpty();
	// }
	public static IBoard getBoard() {
		if (boardChooser == 1) {
			return new Board();
		} else
			return new BoardEmpty();
	}

	public void enter(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		super.enter(gc, sb);
		iB = new Board();
	}
}