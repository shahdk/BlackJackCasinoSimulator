package simulation;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This is our Abstract Player Class
 * 
 * @author Dharmin Shah, Jeffrey Carter, Zack Stewart. Created Oct 30, 2011.
 */
public abstract class PlayerAbstract {

	/**
	 * Sets the Table at which the Player is at
	 * 
	 * @param t
	 */
	public abstract void setTable(Table t);

	/**
	 * Gives a card to this player
	 * 
	 * @param toAdd
	 */
	public abstract void addCard(Card toAdd);

	/**
	 * Draws this player's cards
	 * 
	 * @param g
	 */
	public abstract void drawCards(Graphics g);

	/**
	 * Returns the Cards the Player has
	 * 
	 * @return myCards
	 */
	public abstract ArrayList<Card> getCards();

	/**
	 * Returns the cards to the deck
	 * 
	 * @return the cards to return to the deck
	 */
	public abstract ArrayList<Card> returnCards();

	/**
	 * Returns the Position Variable.
	 * 
	 * @return position
	 */
	public abstract int getPosition();

	/**
	 * 
	 * Returns the players current amount of money
	 * 
	 * @return the amount of money the player has
	 */
	public abstract int getCash();

	/**
	 * 
	 * Gives the player x amount of money
	 * 
	 * @param amount
	 *            to add
	 */
	public abstract void addCash(int amount);

	/**
	 * Returns the debt.
	 * 
	 * @return debt ,returns the player's debt.
	 */
	public abstract int getDebt();

	/**
	 * 
	 * Removes x amount of money from the player
	 * 
	 * @param amount
	 *            to remove
	 */
	public abstract void removeCash(int amount);

	/**
	 * Returns the player's name
	 * 
	 * @return name ,returns the name of the player
	 */
	public abstract String getName();

	/**
	 * Changes the Position
	 * 
	 * @param toSet
	 *            ,position that the player is now in
	 */
	public abstract void setPosition(int toSet);

}
