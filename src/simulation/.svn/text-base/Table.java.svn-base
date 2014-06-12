package simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 * This class contains the code relevant to the game of the table, currently
 * BlackJack. It also Draws the table and the cards on the table.
 * 
 * @author Jeff Carter, Dharmin Shah, Zack Stewart. Created Oct 17, 2011.
 */
public class Table extends TableAbstract implements Runnable {

	private ArrayList<Card> myDeck;
	private Color[] colors = { Color.blue, Color.cyan, Color.LIGHT_GRAY,
			Color.magenta, Color.pink, Color.ORANGE, Color.green };
	private Color tableColor = null;
	private ArrayList<Player> myPlayers;
	private TablePanel tablePanel;
	private Thread myThread;
	private boolean isPaused;
	private ArrayList<PlayerLabel> labelList;
	private int tableBet;
	private int evilness;
	private boolean setValue;
	private CasinoFrame frame;

	/**
	 * Creates a table object.
	 * 
	 * @param tablePanel
	 * @param bet
	 * @param frame 
	 * @param screen
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * 
	 */

	public Table(TablePanel tablePanel, int bet, CasinoFrame frame)
			throws LineUnavailableException, UnsupportedAudioFileException,
			IOException {

		// Set Fields
		this.frame = frame;
		this.evilness = 0;
		this.tableBet = bet;
		this.changeColor();
		this.labelList = new ArrayList<PlayerLabel>();
		this.myDeck = new ArrayList<Card>();
		this.createDeck();
		this.setBorder(new LineBorder(Color.BLACK));
		this.myPlayers = new ArrayList<Player>();
		this.tablePanel = tablePanel;
		this.myThread = new Thread(this);
		this.isPaused = false;
	}

	@Override
	public ArrayList<PlayerLabel> getLabel() {
		return this.labelList;
	}

	@Override
	public void changeColor() {
		int random = (int) ((Math.random() * 7));
		this.tableColor = this.colors[random];

	}

	@Override
	public void swapPlayer(Player toSwap, Player toSwapWith) {
		// If Both are Not Null, and both are not at the same Table
		if (toSwap != null && toSwapWith != null
				&& !this.myPlayers.contains(toSwap)) {
			this.myDeck.addAll(toSwapWith.returnCards());
			this.myPlayers.set(this.myPlayers.indexOf(toSwapWith), toSwap);
		} else {

			// Return the cards to the deck.

			this.myDeck.addAll(toSwapWith.returnCards());
			this.myDeck.addAll(toSwap.returnCards());

			// Get the Positions of the players, then swap the positions.
			int position1 = toSwapWith.getPosition();
			int position2 = toSwap.getPosition();

			toSwap.setPosition(position1);
			toSwapWith.setPosition(position2);

			// Switches the spots in the ArrayList
			int spot1 = this.myPlayers.indexOf(toSwapWith);
			int spot2 = this.myPlayers.indexOf(toSwap);
			this.myPlayers.set(spot1, toSwap);
			this.myPlayers.set(spot2, toSwapWith);
		}

	}

	@Override
	public void createDeck() {
		for (int x = 0; x < 4; x++) {
			this.myDeck.add(new Card(11, "A", 0));
			this.myDeck.add(new Card(2, "2", 0));
			this.myDeck.add(new Card(3, "3", 0));
			this.myDeck.add(new Card(4, "4", 0));
			this.myDeck.add(new Card(5, "5", 0));
			this.myDeck.add(new Card(6, "6", 0));
			this.myDeck.add(new Card(7, "7", 0));
			this.myDeck.add(new Card(8, "8", 0));
			this.myDeck.add(new Card(9, "9", 0));
			this.myDeck.add(new Card(10, "10", 0));
			this.myDeck.add(new Card(10, "J", 0));
			this.myDeck.add(new Card(10, "Q", 0));
			this.myDeck.add(new Card(10, "K", 0));
		}

	}

	@Override
	public void paintComponent(Graphics g) {

		// Draws the Table.
		g.fillOval(5, 2, 570, 500);
		g.setColor(this.tableColor);
		g.fillOval(15, 11, 550, 480);

		// Draws the Cards.
		for (Player toDraw : this.myPlayers) {
			if (toDraw.getCards().size() > 0)
				toDraw.drawCards(g);
		}

		// Draws the Labels
		for (PlayerLabel temp : this.labelList) {

			temp.draw(g);
		}
	}

