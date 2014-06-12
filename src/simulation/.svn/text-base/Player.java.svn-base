package simulation;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * A Player Object
 * 
 * @author Dharmin Shah, Jeffrey Carter, Zack Stewart. Created Oct 20, 2011.
 */
public class Player extends PlayerAbstract implements Comparable<Player> {

	private String name;
	private ArrayList<Card> myCards;
	private int position;
	private int currentCash = 150;
	private Table myTable;
	private int debt = 0;
	private int prob;
	private int risk;
	private boolean isDebugging = false;

	/**
	 * Creates a new Player
	 * 
	 * @param nameSet
	 *            , the Name of the Player
	 * @param posSet
	 *            , the Position of the player
	 * @param isDebugging
	 *            , if debugging messages should be shown
	 */
	public Player(String nameSet, int posSet, boolean isDebugging) {
		this.name = nameSet;
		this.myCards = new ArrayList<Card>();
		this.position = posSet;
		this.prob = 0;
		this.risk = (int) (Math.random() * 3);
		this.isDebugging = isDebugging;
	}

	@Override
	public void setTable(Table t)

	{
		this.myTable = t;
	}

	@Override
	public void addCard(Card toAdd) {
		toAdd.setPosition(this.position);
		toAdd.setCardNum(this.myCards.size());
		this.myCards.add(toAdd);
		try {
			this.prob = (int) this.myTable.getDisplayProbability(this
					.getTotalValue());
		} catch (Exception e) {
			if (this.isDebugging) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void drawCards(Graphics g) {
		for (Card toDraw : this.myCards) {
			toDraw.draw(g);
		}
	}

	@Override
	public ArrayList<Card> getCards() {
		return this.myCards;
	}

	@Override
	public ArrayList<Card> returnCards() {
		ArrayList<Card> temp = this.myCards;
		this.myCards = new ArrayList<Card>();
		this.prob = 0;
		return temp;
	}

	/**
	 * Get's the total of the cards.
	 * 
	 * @return value
	 */
	public int getTotalValue() {
		int temp = 0;
		for (Card adder : this.myCards) {
			temp += adder.getValue();

		}

		for (Card adder : this.myCards) {

			// Check to see if the aces made the total value over 21
			if (temp > 21 && adder.getValue() == 11) {
				temp -= 10;
			}
			if (temp < 21) {
				break;
			}

		}

		return temp;

	}

	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public int getCash() {
		return this.currentCash;
	}

	@Override
	public void addCash(int amount) {
		this.currentCash += amount;
		if (this.currentCash < 0) {
			this.debt += this.currentCash;
			this.currentCash = 0;
		} else if (this.debt < 0 && this.currentCash > 0) {
			this.debt += this.currentCash;
		}
		if (this.debt > 0) {
			this.currentCash += this.debt;
			this.debt = 0;
		}
	}

	@Override
	public int getDebt() {
		return this.debt;
	}

	@Override
	public void removeCash(int amount) {
		this.addCash(-1 * amount);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setPosition(int toSet) {
		this.position = toSet;

	}

	@Override
	public int compareTo(Player other) {

		return this.getPosition() - other.getPosition();
	}

	/**
	 * Gets the risk of this player.
	 * 
	 * @return risk
	 */
	public int getRisk() {
		return this.risk;
	}
	
	
	/**
	 * Sets the risk of the player.
	 *
	 * @param i
	 */
	public void setRisk(int i){
		this.risk = i;
	}

	/**
	 * Displays a Player's info
	 * 
	 * @param table
	 * 
	 */
	public void displayStats(Table table) {

		String temp = "";
		switch (this.risk) {
		case 0:
			temp = "Low";
			break;
		case 1:
			temp = "Medium";
			break;
		case 2:
			temp = "High";
			break;
		}

		JOptionPane.showMessageDialog(table,
				"Money: " + this.currentCash + "\nDebt: " + this.debt
						+ "\nTotal Card Value: " + this.getTotalValue()
						+ "\nRisk: " + temp, this.name,
				JOptionPane.PLAIN_MESSAGE);

	}

	/**
	 * Adds the player's money to the profit.
	 * 
	 */
	public void addDebt() {
		this.debt -= 100;

	}

	/**
	 * Returns the probability.
	 * 
	 * @return prob
	 */
	public int getProb() {

		return this.prob;
	}

}
