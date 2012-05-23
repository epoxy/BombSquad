package se.chalmers.group11.utils;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * A class to handle all the sprites
 * 
 * @author Tomas Selldén
 * @author Henrik Andersson refactored the code and added more sprites
 * 
 */
public class SpriteSheets {

	private Animation sprite, up, down, left, right;

	/**
	 * 
	 * @param s
	 *            holds the name of the sprite
	 * @throws SlickException
	 */
	public SpriteSheets(String s) throws SlickException {
		Image[] movementUp = new Image[2];
		Image[] movementDown = new Image[2];
		Image[] movementLeft = new Image[2];
		Image[] movementRight = new Image[2];

		if (s == "Wizard") {
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
		if (s == "King") {
			movementUp[0] = new Image("Images/kingUP.gif");
			movementUp[1] = new Image("Images/kingUP2.gif");
			movementDown[0] = new Image("Images/kingDOWN.gif");
			movementDown[1] = new Image("Images/kingDOWN2.gif");
			movementLeft[0] = new Image("Images/kingLEFT.gif");
			movementLeft[1] = new Image("Images/kingLEFT2.gif");
			movementRight[0] = new Image("Images/kingRIGHT.gif");
			movementRight[1] = new Image("Images/kingRIGHT2.gif");
		}
		if (s == "Bluehood") {
			movementUp[0] = new Image("Images/manUP.gif");
			movementUp[1] = new Image("Images/manUP2.gif");
			movementDown[0] = new Image("Images/manDOWN.gif");
			movementDown[1] = new Image("Images/manDOWN2.gif");
			movementLeft[0] = new Image("Images/manLEFT.gif");
			movementLeft[1] = new Image("Images/manLEFT2.gif");
			movementRight[0] = new Image("Images/manRIGHT.gif");
			movementRight[1] = new Image("Images/manRIGHT2.gif");
		}
		if (s == "Dog") {
			movementUp[0] = new Image("Images/mantwoUP.gif");
			movementUp[1] = new Image("Images/mantwoUP2.gif");
			movementDown[0] = new Image("Images/mantwoDOWN.gif");
			movementDown[1] = new Image("Images/mantwoDOWN2.gif");
			movementLeft[0] = new Image("Images/mantwoLEFT.gif");
			movementLeft[1] = new Image("Images/mantwoLEFT2.gif");
			movementRight[0] = new Image("Images/mantwoRIGHT.gif");
			movementRight[1] = new Image("Images/mantwoRIGHT2.gif");
		}
		if (s == "Mackan") {
			movementUp[0] = new Image("Images/mackanUP.png");
			movementUp[1] = new Image("Images/mackanUP2.png");
			movementDown[0] = new Image("Images/mackanDOWN.png");
			movementDown[1] = new Image("Images/mackanDOWN2.png");
			movementLeft[0] = new Image("Images/mackanLEFT.png");
			movementLeft[1] = new Image("Images/mackanLEFT2.png");
			movementRight[0] = new Image("Images/mackanRIGHT.png");
			movementRight[1] = new Image("Images/mackanRIGHT2.png");
		}
		if (s == "Anton") {
			movementUp[0] = new Image("Images/antonUP.png");
			movementUp[1] = new Image("Images/antonUP2.png");
			movementDown[0] = new Image("Images/antonDOWN.png");
			movementDown[1] = new Image("Images/antonDOWN2.png");
			movementLeft[0] = new Image("Images/antonLEFT.png");
			movementLeft[1] = new Image("Images/antonLEFT2.png");
			movementRight[0] = new Image("Images/antonRIGHT.png");
			movementRight[1] = new Image("Images/antonRIGHT2.png");
		}
		if (s == "Tomas") {
			movementUp[0] = new Image("Images/tomasUP.png");
			movementUp[1] = new Image("Images/tomasUP2.png");
			movementDown[0] = new Image("Images/tomasDOWN.png");
			movementDown[1] = new Image("Images/tomasDOWN2.png");
			movementLeft[0] = new Image("Images/tomasLEFT.png");
			movementLeft[1] = new Image("Images/tomasLEFT2.png");
			movementRight[0] = new Image("Images/tomasRIGHT.png");
			movementRight[1] = new Image("Images/tomasRIGHT2.png");
		}
		if (s == "Henrik") {
			movementUp[0] = new Image("Images/henkeUP.png");
			movementUp[1] = new Image("Images/henkeUP2.png");
			movementDown[0] = new Image("Images/henkeDOWN.png");
			movementDown[1] = new Image("Images/henkeDOWN2.png");
			movementLeft[0] = new Image("Images/henkeLEFT.png");
			movementLeft[1] = new Image("Images/henkeLEFT2.png");
			movementRight[0] = new Image("Images/henkeRIGHT.png");
			movementRight[1] = new Image("Images/henkeRIGHT2.png");

		}

		int[] duration = { 150, 150 };
		up = new Animation(movementUp, duration, true);
		down = new Animation(movementDown, duration, true);
		left = new Animation(movementLeft, duration, true);
		right = new Animation(movementRight, duration, true);
		sprite = down;
	}

	public void animationUp() {
		sprite = up;
	}

	public void animationDown() {
		sprite = down;
	}

	public void animationLeft() {
		sprite = left;
	}

	public void animationRight() {
		sprite = right;
	}

	public void drawAnimation(int x, int y, int sizeX, int sizeY) {
		sprite.draw(x, y, sizeX, sizeY);
	}
}