	@Override
	public ArrayList<Card> getDeck() {
		return this.myDeck;
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param name
	 * @param pos
	 * @param temp
	 */
	public void setPlayer(String name, int pos, Player temp){
		double pos1 = (pos/2)-(0.5);
//		System.out.println(pos1);
//		System.out.println((int)pos1);
		temp.setPosition((((int)(pos1))*2)+1);
		this.myPlayers.set((int) pos1, temp);
		this.labelList.set((int)pos1, new PlayerLabel(name, (((int)(pos1))*2)+1, temp, this.frame));
	}

	@Override
	public void addPlayer(Player temp) {
		this.myPlayers.add(temp);
		if (temp.getPosition() != 15 && this.labelList.size() < 7) {
			this.labelList.add(new PlayerLabel(temp.getName(), temp
					.getPosition(), temp, this.frame));
		}

		// Makes sure they are in ascending order of position.
		Collections.sort(this.myPlayers);

	}

	/**
	 * Starts a game, deals 2 cards to each player
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	public void startGame() throws Exception {
		try {
			// Loaning Money
			ArrayList<Player> removeP = new ArrayList<Player>();
			for (Player toDraw : this.myPlayers) {
				if (toDraw.getCash() == 0) {
					int n = JOptionPane.showConfirmDialog(this,
							"Would you like to loan " + toDraw.getName()
									+ " $100?\n" + "Player is in Debt: "
									+ toDraw.getDebt(), "Loan Money?",
							JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						toDraw.addCash(100);
						toDraw.addDebt();
					}

					else {
						removeP.add(toDraw);
					}
				}
			}

			for (Player t : removeP) {
				this.myPlayers.remove(t);
				int x = t.getPosition();
				for (PlayerLabel temp : this.labelList) {
					if (temp.getPosition() == x)
						temp.setPlayer(null);
				}
			}

			// Adds two new Cards.
			for (Player toDraw : this.myPlayers) {
				this.colorChanger();
				toDraw.addCard(this.myDeck.remove((int) (Math.random() * (this.myDeck
						.size() - 1))));
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					if (e instanceof InterruptedException) {
						throw e;
					}
					if (this.tablePanel.getFrame().getCasino().isDebugging) {
						e.printStackTrace();
					}
				}
				this.tablePanel.getFrame().repaintFrame();
				toDraw.addCard(this.myDeck.remove((int) (Math.random() * (this.myDeck
						.size() - 1))));
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					if (e instanceof InterruptedException) {
						throw e;
					}
					if (this.tablePanel.getFrame().getCasino().isDebugging) {
						e.printStackTrace();
					}
				}

				this.tablePanel.getFrame().repaintFrame();
			}
		} catch (Exception e) {
			if (e instanceof InterruptedException) {
				throw e;
			}
			if (this.tablePanel.getFrame().getCasino().isDebugging) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Ends the game, takes cards from all players, returns them to deck
	 * 
	 */
	public void endGame() {
		for (Player toDraw : this.myPlayers) {
			this.colorChanger();
			this.myDeck.addAll(toDraw.returnCards());
		}
	}

	@Override
	public void run() {

		while (true) {
			try {
				if (!this.isPaused) {

					// Start Game

					this.startGame();

					// Process the players
					this.processPlayers();

					// Process the Dealer
					this.processDealer();

					// Figure out who won and lost
					this.processWinnings();

					// End the Game
					this.endGame();
				} else {
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						if (this.tablePanel.getFrame().getCasino().isDebugging) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {

				if (this.tablePanel.getFrame().getCasino().isDebugging) {
					e.printStackTrace();
				}

				this.endGame();
				this.isPaused = true;

			}
		}

	}

	@Override
	public void processWinnings() {
		int dealerValue = 0;
		// Get dealers Value
		for (Player toProcess : this.myPlayers) {
			this.colorChanger();
			if (toProcess.getPosition() == 15) {
				dealerValue = toProcess.getTotalValue();
				break;
			}
		}
		if (dealerValue == 0) {
			return;
		}

		int playerValue = 0;
		int bet = 0;
		// Go through players
		for (Player toProcess : this.myPlayers) {
			if (!(toProcess.getPosition() == 15)) {
				playerValue = toProcess.getTotalValue();
				bet = this.tableBet;

				// BlackJack-Win
				if (playerValue == 21 && toProcess.getCash() != 0
						&& toProcess.getCards().size() == 2
						&& dealerValue != 21) {
					toProcess.addCash((int) ((bet * 1.5) + .5));
					
					if(this.frame.getScreen().getGame()==true && this.frame.getPlayerName()==toProcess.getName()){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit((int) ((bet * 1.5) + .5));
					}
					else if(this.frame.getScreen().getGame()==true && !(this.frame.getPlayerName()==toProcess.getName())){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(0);
					}
					else{
						this.tablePanel.getFrame().getOptionsPanel()
							.changeProfit(-1 * (int) ((bet * 1.5) + .5));
					}
				}

				// Bust = lose
				else if (playerValue > 21 && toProcess.getCash() != 0) {

					toProcess.removeCash(bet);
					if(this.frame.getScreen().getGame()==true && this.frame.getPlayerName().equals(toProcess.getName())){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(-1*bet);
					}else if(this.frame.getScreen().getGame()==true && !(this.frame.getPlayerName()==toProcess.getName())){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(0);
					}
					else{
						this.tablePanel.getFrame().getOptionsPanel()
							.changeProfit(bet);
					}
				} else
				// DealerBust = win
				if (dealerValue > 21 && toProcess.getCash() != 0) {

					toProcess.addCash(bet);
					if(this.frame.getScreen().getGame()==true && this.frame.getPlayerName().equals(toProcess.getName())){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(bet);
					}else if(this.frame.getScreen().getGame()==true && !(this.frame.getPlayerName()==toProcess.getName())){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(0);
					}
					else{
					this.tablePanel.getFrame().getOptionsPanel()
							.changeProfit(-1 * bet);
					}
				} else
				// <= dealer = lose
				if (playerValue < dealerValue && toProcess.getCash() != 0) {
					
					toProcess.removeCash(bet);
					if(this.frame.getScreen().getGame()==true && this.frame.getPlayerName().equals(toProcess.getName())){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(-1*bet);
					}else if(this.frame.getScreen().getGame()==true && !(this.frame.getPlayerName()==toProcess.getName())){
						//
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(0);
					}
					else{
					this.tablePanel.getFrame().getOptionsPanel()
							.changeProfit(bet);
					}
				} else
				// else win
				if (playerValue > dealerValue && toProcess.getCash() != 0) {

					toProcess.addCash(bet);
					if(this.frame.getScreen().getGame()==true && this.frame.getPlayerName().equals(toProcess.getName())){
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(bet);
					}else if(this.frame.getScreen().getGame()==true && !(this.frame.getPlayerName()==toProcess.getName())){
						//
						this.tablePanel.getFrame().getOptionsPanel()
						.changeProfit(0);
					}
					else{
					this.tablePanel.getFrame().getOptionsPanel()
							.changeProfit(-1 * bet);
					}
				}

			}
		}
		try {
			// Wait at the end of each round
			Thread.sleep(5000);
		} catch (Exception e) {
			if (this.tablePanel.getFrame().getCasino().isDebugging) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void processDealer() {
		for (Player toProcess : this.myPlayers) {
			this.colorChanger();
			if (toProcess.getPosition() == 15) {

				while (toProcess.getTotalValue() < 17) {
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						if (this.tablePanel.getFrame().getCasino().isDebugging) {
							e.printStackTrace();
						}
					}
					if (this.myDeck.size() > 0) {
						toProcess.addCard(this.myDeck.remove((int) (Math
								.random() * (this.myDeck.size() - 1))));
						this.tablePanel.getFrame().repaintFrame();
					}
				}
			}

		}

	}

	@Override
	public void processPlayers() throws Exception {
		//
		try {
			for (Player toProcess : this.myPlayers) {
				if (toProcess.getPosition() != 15) {

					// if it is game and not simulation
					if (this.setValue == true) {
						while (willGetCard(toProcess)
								&& toProcess.getTotalValue() <= 21) {
							if (toProcess.getName().equals(this.frame.getPlayerName())) {
								int n = JOptionPane.showConfirmDialog(
										this.tablePanel.getTable(),
										"Do you want to hit?",
										toProcess.getName(),
										JOptionPane.YES_NO_OPTION);
								if (n == JOptionPane.YES_OPTION) {
									try {
										Thread.sleep(2000);
									} catch (Exception e) {
										if (e instanceof InterruptedException) {
											throw e;
										}
										if (this.tablePanel.getFrame()
												.getCasino().isDebugging) {
											e.printStackTrace();
										}
									}
									if ((this.evilness / 10) > Math.random()) {
										toProcess.addCard(this.myDeck
												.remove(getBustCard(toProcess
														.getTotalValue())));

										this.tablePanel.getFrame()
												.repaintFrame();
									} else if (this.myDeck.size() > 0) {
										toProcess
												.addCard(this.myDeck.remove((int) (Math
														.random() * (this.myDeck
														.size() - 1))));
										this.tablePanel.getFrame()
												.repaintFrame();
									}
								} else {
									break;
								}
							}
							// If the dealer is evil on this card draw.
							else {
								try {
									Thread.sleep(2000);
								} catch (Exception e) {
									if (e instanceof InterruptedException) {
										throw e;
									}
									if (this.tablePanel.getFrame().getCasino().isDebugging) {
										e.printStackTrace();
									}
								}
								if ((this.evilness / 10) > Math.random()) {
									toProcess.addCard(this.myDeck
											.remove(getBustCard(toProcess
													.getTotalValue())));

									this.tablePanel.getFrame().repaintFrame();
								} else if (this.myDeck.size() > 0) {
									toProcess
											.addCard(this.myDeck.remove((int) (Math
													.random() * (this.myDeck
													.size() - 1))));
									this.tablePanel.getFrame().repaintFrame();
								}
							}
						}
					}
					// While the player wants to get a new Card
					else {
						while (willGetCard(toProcess)
								&& toProcess.getTotalValue() < 21) {

							try {
								Thread.sleep(2000);
							} catch (Exception e) {
								if (e instanceof InterruptedException) {
									throw e;
								}
								if (this.tablePanel.getFrame().getCasino().isDebugging) {
									e.printStackTrace();
								}
							}
							if ((this.evilness / 10) > Math.random()) {
								toProcess.addCard(this.myDeck
										.remove(getBustCard(toProcess
												.getTotalValue())));

								this.tablePanel.getFrame().repaintFrame();
							} else if (this.myDeck.size() > 0) {
								toProcess
										.addCard(this.myDeck.remove((int) (Math
												.random() * (this.myDeck.size() - 1))));
								this.tablePanel.getFrame().repaintFrame();
							}
						}
					}
				}

			}
		} catch (Exception e) {
			if (e instanceof InterruptedException) {
				throw e;
			}
			if (this.tablePanel.getFrame().getCasino().isDebugging) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Returns the int of a card that will bust the player, or a low value if
	 * the players value is too low.
	 * 
	 * @param totalValue
	 * @return
	 */
	private int getBustCard(int totalValue) {

		if (totalValue > 11) {
			for (int x = 0; x < this.myDeck.size(); x++) {
				if (this.myDeck.get(x).getValue() + totalValue > 21
						&& this.myDeck.get(x).getValue() != 11)
					return x;

			}

		}

		int spot = 0;
		for (int x = 0; x < this.myDeck.size(); x++) {
			if (this.myDeck.get(x).getValue() < this.myDeck.get(spot)
					.getValue())
				spot = x;

		}
		return spot;

	}

	/**
	 * 
	 * Returns the probability that will be displayed to the user.
	 * 
	 * @param handValue
	 *            , point value of the players hands
	 * @return the probability (already in % form) that they will pick up the
	 *         card they need for a 21
	 */
	public double getDisplayProbability(int handValue) {

		int neededValue = 21 - handValue;
		if (handValue == 20)
			neededValue = 11;

		if (neededValue > 11) {
			return 0;
		}

		double deckLength = this.myDeck.size();
		double possibleCards = duplicates(neededValue, this.myDeck);

		return 100 * (possibleCards / deckLength);

	}

	/**
	 * Returns if the Player will draw another card
	 * 
	 * @param toProcess
	 * @return willDraw
	 */

	public boolean willGetCard(Player toProcess) {
		if (toProcess.getName().equals(this.frame.getPlayerName())) {
			return true;
		} else {
			int risk = toProcess.getRisk();

			switch (risk) {
			case 0:
				if (toProcess.getTotalValue() >= 17) {
					return false;
				} else {
					return true;
				}
			case 1:

				if (toProcess.getTotalValue() <= 11) {
					return true;
				} else if (toProcess.getTotalValue() > 11
						&& toProcess.getTotalValue() < 18) {
					if (Math.random() > .5) {
						return true;
					}
					return false;
				} else {
					if (Math.random() > .85) {
						return true;
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * Returns the number of duplicates in the deck.
	 * 
	 * @param i
	 * @param deck
	 * @return j, returns the number of duplicate of the given card.
	 */
	public int duplicates(int i, ArrayList<Card> deck) {
		int j = 0;
		for (Card c : deck) {
			if (c.getValue() == i) {
				j++;
			}
		}
		return j;
	}

	/**
	 * Disco lights.
	 * 
	 */
	public void colorChanger() {
		final TablePanel pane = this.tablePanel;

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						if ((pane.getMute() == false)) {
							pane.changeColor();
							try {
								Thread.sleep(85);
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							pane.setColor();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
	}

	/**
	 * Pauses the game.
	 * 
	 */
	public void pauseGame() {
		this.myThread.interrupt();

	}

	/**
	 * 
	 * Starts the Thread.
	 * 
	 * @param b
	 * 
	 */
	public void startThread(boolean b) {
		this.myThread.start();
		this.setValue = b;
	}

	/**
	 * 
	 * Resumes the game
	 * 
	 */
	public void resumeGame() {
		this.isPaused = false;
	}

	@Override
	public void removePlayer(Player p) {

		this.myPlayers.remove(p);

	}

	@Override
	public boolean hasPlayers(Player holder, Player holder2) {

		return (this.myPlayers.contains(holder) && this.myPlayers
				.contains(holder2));
	}

	@Override
	public ArrayList<Player> getPlayerList() {
		return this.myPlayers;
	}

	/**
	 * Sets the Evilness Value
	 * 
	 * @param value
	 */
	public void setEvil(int value) {
		this.evilness = value;

	}

}
