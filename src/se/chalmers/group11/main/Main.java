package se.chalmers.group11.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.bombsquadgui.ChooseBoarderState;
import se.chalmers.group11.bombsquadgui.ChooseCharacterState;
import se.chalmers.group11.bombsquadgui.GameOverState;
import se.chalmers.group11.bombsquadgui.GamePlayState;
import se.chalmers.group11.bombsquadgui.SplashScreenState;

public class Main extends StateBasedGame {

	public static final int CHOOSEBOARDERSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;
	public static final int GAMEOVERSTATE = 2;
	public static final int SPLASHSCREENSTATE = 3;
	public static final int CHOOSECHARACTERSTATE = 4;

	public Main() {
		super("BombSquad");
		this.addState(new ChooseBoarderState(CHOOSEBOARDERSTATE));
		this.addState(new GamePlayState(GAMEPLAYSTATE));
		this.addState(new GameOverState(GAMEOVERSTATE, null));
		this.addState(new SplashScreenState(SPLASHSCREENSTATE));
		this.addState(new ChooseCharacterState(CHOOSECHARACTERSTATE));
		this.enterState(SPLASHSCREENSTATE);
//		this.enterState(GAMEOVERSTATE);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(GAMEPLAYSTATE).init(container, this);
		this.getState(CHOOSEBOARDERSTATE).init(container, this);
		this.getState(GAMEOVERSTATE).init(container, this);
		this.getState(SPLASHSCREENSTATE).init(container, this);
		this.getState(CHOOSECHARACTERSTATE).init(container, this);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main());
		app.setTitle("BombSquad");
		app.setDisplayMode(660, 660, false);
		app.start();
	}

}
