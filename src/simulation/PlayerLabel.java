package simulation;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Holds the Card attached to a certain player. Draws the card as well.
 * 
 * @author stewarzt, shahdk, carterj3. Created Oct 18, 2011.
 */
public class PlayerLabel {

	private Player myPlayer;
	private String PlayerName;
	private int x, y, position;
	private Color colour;
	private CasinoFrame frame;
	/**
	 * Creates a card.
	 * 
	 * @param nameSet
	 *            Name of the Player
	 * @param position
	 *            Position of the Card on the table.
	 * @param playSet
	 *            pointer to the player
	 * @param frame 
	 */
	public PlayerLabel(String nameSet, int position, Player playSet, CasinoFrame frame) {
		this.frame = frame;
		this.myPlayer = playSet;
		this.PlayerName = nameSet;
		this.setXY(position);
		this.position = position;
		this.colour = Color.black;
	}

	private void setXY(int position) {
		switch (position) {
		case 1:
			this.x = 390;
			this.y = 85;
			break;
		case 3:
			this.x = 440;
			this.y = 210;
			break;
		case 5:
			this.x = 395;
			this.y = 330;
			break;
		case 7:
			this.x = 255;
			this.y = 410;
			break;
		case 9:
			this.x = 80;
			this.y = 330;
			break;
		case 11:
			this.x = 35;
			this.y = 210;
			break;
		case 13:
			this.x = 90;
			this.y = 85;
			break;
		}
	}

	/**
	 * Draws this card Object in its location.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(this.colour);
		g.fillRect(this.x, this.y, 100, 20);
		g.setColor(Color.yellow);

		if (!this.PlayerName.equals("") && !this.PlayerName.equals(this.frame.getPlayerName())) {
			g.drawString(this.PlayerName, this.x + 5, this.y + 15);
			g.drawString(this.myPlayer.getProb() + "%", this.x + 70,
					this.y + 15);
		}
		else if(this.PlayerName.equals(this.frame.getPlayerName())){
			g.setColor(Color.yellow);
			g.fillRect(this.x, this.y, 100, 20);
			g.setColor(Color.black);
			g.drawString(this.PlayerName, this.x + 5, this.y + 15);
			g.drawString(this.myPlayer.getProb() + "%", this.x + 70,
					this.y + 15);
		}
	}

	/**
	 * Changes the player that resides within this lab
	 * 
	 * @param setter
	 *            The player to change the label to
	 */
	public void setPlayer(Player setter) {
		if (setter == null) {
			this.myPlayer = setter;
			this.PlayerName = "";
		} else {
			this.myPlayer = setter;
			this.PlayerName = this.myPlayer.getName();
		}
	}

	/**
	 * 
	 * Returns the player whose label this belongs to
	 * 
	 * @return myPlayer, The player that is within this spot
	 */
	public Player getPlayer() {
		return this.myPlayer;
	}

	/**
	 * 
	 * Returns a boolean depending on whether or not a certain point is within
	 * the label.
	 * 
	 * @param otherX
	 *            , is the x position
	 * @param otherY
	 *            , is the y position
	 * @return true if the position is within the label otherwise false.
	 */
	public boolean contains(int otherX, int otherY) {

		if (this.x <= otherX && this.y <= otherY && this.x + 100 >= otherX
				&& this.y + 20 >= otherY)
			return true;
		return false;
	}

	/**
	 * Changes the color of the Label depending on if it is selected or not.
	 * 
	 * @param b
	 *            , true if it is selected or false if it is unselected.
	 */
	public void selected(boolean b) {
		if (b) {
			this.colour = Color.red;
		} else {
			this.colour = Color.black;
		}

	}

	/**
	 * Returns Position
	 * 
	 * @return position, returns the position.
	 */
	public int getPosition() {
		return this.position;
	}

}
