package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;

import se.chalmers.group11.bombsquadgui.GameOverState;
import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;
import se.chalmers.group11.main.Main;

import com.sun.org.apache.xml.internal.security.Init;


public class FireTile implements GameTile{//observable
	
	private int x;
	private int y;
	
	public FireTile(){
	}
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
	public void performOnPlayer(final Player p, final StateBasedGame sbg) {
		System.out.println("Player: " + (p.getPlayerNumber()) + " sucks");
		
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventBus.INSTANCE.publish(new Event(Event.Tag.FIRE_STARTER, p.getPlayerNumber()));
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
