package simulation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This is the Panel for our Tables.
 * 
 * @author Dharmin Shah, Jeffrey Carter, Zack Stewart. Created Oct 17, 2011.
 */
public class TablePanel extends JPanel implements ActionListener,
		ChangeListener {

	private CasinoFrame myFrame;
	private JPanel optionPanel, sliderPanel, headerPanel, deckPanel, evilPanel, middlePanel;
	private JButton deck;
	private JSlider evilness;
	private JLabel header, slideHeader;
	private Table myTable;
	private Color originalColor;
	private Color[] colors = { Color.blue, Color.cyan, Color.magenta,
			Color.pink, Color.red, Color.ORANGE, Color.green, Color.yellow };
	private JButton discoMute;
	private boolean isMuted;

	/**
	 * Creates the Table Panel
	 * 
	 * @param frameSet
	 *            , the CasinoFrame where the TablePanel is being drawn
	 * @param bet
	 *            , the bet of the Table
	 * @param tableNo 
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	public TablePanel(CasinoFrame frameSet, int bet, int tableNo) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

		this.myFrame = frameSet;
		this.setLayout(new GridLayout(2, 1));
		this.myTable = new Table(this, bet, frameSet);
		this.add(this.myTable);
		this.originalColor = this.getBackground();
		this.isMuted = true;

		this.optionPanel = new JPanel();
		this.optionPanel.setLayout(new BorderLayout());
		this.headerPanel = new JPanel();
		this.headerPanel.setLayout(new GridBagLayout());
		this.sliderPanel = new JPanel();
		this.sliderPanel.setLayout(new BorderLayout());
		this.evilPanel = new JPanel();
		this.evilPanel.setLayout(new GridBagLayout());
		this.deckPanel = new JPanel();
		this.deckPanel.setLayout(new GridBagLayout());

		this.header = new JLabel("Table "+ tableNo+" Options");
		this.header.setFont(new Font("sanserif", Font.BOLD, 47));
		this.headerPanel.setPreferredSize(new Dimension(191, 100));
		this.headerPanel.setBackground(Color.black);
		this.header.setForeground(Color.yellow);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		this.headerPanel.add(this.header, gbc);

		this.deck = new JButton("Change Deck");
		this.deck.setFont(new Font("arial", Font.PLAIN, 32));
		this.deck.addActionListener(this);
		this.deck.setForeground(Color.pink);
		this.deck.setBackground(Color.black);
		this.deck.setBorder(new LineBorder(Color.green));
		
		this.discoMute = new JButton("DISCO ON/OFF");
		this.discoMute.setFont(new Font("sanserif", Font.PLAIN, 22));
		this.discoMute.addActionListener(this);
		this.discoMute.setBackground(Color.BLACK);
		this.discoMute.setForeground(Color.orange);
		this.discoMute.setBorder(new LineBorder(Color.green));
		
		this.middlePanel = new JPanel();
		this.middlePanel.setLayout(new GridLayout(1,2));
		this.middlePanel.setBackground(Color.black);
		this.middlePanel.setBorder(new LineBorder(Color.green));
		this.middlePanel.add(this.discoMute);
		this.middlePanel.add(this.deck);
//		this.deckPanel.setPreferredSize(new Dimension(213, 100));
//		GridBagConstraints gbc1 = new GridBagConstraints();
//		gbc1.anchor = GridBagConstraints.CENTER;
//		this.deckPanel.add(this.deck, gbc1);
//		this.deckPanel.setBackground(Color.black);
//		this.deckPanel.setBorder(new LineBorder(Color.green));

		this.evilness = new JSlider(0, 10, 0);
		this.evilness.setMajorTickSpacing(1);
		this.evilness.setPaintTicks(true);
		this.evilness.setPaintLabels(true);
		this.evilness.setPreferredSize(new Dimension(100, 150));
		this.evilness.setBackground(Color.black);
		this.evilness.setForeground(Color.white);
		this.evilness.addChangeListener(this);

		this.sliderPanel.add(this.evilness, BorderLayout.SOUTH);
		this.slideHeader = new JLabel("Evil-o-meter");
		this.slideHeader.setFont(new Font("sanserif", Font.PLAIN, 32));
		this.sliderPanel.setBackground(Color.black);
		this.slideHeader.setForeground(Color.red);
		this.evilPanel.setBackground(Color.black);
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.CENTER;
		this.evilPanel.add(this.slideHeader, gbc2);
		this.sliderPanel.add(this.evilPanel, BorderLayout.NORTH);
		this.sliderPanel.setBorder(new LineBorder(Color.green));

		this.optionPanel.add(this.middlePanel, BorderLayout.CENTER);
		this.optionPanel.add(this.headerPanel, BorderLayout.NORTH);
		this.optionPanel.add(this.sliderPanel, BorderLayout.SOUTH);
		this.optionPanel.setBorder(new LineBorder(Color.white));
		this.add(this.optionPanel);

	}

	/**
	 * Changes the color of background to a randomColor.
	 * 
	 */
	protected void changeColor() {
		int random = (int) (Math.random() * 7);
		this.setBackground(this.colors[random]);
	}
	

	/**
	 * Returns the table that this Panel holds
	 * 
	 * @return Table
	 */
	public Table getTable() {
		return this.myTable;
	}

	/**
	 * Returns the CasinoFrame that contains this tablePanel
	 * 
	 * @return CasinoFrame
	 */
	public CasinoFrame getFrame() {
		return this.myFrame;
	}

	/**
	 * resets the color of background.
	 * 
	 */
	protected void setColor() {
		this.setBackground(this.originalColor);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.deck)){
			if(this.myFrame.getScreen().getGame()==true){
				JOptionPane
				.showConfirmDialog(
						this,
						"This option is accessible only if you are the manager",
						"Access Denied", JOptionPane.CLOSED_OPTION);
			}
			else{
				this.myTable.pauseGame();
				new DeckChanger(this.myTable.getDeck(), this.myTable);
			}
		}
		if(arg0.getSource().equals(this.discoMute)){
			this.isMuted = !this.isMuted;
//			this.colorChanger();
		}
	}

	/**
	 * Changes color of the background.
	 *
	 */
	public void colorChanger() {
		final boolean mute = this.isMuted;
		System.out.println(mute);
		final TablePanel pane = this;
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						if ((mute == false)) {
							pane.changeColor();
							try {
								Thread.sleep(100);
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
	@Override
	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource().equals(this.evilness)) {
			this.myTable.setEvil(this.evilness.getValue());
		}
	}

	/**
	 * Returns whether the disco lights are turned on/off.
	 *
	 * @return isMuted, returns whether the disco lights are turned on or off.
	 */
	public boolean getMute() {
		return this.isMuted;
	}

}
