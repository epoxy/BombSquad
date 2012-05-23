package se.chalmers.group11.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import se.chalmers.group11.bombsquadgui.ChooseBoardState;
import se.chalmers.group11.bombsquadgui.ChooseCharacterState;
import se.chalmers.group11.bombsquadgui.GameOverState;
import se.chalmers.group11.bombsquadgui.GamePlayState;
import se.chalmers.group11.bombsquadgui.SplashScreenState;

/**
 * A class that handles all the states, It adds all the states when the
 * applications starts so it makes it possible to change states while the
 * application is running. Also it«s our Main class, so the application starts
 * from here.
 * 
 * @version 1.0 23 may 2012
 * 
 * @author ProjectEleven
 * 
 */
public class Main extends StateBasedGame {

	public static final int CHOOSEBOARDSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;
	public static final int GAMEOVERSTATE = 2;
	public static final int SPLASHSCREENSTATE = 3;
	public static final int CHOOSECHARACTERSTATE = 4;

	public Main() {
		super("BombSquad");
		this.addState(new ChooseBoardState(CHOOSEBOARDSTATE));
		this.addState(new GamePlayState(GAMEPLAYSTATE));
		this.addState(new GameOverState(GAMEOVERSTATE/* , null */));
		this.addState(new SplashScreenState(SPLASHSCREENSTATE));
		this.addState(new ChooseCharacterState(CHOOSECHARACTERSTATE));
		this.enterState(SPLASHSCREENSTATE);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(GAMEPLAYSTATE).init(gc, this);
		this.getState(CHOOSEBOARDSTATE).init(gc, this);
		this.getState(GAMEOVERSTATE).init(gc, this);
		this.getState(SPLASHSCREENSTATE).init(gc, this);
		this.getState(CHOOSECHARACTERSTATE).init(gc, this);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main());
		app.setTitle("BombSquad");
		app.setDisplayMode(660, 660, false);
		app.setShowFPS(false);

		app.start();
	}

}
