package se.chalmers.group11.utils;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
/**A class to handle all the sprites
 * 
 * @author BombSquad
 *
 */
public class SpriteSheets {

	private Animation sprite, up, down, left, right;
/**
 * 
 * @param s holds the name of the sprite
 * @throws SlickException
 */
	public SpriteSheets(String s) throws SlickException {
		Image[] movementUp = new Image[2];
		Image[] movementDown = new Image[2];
		Image[] movementLeft = new Image[2];
		Image[] movementRight = new Image[2];
		
		if (s == "BombMan") {
			movementUp[0] = new Image("Images/bombManUP.gif");
			movementUp[1] = new Image("Images/bombManUP2.gif");
			movementDown[0] = new Image("Images/bombManDOWN.gif");
			movementDown[1] = new Image("Images/bombManDOWN2.gif");
			movementLeft[0] = new Image("Images/bombManLEFT.gif");
			movementLeft[1] = new Image("Images/bombManLEFT2.gif");
			movementRight[0] = new Image("Images/bombManRIGHT.gif");
			movementRight[1] = new Image("Images/bombManRIGHT2.gif");
		}
		if (s == "Devil") {
			movementUp[0] = new Image("Images/devilUP.gif");
			movementUp[1] = new Image("Images/devilUP2.gif");
			movementDown[0] = new Image("Images/devilDOWN.gif");
			movementDown[1] = new Image("Images/devilDOWN2.gif");
			movementLeft[0] = new Image("Images/devilLEFT.gif");
			movementLeft[1] = new Image("Images/devilLEFT2.gif");
			movementRight[0] = new Image("Images/devilRIGHT.gif");
			movementRight[1] = new Image("Images/devilRIGHT2.gif");
		}
		if (s == "Ginger") {
			movementUp[0] = new Image("Images/gingerUP.gif");
			movementUp[1] = new Image("Images/gingerUP2.gif");
			movementDown[0] = new Image("Images/gingerDOWN.gif");
			movementDown[1] = new Image("Images/gingerDOWN2.gif");
			movementLeft[0] = new Image("Images/gingerLEFT.gif");
			movementLeft[1] = new Image("Images/gingerLEFT2.gif");
			movementRight[0] = new Image("Images/gingerRIGHT.gif");
			movementRight[1] = new Image("Images/gingerRIGHT2.gif");
		}
		if (s == "king") {
			movementUp[0] = new Image("Images/kingUP.gif");
			movementUp[1] = new Image("Images/kingUP2.gif");
			movementDown[0] = new Image("Images/kingDOWN.gif");
			movementDown[1] = new Image("Images/kingDOWN2.gif");
			movementLeft[0] = new Image("Images/kingLEFT.gif");
			movementLeft[1] = new Image("Images/kingLEFT2.gif");
			movementRight[0] = new Image("Images/kingRIGHT.gif");
			movementRight[1] = new Image("Images/kingRIGHT2.gif");
		}
		if (s == "man") {
			movementUp[0] = new Image("Images/manUP.gif");
			movementUp[1] = new Image("Images/manUP2.gif");
			movementDown[0] = new Image("Images/manDOWN.gif");
			movementDown[1] = new Image("Images/manDOWN2.gif");
			movementLeft[0] = new Image("Images/manLEFT.gif");
			movementLeft[1] = new Image("Images/manLEFT2.gif");
			movementRight[0] = new Image("Images/manRIGHT.gif");
			movementRight[1] = new Image("Images/manRIGHT2.gif");
		}
		if (s == "manTwo") {
			movementUp[0] = new Image("Images/mantwoUP.gif");
			movementUp[1] = new Image("Images/mantwoUP2.gif");
			movementDown[0] = new Image("Images/mantwoDOWN.gif");
			movementDown[1] = new Image("Images/mantwoDOWN2.gif");
			movementLeft[0] = new Image("Images/mantwoLEFT.gif");
			movementLeft[1] = new Image("Images/mantwoLEFT2.gif");
			movementRight[0] = new Image("Images/mantwoRIGHT.gif");
			movementRight[1] = new Image("Images/mantwoRIGHT2.gif");
		}

		int[] duration = { 150, 150 };
		up = new Animation(movementUp, duration, true);
		down = new Animation(movementDown, duration, true);
		left = new Animation(movementLeft, duration, true);
		right = new Animation(movementRight, duration, true);
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
