package se.chalmers.group11.BombSquad;

import org.newdawn.slick.state.StateBasedGame;

import com.sun.org.apache.xml.internal.security.Init;


public class FireTile implements GameTile {
<<<<<<< HEAD
	

=======
	MainMenuState main = new MainMenuState(0);
>>>>>>> origin/master
	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer(int playerIndex) {
		game.enterState(2);
		System.out.println("Player" + (playerIndex+1) + " sucks");

	}

}
