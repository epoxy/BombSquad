package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BombTile implements GameTile{
	public BombTile(){
		System.out.println("Bomb l�ggs ut");
		int delay = 3000; //milliseconds
		  ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Eld ritas ut");
				//fire
			}
		  };
		  new Timer(delay, taskPerformer).start();
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