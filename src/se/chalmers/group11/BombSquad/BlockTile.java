package se.chalmers.group11.BombSquad;

public class BlockTile implements GameTile{
	@Override
	public boolean recievesPlayer(Player p){
		return false;
	}
	@Override
	public void receivesFire(){
		
	}
}
