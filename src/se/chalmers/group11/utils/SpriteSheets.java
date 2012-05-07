package se.chalmers.group11.utils;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSheets {


	private Animation sprite, up, down, left, right;

	public SpriteSheets(String s) throws SlickException {
		Image[] movementUp = new Image[2];
		Image[] movementDown = new Image[2];
		Image[] movementLeft = new Image[2];
		Image[] movementRight = new Image[2];

		if(s=="BombMan"){
			movementUp[0] =  new Image("Images/bombManUP.gif");
			movementUp[1] = new Image("Images/bombManUP2.gif");
			movementDown[0] =  new Image("Images/bombManDOWN.gif");
			movementDown[1] = new Image("Images/bombManDOWN2.gif");
			movementLeft[0] =  new Image("Images/bombManLEFT.gif");
			movementLeft[1] = new Image("Images/bombManLEFT2.gif");
			movementRight[0] =  new Image("Images/bombManRIGHT.gif");
			movementRight[1] = new Image("Images/bombManRIGHT2.gif");
		}
		if(s=="Devil"){
			movementUp[0] =  new Image("Images/devilUP.gif");
			movementUp[1] = new Image("Images/devilUP2.gif");
			movementDown[0] =  new Image("Images/devilDOWN.gif");
			movementDown[1] = new Image("Images/devilDOWN2.gif");
			movementLeft[0] =  new Image("Images/devilLEFT.gif");
			movementLeft[1] = new Image("Images/devilLEFT2.gif");
			movementRight[0] =  new Image("Images/devilRIGHT.gif");
			movementRight[1] = new Image("Images/devilRIGHT2.gif");
		}
		if(s=="Ginger"){
			movementUp[0] =  new Image("Images/gingerUP.gif");
			movementUp[1] = new Image("Images/gingerUP2.gif");
			movementDown[0] =  new Image("Images/gingerDOWN.gif");
			movementDown[1] = new Image("Images/gingerDOWN2.gif");
			movementLeft[0] =  new Image("Images/gingerLEFT.gif");
			movementLeft[1] = new Image("Images/gingerLEFT2.gif");
			movementRight[0] =  new Image("Images/gingerRIGHT.gif");
			movementRight[1] = new Image("Images/gingerRIGHT2.gif");
		}

		int[] duration = { 150, 150 };
		up = new Animation(movementUp, duration, true);
		down = new Animation(movementDown, duration, false);
		left = new Animation(movementLeft, duration, false);
		right = new Animation(movementRight, duration, false);
		sprite = right;
	}


	public void AnimationUp() {
		sprite = up;
	}

	public void AnimationDown() {
		sprite = down;
	}

	public void AnimationLeft() {
		sprite = left;
	}

	public void AnimationRight() {
		sprite = right;
	}

	public void drawAnimation(int x, int y, int sizeX, int sizeY) {
		sprite.draw(x, y, sizeX, sizeY);
	}
}
