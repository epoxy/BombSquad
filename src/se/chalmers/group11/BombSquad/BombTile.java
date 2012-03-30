package se.chalmers.group11.BombSquad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BombTile implements GameTile {
	public BombTile() {
	}

	@Override
	public boolean canReceivePlayer() {
		return false;
	}

	@Override
	public boolean canReceiveFire() {
		return false;
		//TODO lägg till receivesFire()==true så att eld på bomb leder till sprängningskedjereaktion
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer() {
		// TODO Auto-generated method stub
	}
}