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
		//TODO l�gg till receivesFire()==true s� att eld p� bomb leder till spr�ngningskedjereaktion
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnPlayer() {
		// TODO Auto-generated method stub
	}
}