package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;

import se.chalmers.group11.main.Main;

import com.sun.org.apache.xml.internal.security.Init;


public class FireTile implements GameTile {
	
	private int x;
	private int y;

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
	public void performOnPlayer(Player p, final StateBasedGame sbg) {
		System.out.println("Player: " + (p.getPlayerNumber()) + " sucks");
		
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				sbg.enterState(Main.GAMEOVERSTATE);
			}
		};
		
		Timer t = new Timer(300, taskPerformer);
		t.setRepeats(false);
		t.start();
	}

	@Override
	public int getX() {

		return x;
	}

	@Override
	public int getY() {

		return y;
	}

}
