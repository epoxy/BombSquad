package se.chalmers.group11.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.newdawn.slick.state.StateBasedGame;
import se.chalmers.group11.eventbus.Event;
import se.chalmers.group11.eventbus.EventBus;

/**
 * A class representing a FireTile
 */
public class FireTile implements GameTile {// observable

	public FireTile() {
	}

	@Override
	public boolean canReceivePlayer() {
		return true;
	}

	@Override
	public boolean canReceiveFire() {
		return true;
	
	}
	boolean done = false;
	@Override
	public void performOnPlayer(final Player p) {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventBus.INSTANCE.publish(new Event(Event.Tag.PLAYER_KILLED, p
				.getPlayerNumber()));
			}
		};
		if(!done){
			Timer t = new Timer(300, taskPerformer);
			t.setRepeats(false);
			t.start();
		}
		done=true;
	}
	public void performOnEnemy(){
		EventBus.INSTANCE.publish(new Event(Event.Tag.ENEMY_KILLED));
	}

}
