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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Creates a StartUpScreen
 * 
 * @author shahdk, stewartzt, carterj3. Created Oct 28, 2011.
 */
public class StartUpScreen extends JFrame implements ActionListener,
		MouseListener {

	private JButton ok, game;
	private JLabel label1;
	private boolean gValue;

	/**
	 * Creates a standard Start up Screen
	 * 
	 * @param frame
	 * @throws IOException
	 */
	public StartUpScreen() throws IOException {

		// reads the images for the start-up screen
		BufferedImage img1 = ImageIO.read(new File("blackjack.JPG"));
		BufferedImage img2 = ImageIO.read(new File("me.JPG"));
		BufferedImage img3 = ImageIO.read(new File("Zac.JPG"));
		BufferedImage img4 = ImageIO.read(new File("Jeff.JPG"));

		// initializes the screen
		this.setTitle("BLACKJACK CASINO SIMULATION");
		this.setSize(new Dimension(850, 800));
		this.setLocation(500, 200);
		this.setLayout(new BorderLayout());

		// creates the panels in the start-up screen
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		// initializes the "Start the simulation button.
		this.ok = new JButton("START THE SIMULATION");
		Font f = new Font("Times New Roman", Font.BOLD, 17);
		this.ok.setFont(f);
		this.gValue = false;

		//
		this.game = new JButton("START THE GAME");
		Font f5 = new Font("Times New Roman", Font.BOLD, 17);
		this.game.setFont(f5);
		// intializes the label displaying black jack picture.
		this.label1 = new JLabel(new ImageIcon(img1));

		// intializes the label displaying created by line.
		JLabel label2 = new JLabel("BlackJack Casino Simulation And Game by:");
		label2.setForeground(Color.yellow);

		// intializes the label displaying Dharmin's picture.
		JLabel label3 = new JLabel(new ImageIcon(img2));
		label3.setText("Dharmin Shah");
		label3.setForeground(Color.green);
		Font f1 = new Font("Lucida Handwriting", Font.BOLD, 15);
		label3.setFont(f1);

		// intializes the label displaying Zack's picture.
		JLabel label4 = new JLabel(new ImageIcon(img3));
		label4.setText("Zack Stewart");
		label4.setForeground(Color.green);
		Font f2 = new Font("Lucida Handwriting", Font.BOLD, 15);
		label4.setFont(f2);

		// intializes the label displaying Jeff's picture.
		JLabel label5 = new JLabel(new ImageIcon(img4));
		label5.setText("Jeff Carter");
		label5.setForeground(Color.green);
		Font f3 = new Font("Lucida Handwriting", Font.BOLD, 15);
		label5.setFont(f3);

		// sets the size for every labels and the button
		this.label1.setPreferredSize(new Dimension(900, 300));
		label2.setPreferredSize(new Dimension(900, 100));
		label3.setPreferredSize(new Dimension(330, 200));
		label4.setPreferredSize(new Dimension(310, 200));
		label5.setPreferredSize(new Dimension(330, 200));
		this.ok.setPreferredSize(new Dimension(450, 100));
		this.game.setPreferredSize(new Dimension(450, 100));

		// sets the background color for labels and button
		panel1.setBackground(Color.black);
		panel2.setBackground(Color.black);
		panel3.setBackground(Color.black);
		panel4.setBackground(Color.black);
		this.ok.setBackground(Color.black);
		this.ok.setForeground(Color.cyan);
		this.game.setBackground(Color.black);
		this.game.setForeground(Color.green);

		// adds label1 to panel1
		panel1.add(this.label1);

		// adds label2 to panel2
		panel2.setLayout(new GridBagLayout());
		Font f4 = new Font("comic san sms", Font.BOLD, 35);
		label2.setFont(f4);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		panel2.add(label2, gbc);

		// adds label3 to panel3
		panel3.setLayout(new GridLayout(1, 3));
		panel3.add(label3);
		panel3.add(label4);
		panel3.add(label5);

		// adds label4 to panel4
		panel4.setLayout(new BorderLayout());
		panel4.add(panel2, BorderLayout.NORTH);
		panel4.add(panel3, BorderLayout.SOUTH);

		panel5.setLayout(new GridLayout());
		panel5.add(this.ok);
		panel5.add(this.game);

		this.label1.addMouseListener(this);
		this.ok.addActionListener(this);
		this.game.addActionListener(this);

		// adds the panels to the screen.
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel4, BorderLayout.CENTER);
		this.add(panel5, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//
		if (arg0.getSource().equals(this.ok)) {

			this.dispose();
			try {
				new CasinoFrame("BlackJack Casino", this);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		if(arg0.getSource().equals(this.game)){
			this.gValue = true;
			this.dispose();
			try {
				new CasinoFrame("BlackJack Casino", this);
			} catch (Exception exception) {
				exception.printStackTrace();
			} 
		}
	}

	/**
	 * Returns whether it is simulation or game.
	 * 
	 * @return gValue, returns true or false.
	 */
	public boolean getGame() {
		return this.gValue;
	}

	/**
	 * Sets the value of game to the given boolean value.
	 *
	 * @param value
	 */
	public void setGame(boolean value){
		this.gValue = value;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {

		JTextArea rules = new JTextArea();
		try {
			Scanner in = new Scanner(new File("Rules.txt"));
			while (in.hasNextLine()) {
				rules.append(in.nextLine());
				if (in.hasNextLine()) {
					rules.append("\n");
				}
			}
			in.close();
		} catch (FileNotFoundException exception) {
			// do nothing.

		}
		rules.setBackground(Color.black);
		rules.setForeground(Color.white);
		Font f = new Font("Times New Roman", Font.PLAIN, 19);
		rules.setFont(f);
		JFrame newFrame = new JFrame();
		newFrame.setTitle("RULES FOR BLACKJACK");
		newFrame.setSize(new Dimension(850, 800));
		newFrame.setLocation(500, 200);
		newFrame.add(rules);
		newFrame.setVisible(true);
		newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// do nothing.

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// do nothing

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// do nothing

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// do nothing.

	}

}
