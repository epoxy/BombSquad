package se.chalmers.group11.BombSquad;

public class Player {
	
	int x;
	int y;
	
	public void movePlayerDir(int direction){
		
		int deltaX;
		int deltaY;
		
		if(direction==1){
			deltaX =1;
			deltaY=0;
		}
		if(direction==2){
			deltaX =-1;
			deltaY=0;
		}
		if(direction==3){
			deltaX =0;
			deltaY=1;
		}
		if(direction==4){
			deltaX =0;
			deltaY=-1;
		}
		
		//GameTile t = GamePlayState.getTile(x+deltaX, y+deltaY);
			//	t.recievesPlayer(this);
	}
	//public void movePlayer(int x, int y){
		//newX=x;
		//newY=y;
		//player.getTile(newX,newY);
	//}
}
