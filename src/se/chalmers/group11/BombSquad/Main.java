package se.chalmers.group11.BombSquad;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

	public static final int MAINMENUSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;
	public static final int GAMEOVERSTATE = 2;

	public Main() {
		super("BombSquad");
		this.addState(new MainMenuState(MAINMENUSTATE));
		this.addState(new GamePlayState(GAMEPLAYSTATE));
<<<<<<< HEAD
		this.addState(new GameOverState(GAMEOVERSTATE));
=======

>>>>>>> origin/master
		this.enterState(MAINMENUSTATE);
		//this.enterState(GAMEOVERSTATE);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(GAMEPLAYSTATE).init(container, this);
		this.getState(MAINMENUSTATE).init(container, this);
		this.getState(GAMEOVERSTATE).init(container, this);

	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main());
		app.setTitle("BombSquad");
		app.setDisplayMode(660, 660, false);
		app.start();
	}

}
