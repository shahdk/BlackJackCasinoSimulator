package simulation;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This is our Table Abstract Class
 * 
 * @author Jeff Carter, Dharmin Shah, Zack Stewart. Created Oct 30, 2011.
 */
public abstract class TableAbstract extends JPanel {

	/**
	 * Returns the label List
	 * 
	 * @return labelList, returns the ArrayList of player labels.
	 */
	public abstract ArrayList<PlayerLabel> getLabel();

	/**
	 * Randomly changes the color of the table
	 * 
	 */
	public abstract void changeColor();

	/**
	 * Swaps the players
	 * 
	 * @param toSwap
	 * @param toSwapWith
	 */
	public abstract void swapPlayer(Player toSwap, Player toSwapWith);

	/**
	 * Creates the Deck
	 * 
	 */
	public abstract void createDeck();

	/**
	 * It returns a list of cards in the deck
	 * 
	 * @return returns the arraylist of cards in the deck
	 */
	public abstract ArrayList<Card> getDeck();

	/**
	 * Add's a player to the table
	 * 
	 * @param temp
	 */
	public abstract void addPlayer(Player temp);

	/**
	 * Determines how much was won and lost in the round
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public abstract void processWinnings();

	/**
	 * Performs the dealers move
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public abstract void processDealer();

	/**
	 * Removes the Player
	 * 
	 * @param p
	 * 
	 * @param value
	 */

	public abstract void removePlayer(Player p);

	/**
	 * Returns if this table has both players
	 * 
	 * @param holder
	 * @param holder2
	 * @return boolean
	 */
	public abstract boolean hasPlayers(Player holder, Player holder2);

	/**
	 * Returns this table's Players
	 * 
	 * @return myPlayers, returns the ArrayList of players
	 */
	public abstract ArrayList<Player> getPlayerList();

	/**
	 * Processes the players, based on the rules of the game.
	 * 
	 * @throws Exception
	 * 
	 */
	public abstract void processPlayers() throws Exception;

}
