package simulation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Creates the deck changer frame and allows the user to change the cards in the
 * deck.
 * 
 * @author Jeff Carter, Dharmin Shah, Zack Stewart. Created Oct 18, 2011.
 */
public class DeckChanger extends JFrame implements ActionListener,
		ChangeListener {
	private ArrayList<Card> deckToChange;
	private JSpinner aces, twos, threes, fours, fives, sixes, sevens, eights,
			nines, tens, jacks, queens, kings;
	private Table myTable;
	private JButton updateButton;
	private JButton defaultButton, exitButton;
	private JLabel validStatus;

	/**
	 * Creates the deck changer frame.
	 * 
	 * @param deckSet
	 * @param tableSet
	 */
	public DeckChanger(ArrayList<Card> deckSet, Table tableSet) {

		super("Deck Changer");

		// Sets Fields
		this.deckToChange = deckSet;
		this.myTable = tableSet;

		// Sets Window Options
		this.setResizable(false);
		this.setSize(250, 400);
		this.setLayout(new GridLayout(15, 2));

		// Sets the Various Components of the Changer.

		JLabel aceLabel = new JLabel("Aces");
		aceLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(aceLabel);
		this.aces = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.aces);

		JLabel kingLabel = new JLabel("Kings");
		kingLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(kingLabel);
		this.kings = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.kings);

		JLabel queenLabel = new JLabel("Queens");
		queenLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(queenLabel);
		this.queens = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.queens);

		JLabel jackLabel = new JLabel("Jacks");
		jackLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(jackLabel);
		this.jacks = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.jacks);

		JLabel tenLabel = new JLabel("Tens");
		tenLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(tenLabel);
		this.tens = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.tens);

		JLabel nineLabel = new JLabel("Nines");
		nineLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(nineLabel);
		this.nines = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.nines);

		JLabel eightLabel = new JLabel("Eights");
		eightLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(eightLabel);
		this.eights = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.eights);

		JLabel sevenLabel = new JLabel("Sevens");
		sevenLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(sevenLabel);
		this.sevens = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.sevens);

		JLabel sixLabel = new JLabel("Sixes");
		sixLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(sixLabel);
		this.sixes = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.sixes);

		JLabel fiveLabel = new JLabel("Fives");
		fiveLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(fiveLabel);
		this.fives = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.fives);

		JLabel fourLabel = new JLabel("Fours");
		fourLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(fourLabel);
		this.fours = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.fours);

		JLabel threeLabel = new JLabel("Threes");
		threeLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(threeLabel);
		this.threes = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.threes);

		JLabel twoLabel = new JLabel("Twos");
		twoLabel.setBorder(new LineBorder(Color.BLACK));
		this.add(twoLabel);
		this.twos = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		this.add(this.twos);

		this.validStatus = new JLabel("VALID");
		this.updateButton = new JButton("Change Deck");
		this.updateButton.addActionListener(this);
		this.exitButton = new JButton("Exit");
		this.exitButton.addActionListener(this);
		this.defaultButton = new JButton("Get Defaults");
		this.defaultButton.addActionListener(this);
		this.add(this.updateButton);
		this.add(this.defaultButton);
		this.add(this.exitButton);
		this.add(this.validStatus);

		this.setValues();

		this.twos.addChangeListener(this);
		this.threes.addChangeListener(this);
		this.fours.addChangeListener(this);
		this.fives.addChangeListener(this);
		this.sixes.addChangeListener(this);
		this.sevens.addChangeListener(this);
		this.eights.addChangeListener(this);
		this.nines.addChangeListener(this);
		this.tens.addChangeListener(this);
		this.jacks.addChangeListener(this);
		this.queens.addChangeListener(this);
		this.kings.addChangeListener(this);
		this.aces.addChangeListener(this);

		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * Sets the value of the JSpinner to what the deck currently has.
	 * 
	 */
	private void setValues() {
		for (int x = 0; x < this.deckToChange.size(); x++) {

			switch (this.deckToChange.get(x).getValue()) {
			case 11:
				this.aces
						.setValue(new Integer(this.aces.getValue().toString()) + 1);
				break;
			case 2:
				this.twos
						.setValue(new Integer(this.twos.getValue().toString()) + 1);
				break;
			case 3:
				this.threes.setValue(new Integer(this.threes.getValue()
						.toString()) + 1);
				break;
			case 4:
				this.fours.setValue(new Integer(this.fours.getValue()
						.toString()) + 1);
				break;
			case 5:
				this.fives.setValue(new Integer(this.fives.getValue()
						.toString()) + 1);
				break;
			case 6:
				this.sixes.setValue(new Integer(this.sixes.getValue()
						.toString()) + 1);
				break;
			case 7:
				this.sevens.setValue(new Integer(this.sevens.getValue()
						.toString()) + 1);
				break;
			case 8:
				this.eights.setValue(new Integer(this.eights.getValue()
						.toString()) + 1);
				break;
			case 9:
				this.nines.setValue(new Integer(this.nines.getValue()
						.toString()) + 1);
				break;

			// Complex Case because multiple cards have the value of 10.
			case 10:
				if (this.deckToChange.get(x).getName().equals("10"))
					this.tens.setValue(new Integer(this.tens.getValue()
							.toString()) + 1);
				if (this.deckToChange.get(x).getName().equals("J"))
					this.jacks.setValue(new Integer(this.jacks.getValue()
							.toString()) + 1);
				if (this.deckToChange.get(x).getName().equals("Q"))
					this.queens.setValue(new Integer(this.queens.getValue()
							.toString()) + 1);
				if (this.deckToChange.get(x).getName().equals("K"))
					this.kings.setValue(new Integer(this.kings.getValue()
							.toString()) + 1);
				break;

			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.updateButton)) {

			// if the deck is less than 16, our minimum deck size
			if (this.deckToChange.size() < 16) {

				JOptionPane
						.showMessageDialog(
								this,
								"Invalid Deck Configuration. Size must be greater than 16.",
								"ERROR", JOptionPane.PLAIN_MESSAGE);

			}

			else {
				this.myTable.resumeGame();
				this.dispose();
			}
		}
		if (e.getSource().equals(this.defaultButton)) {
			this.aces.setValue(new Integer(4));
			this.twos.setValue(new Integer(4));
			this.threes.setValue(new Integer(4));
			this.fours.setValue(new Integer(4));
			this.fives.setValue(new Integer(4));
			this.sixes.setValue(new Integer(4));
			this.sevens.setValue(new Integer(4));
			this.eights.setValue(new Integer(4));
			this.nines.setValue(new Integer(4));
			this.tens.setValue(new Integer(4));
			this.jacks.setValue(new Integer(4));
			this.queens.setValue(new Integer(4));
			this.kings.setValue(new Integer(4));
		}
		if (e.getSource().equals(this.exitButton)) {
			this.myTable.resumeGame();
			this.dispose();
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {

		this.deckToChange.clear();

		for (int x = 0; x < (Integer) this.aces.getValue(); x++) {
			this.deckToChange.add(new Card(11, "A", 0));
		}

		for (int x = 0; x < (Integer) this.twos.getValue(); x++) {
			this.deckToChange.add(new Card(2, "2", 0));
		}

		for (int x = 0; x < (Integer) this.threes.getValue(); x++) {
			this.deckToChange.add(new Card(3, "3", 0));
		}

		for (int x = 0; x < (Integer) this.fours.getValue(); x++) {
			this.deckToChange.add(new Card(4, "4", 0));
		}

		for (int x = 0; x < (Integer) this.fives.getValue(); x++) {
			this.deckToChange.add(new Card(5, "5", 0));
		}

		for (int x = 0; x < (Integer) this.sixes.getValue(); x++) {
			this.deckToChange.add(new Card(6, "6", 0));
		}

		for (int x = 0; x < (Integer) this.sevens.getValue(); x++) {
			this.deckToChange.add(new Card(7, "7", 0));
		}

		for (int x = 0; x < (Integer) this.eights.getValue(); x++) {
			this.deckToChange.add(new Card(8, "8", 0));
		}

		for (int x = 0; x < (Integer) this.nines.getValue(); x++) {
			this.deckToChange.add(new Card(9, "9", 0));
		}

		for (int x = 0; x < (Integer) this.tens.getValue(); x++) {
			this.deckToChange.add(new Card(10, "10", 0));
		}

		for (int x = 0; x < (Integer) this.jacks.getValue(); x++) {
			this.deckToChange.add(new Card(10, "J", 0));
		}

		for (int x = 0; x < (Integer) this.queens.getValue(); x++) {
			this.deckToChange.add(new Card(10, "Q", 0));
		}

		for (int x = 0; x < (Integer) this.kings.getValue(); x++) {
			this.deckToChange.add(new Card(10, "K", 0));
		}

		if (this.deckToChange.size() < 16) {
			this.validStatus.setText("INVALID");
		} else {
			this.validStatus.setText("VALID");
		}

	}

}
