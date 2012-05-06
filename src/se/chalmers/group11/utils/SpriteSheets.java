package se.chalmers.group11.utils;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSheets {
	
	
	private Animation sprite, up, down, left, right;

	public SpriteSheets() throws SlickException {
		
		Image[] movementUp = { new Image("Images/bombManUP.gif"),
				new Image("Images/bombManUP2.gif") };
		Image[] movementDown = { new Image("Images/bombManDOWN.gif"),
				new Image("Images/bombManDOWN2.gif") };
		Image[] movementLeft = { new Image("Images/bombManLEFT.gif"),
				new Image("Images/bombManLEFT2.gif") };
		Image[] movementRight = { new Image("Images/bombManRIGHT.gif"),
				new Image("Images/bombManRIGHT2.gif") };
		

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
