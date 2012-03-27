package se.chalmers.group11.BombSquad;

public class EmptyTile implements GameTile{
	@Override
	public boolean recievesPlayer() {
		return true;
	}

	@Override
	public void receivesFire() {

	}

	@Override
	public void performOnPlayer() {
		
		
	}
	
	public String toString(){
		return "EmptyTile";
	}

}
