package simulation;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Holds the Card attached to a certain player. Draws the card as well.
 * 
 * @author Jeff Carter, Dharmin Shah, Zack Stewart. Created Oct 18, 2011.
 */
public class Card {

	private int value, myPosition, x, y, playerPosition;
	private String valString;

	/**
	 * Creates a card.
	 * 
	 * @param valSet
	 *            Value of the Card.
	 * @param stringSet
	 *            String Value of the Card
	 * @param position
	 *            Position of the Card on the table.
	 */
	public Card(int valSet, String stringSet, int position) {
		this.x = 0;
		this.y = 0;
		this.setXY(position);
		this.value = valSet;
		this.valString = stringSet;
		this.myPosition = position;
		this.playerPosition = 0;

	}

	// Sets the X and Y positions, based on the Table Position
	private void setXY(int position) {
		switch (position) {
		case 15:
			this.x = 260 + (30 * this.myPosition);
			this.y = 35;
			break;
		case 1:
			this.x = 473 - (30 * this.myPosition);
			this.y = 120;
			break;
		case 3:
			this.x = 512 - (30 * this.myPosition);
			this.y = 240;
			break;
		case 5:
			this.x = 473 - (30 * this.myPosition);
			this.y = 360;
			break;
		case 7:
			this.x = 260 + (30 * this.myPosition);
			this.y = 435;
			break;
		case 9:
			this.x = 78 + (30 * this.myPosition);
			this.y = 360;
			break;
		case 11:
			this.x = 19 + (30 * this.myPosition);
			this.y = 240;
			break;

		case 13:
			this.x = 78 + (30 * this.myPosition);
			this.y = 120;
			break;

		}
	}

	/**
	 * Draws this card Object in its location.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(this.x, this.y, 25, 40);
		g.setColor(Color.yellow);
		if (this.valString.length() > 1)
			g.drawString(this.valString, this.x + 5, this.y + 25);
		else
			g.drawString(this.valString, this.x + 9, this.y + 25);
	}

	/**
	 * Returns the value of the card.
	 * 
	 * @return int value returns the value of the card.
	 */
	public int getValue() {

		return this.value;
	}

	/**
	 * Returns the position of the card on the table.
	 * 
	 * @return returns the position of the card.
	 */
	public int getPosit() {
		return this.myPosition;
	}

	/**
	 * Returns the string value of the card.
	 * 
	 * @return returns the string value of the card.
	 */
	public String getName() {
		return this.valString;
	}

	/**
	 * Set's the position of the card.
	 * 
	 * @param position
	 */
	public void setPosition(int position) {
		this.playerPosition = position;
		this.setXY(this.playerPosition);

	}

	/**
	 * Sets the Card Number (Which card of the player it is)
	 * 
	 * @param size
	 */
	public void setCardNum(int size) {
		this.myPosition = size;
		this.setXY(this.playerPosition);

	}
}
