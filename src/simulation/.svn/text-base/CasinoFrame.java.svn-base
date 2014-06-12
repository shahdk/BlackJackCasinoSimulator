package simulation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Creates the main Frame.
 * 
 * @author shahdk. Created Oct 17, 2011.
 */
public class CasinoFrame extends JFrame implements MouseListener,
		ActionListener {

	private JPanel panel1, panel2;
	private String playerName;
	private ManagerOptionsPanel optionsPanel;

	private Casino myCasino;

	private TablePanel table1;

	private TablePanel table2;

	private TablePanel table3;

	private boolean swapping = false;

	private PlayerLabel player1;

	private PlayerLabel player2;
	private Table playerTable1;
	private StartUpScreen startScreen;
	private boolean killing = false;

	private boolean adding = false;
	private Clip clickClip = null;
	private InputStream in;
	private AudioInputStream ais;
	private JFrame tFrame;
	private JPanel p1, p2;
	private JTextField name;
	private JComboBox tableCombo;

	/**
	 * Creates the CasinoFrame
	 * 
	 * @param setTitle
	 *            title to Set window as.
	 * @param screen
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public CasinoFrame(String setTitle, StartUpScreen screen)
			throws LineUnavailableException, UnsupportedAudioFileException,
			IOException {
		super(setTitle);
		this.setSize(1920, 1040);
		this.setResizable(false);
		this.startScreen = screen;
		this.in = new FileInputStream("GunCrowd.wav");
		this.clickClip = AudioSystem.getClip();
		this.ais = AudioSystem.getAudioInputStream(new BufferedInputStream(
				this.in));
		this.playerName = null;
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		this.panel1.setPreferredSize(new Dimension(180, 1040));
		this.panel1.setLayout(new BorderLayout());
		this.optionsPanel = new ManagerOptionsPanel(this);
		this.panel1.add(this.optionsPanel, BorderLayout.CENTER);
		this.setLayout(new BorderLayout());
		this.panel2.setPreferredSize(new Dimension(1740, 1040));
		this.panel2.setLayout(new GridLayout(1, 3));
		this.table1 = new TablePanel(this, 5, 1);
		this.table2 = new TablePanel(this, 10, 2);
		this.table3 = new TablePanel(this, 15, 3);
		this.panel2.add(this.table1);
		this.panel2.add(this.table2);
		this.panel2.add(this.table3);

		this.myCasino = new Casino(this.table1.getTable(),
				this.table2.getTable(), this.table3.getTable(), this);

		this.add(this.panel1, BorderLayout.WEST);
		this.add(this.panel2, BorderLayout.CENTER);

		this.table1.addMouseListener(this);
		this.table2.addMouseListener(this);
		this.table3.addMouseListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		if (screen.getGame() == true) {
			this.tFrame = new JFrame("Select Table");
			this.tFrame.setSize(380, 100);
			this.tFrame.setLocation(450, 200);
			this.p1 = new JPanel();
			this.p2 = new JPanel();
			this.name = new JTextField();
			this.name.setPreferredSize(new Dimension(100, 25));
			this.name.addActionListener(this);
			this.tFrame.setLayout(new GridLayout(2, 1));
			JLabel message1 = new JLabel("Enter first initials and last name");
			JLabel message = new JLabel("Select the Table you want to play on:");
			this.p2.add(message1);
			this.p2.add(this.name);
			this.p1.add(message);
			this.tableCombo = new JComboBox();
			this.tableCombo.addItem("$5");
			this.tableCombo.addItem("$10");
			this.tableCombo.addItem("$15");
			this.tableCombo.addActionListener(this);
			this.p1.add(this.tableCombo);
			this.tFrame.add(this.p1);
			this.tFrame.add(this.p2);
			this.tFrame.setVisible(true);
			this.tFrame
					.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			this.table1.getTable().startThread(false);
			this.table2.getTable().startThread(false);
			this.table3.getTable().startThread(false);
		}
	}

	/**
	 * returns the start up screen.
	 * 
	 * @return returns the start up screen
	 */
	public StartUpScreen getScreen() {
		return this.startScreen;
	}

	/**
	 * 
	 * Repaints the frame
	 * 
	 */
	public void repaintFrame() {
		repaint();
	}

	/**
	 * Returns the Option Panel
	 * 
	 * @return this.optionsPanel
	 */
	public ManagerOptionsPanel getOptionsPanel() {
		return this.optionsPanel;
	}

	private PlayerLabel getPlayerLabel(Table t, int x, int y) {
		for (PlayerLabel p : t.getLabel()) {
			if (p.contains(x, y)) {
				return p;
			}
		}
		return null;
	}

	private Table getTable(MouseEvent e) {
		if (e.getSource().equals(this.table1)) {
			return this.table1.getTable();

		} else if (e.getSource().equals(this.table2)) {
			return this.table2.getTable();

		} else if (e.getSource().equals(this.table3)) {
			return this.table3.getTable();
		}

		return null;
	}

	/**
	 * Resets the Swapping variables
	 * 
	 */
	private void resetSwapping() {
		try {
			this.adding = false;
			this.killing = false;

			this.swapping = !this.swapping;
			if (this.player1 != null) {
				this.player1.selected(false);
			}
			this.player1 = null;
			if (this.player2 != null) {
				this.player2.selected(false);
			}
			this.player2 = null;
		} catch (Exception e) {
			if (this.myCasino.isDebugging) {
				e.printStackTrace();
			}
		}

		repaint();
		this.table1.repaint();
		this.table2.repaint();
		this.table3.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		if (this.swapping) {
			if (this.player1 == null) {
				this.player1 = getPlayerLabel(getTable(e), mouseX, mouseY);
				this.player1.selected(true);
				repaint();
				this.playerTable1 = getTable(e);
			} else {
				this.player2 = getPlayerLabel(getTable(e), mouseX, mouseY);
				if (!(this.player2 == null) || (this.player1 == null)) {
					this.player2.selected(true);
					repaint();

					try {
						Thread.sleep(500);
					} catch (InterruptedException exception) {
						if (this.myCasino.isDebugging) {
							exception.printStackTrace();
						}
					}
					// Interrupt
					this.playerTable1.pauseGame();
					getTable(e).pauseGame();
					Player holder = this.player1.getPlayer();
					Player holder2 = this.player2.getPlayer();

					if (holder != null && holder2 != null) {
						this.player1.setPlayer(holder2);
						this.player2.setPlayer(holder);

						int temp1 = holder.getPosition();
						int temp2 = holder2.getPosition();

						if (!(this.playerTable1.hasPlayers(holder, holder2))) {
							this.getTable(e).swapPlayer(holder, holder2);
						}
						this.playerTable1.swapPlayer(holder2, holder);
						holder2.setPosition(temp1);
						holder.setPosition(temp2);

					}

					try {
						Thread.sleep(2000);
					} catch (InterruptedException exception) {
						if (this.myCasino.isDebugging) {
							exception.printStackTrace();
						}
					}

					resetSwapping();
					// Resume
					if (getTable(e).equals(this.playerTable1)) {
						this.playerTable1.resumeGame();
					} else {
						this.playerTable1.resumeGame();
						getTable(e).resumeGame();
					}
				}
			}
		} else if (this.killing) {
			if (this.clickClip.isOpen()) {
				
				this.clickClip.stop();
				this.clickClip.close();
			}
			this.player1 = getPlayerLabel(getTable(e), mouseX, mouseY);
			if (!(this.player1 == null)) {
				getTable(e).pauseGame();
				int stolenCash = this.player1.getPlayer().getCash();
				this.optionsPanel.changeProfit(stolenCash);

				// Thread needs to sleep or it doesn't restart properly
				try {
					Thread.sleep(50);
				} catch (InterruptedException exception) {
					if (this.myCasino.isDebugging) {
						exception.printStackTrace();
					}
				}

				getTable(e)
						.removePlayer(
								getPlayerLabel(getTable(e), mouseX, mouseY)
										.getPlayer());
				getPlayerLabel(getTable(e), mouseX, mouseY).setPlayer(null);
				getTable(e).resumeGame();
				try {
					this.clickClip.open(this.ais);
					this.clickClip.start();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				this.killing = false;

			}
		}

		else if (this.adding) {
			try {
				if (null == getPlayerLabel(getTable(e), mouseX, mouseY)) {
					return;
				}
				getTable(e).pauseGame();
				this.playerTable1 = getTable(e);
				try {
					Thread.sleep(500);
				} catch (Exception e2) {
					if (this.myCasino.isDebugging) {
						e2.printStackTrace();
					}
				}
				// Table, position
				if (this.playerTable1.equals(this.table1.getTable())) {

					this.myCasino.addPlayer(1,
							getPlayerLabel(getTable(e), mouseX, mouseY));

				} else if (this.playerTable1.equals(this.table2.getTable())) {
					this.myCasino.addPlayer(2,
							getPlayerLabel(getTable(e), mouseX, mouseY));
				} else if (this.playerTable1.equals(this.table3.getTable())) {
					this.myCasino.addPlayer(3,
							getPlayerLabel(getTable(e), mouseX, mouseY));
				}

				try {
					Thread.sleep(500);
				} catch (Exception e2) {
					if (this.myCasino.isDebugging) {
						e2.printStackTrace();
					}
				}

				this.adding = false;
				getTable(e).resumeGame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else {
			this.player1 = getPlayerLabel(getTable(e), mouseX, mouseY);
			if (this.player1 != null && this.player1.getPlayer() != null) {
				this.player1.getPlayer().displayStats(getTable(e));
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Do nothing

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Do nothing

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Do nothing

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Do nothing

	}

	/**
	 * Resets the swapping.
	 * 
	 */
	public void swap() {

		this.adding = false;
		this.killing = false;
		resetSwapping();

	}

	/**
	 * Changes the killing status.
	 * 
	 */
	public void kill() {
		this.swapping = false;
		this.adding = false;
		this.killing = !this.killing;

	}

	/**
	 * Sets the AddPlayer status.
	 * 
	 */
	public void addPlayer() {
		this.killing = false;
		this.swapping = false;
		this.adding = !this.adding;
	}

	/**
	 * Returns the Casino Value
	 * 
	 * @return myCasino
	 */
	public Casino getCasino() {
		return this.myCasino;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i = 0;
		if (arg0.getSource().equals(this.tableCombo)) {
			i = this.tableCombo.getSelectedIndex();
		}
		if (arg0.getSource().equals(this.name)) {
			i = this.tableCombo.getSelectedIndex();
			this.playerName = this.name.getText();
			if (i == 0) {
				int pos = (int)((Math.random()*14)+1);
//				System.out.println(pos);
				Player temp = new Player(this.playerName, pos, false);
				temp.setTable(this.table1.getTable());
				this.table1.getTable().setPlayer(this.playerName, pos, temp);
				this.table1.getTable().startThread(true);
				this.table2.getTable().startThread(false);
				this.table3.getTable().startThread(false);
				this.tFrame.dispose();
			} else if (i == 1) {
				int pos = (int)((Math.random()*14)+1);
//				System.out.println(pos);
				Player temp = new Player(this.playerName, pos, false);
				temp.setTable(this.table2.getTable());
				this.table2.getTable().setPlayer(this.playerName, pos, temp);
				this.table2.getTable().startThread(true);
				this.table1.getTable().startThread(false);
				this.table3.getTable().startThread(false);
				this.tFrame.dispose();
			} else if (i == 2) {
				int pos = (int)((Math.random()*14)+1);
//				System.out.println(pos);
				Player temp = new Player(this.playerName, pos, false);
				temp.setTable(this.table3.getTable());
				this.table3.getTable().setPlayer(this.playerName, pos, temp);
				this.table3.getTable().startThread(true);
				this.table1.getTable().startThread(false);
				this.table2.getTable().startThread(false);
				this.tFrame.dispose();
			}
		}
	}
	
	/**
	 * Returns the name of player entered by the user.
	 *
	 * @return playerName, returns the name of the player.
	 */
	public String getPlayerName(){
		return this.playerName;
	}
}