package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BombTile implements GameTile{
	public BombTile(int x, int y){
		System.out.println("Bomb läggs ut" + x + " " + y);
		
		int delay = 3000; //milliseconds
		  ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Eld ritas ut");
				//fire
			}
		  };
		  Timer t = new Timer(delay, taskPerformer);		  
		  t.setRepeats(false);
		  t.start();
	}
	@Override
	public boolean recievesPlayer() {
		return false;
	}

	@Override
	public void receivesFire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performOnPlayer() {
		// TODO Auto-generated method stub
		
	}
	

}
