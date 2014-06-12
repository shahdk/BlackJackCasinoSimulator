package simulation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;

/**
 * Creates the Manager's option panel
 * 
 * @author shahdk, stewartzt, carterj3. Created Oct 17, 2011.
 */
public class ManagerOptionsPanel extends JPanel implements ActionListener {

	private CasinoFrame myFrame;
	private JButton addPlayer, swap, kill, musicMute, addSong, removeSong;
	private double profit;
	private boolean musicPlaying;
	private JLabel profitLabel, topLabel;
	private Clip clickClip;
	private AudioInputStream ais;
	private int pos;
	private InputStream in;
	private String song;
	private Lock changeLock;
	private JComboBox songCombo;
	private ArrayList<String> songPath = new ArrayList<String>();
	private ArrayList<String> songName = new ArrayList<String>();

	/**
	 * Panel for the Manager Options
	 * 
	 * @param frameSet
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 * 
	 */
	public ManagerOptionsPanel(CasinoFrame frameSet)
			throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {

		// sets up the io for getting and playing the song.
		this.song = "C:\\EclipseWorkspaces\\csse221\\Simulation\\Moves like jagger.wav";
		this.in = new FileInputStream(this.song);
		this.clickClip = AudioSystem.getClip();
		this.ais = AudioSystem.getAudioInputStream(new BufferedInputStream(
				this.in));
		this.clickClip.open(this.ais);
		this.pos = 0;
		// this.isMuted = false;
		this.musicPlaying = false;
		this.songName.add("Select Song");
		this.songName.add("Moves like jagger.wav");
		this.songPath.add(this.song);

		// creates the lock.
		this.changeLock = new ReentrantLock();

		// initializes the profit and the profit label
		if (frameSet.getScreen().getGame() == true) {
			this.profit = 150;
			this.profitLabel = new JLabel("Cash: $" + this.profit);
		} else {
			this.profit = 0;
			this.profitLabel = new JLabel("Profit: $" + this.profit);
		}
		this.profitLabel.setFont(new Font("monotype corsiva", Font.BOLD
				+ Font.ITALIC, 22));
		this.profitLabel.setForeground(Color.GREEN);
		this.profitLabel.setBorder(new LineBorder(Color.white));

		// the header label for the panel
		this.topLabel = new JLabel("Manager Options");
		this.topLabel.setFont(new Font("impact", Font.PLAIN, 25));
		this.topLabel.setForeground(Color.YELLOW);

		this.myFrame = frameSet;

		// initializes the add button.
		this.addPlayer = new JButton("ADD");
		this.addPlayer.setFont(new Font("sanserif", Font.PLAIN, 22));
		this.addPlayer.setBackground(Color.BLACK);
		this.addPlayer.setForeground(Color.MAGENTA);
		this.addPlayer.setBorder(new LineBorder(Color.white));

		// initializes the swap button.
		this.swap = new JButton("SWAP");
		this.swap.setFont(new Font("sanserif", Font.PLAIN, 22));
		this.swap.setBackground(Color.BLACK);
		this.swap.setForeground(Color.orange);
		this.swap.setBorder(new LineBorder(Color.white));

		// initializes the kill button.
		this.kill = new JButton("KILL AND LOOT");
		this.kill.setFont(new Font("sanserif", Font.PLAIN, 22));
		this.kill.setBackground(Color.BLACK);
		this.kill.setForeground(Color.RED);
		this.kill.setBorder(new LineBorder(Color.white));

		// initializes the play/pause button.
		this.musicMute = new JButton("PAUSE/PLAY");
		this.musicMute.setFont(new Font("sanserif", Font.PLAIN, 22));
		this.musicMute.setBackground(Color.BLACK);
		this.musicMute.setForeground(Color.LIGHT_GRAY);
		this.musicMute.setBorder(new LineBorder(Color.white));

		// initializes the change song button.
		this.songCombo = new JComboBox(this.songName.toArray());
		this.songCombo.setFont(new Font("sanserif", Font.PLAIN, 19));
		this.songCombo.setBackground(Color.BLACK);
		this.songCombo.setForeground(Color.ORANGE);
		this.songCombo.setSelectedIndex(0);
		this.songCombo.setVisible(true);

		// initializes the add song button
		this.addSong = new JButton("Add Song");
		this.addSong.setFont(new Font("sanserif", Font.PLAIN, 22));
		this.addSong.setBackground(Color.BLACK);
		this.addSong.setForeground(Color.GREEN);
		this.addSong.setBorder(new LineBorder(Color.white));

		this.removeSong = new JButton("Delete Song");
		this.removeSong.setFont(new Font("sanserif", Font.PLAIN, 22));
		this.removeSong.setBackground(Color.BLACK);
		this.removeSong.setForeground(Color.PINK);
		this.removeSong.setBorder(new LineBorder(Color.white));

		// this.changeSong = new JButton("CHANGE SONG");
		// this.changeSong.setFont(new Font("sanserif", Font.PLAIN, 22));
		// this.changeSong.setBackground(Color.BLACK);
		// this.changeSong.setForeground(Color.yellow);
		// this.changeSong.setBorder(new LineBorder(Color.white));

		// adds all the buttons to the panel
		this.setLayout(new GridLayout(9, 1));
		this.add(this.topLabel);
		this.add(this.addPlayer);
		this.add(this.swap);
		this.add(this.kill);
		this.add(this.profitLabel);
		// this.add(this.discoMute);
		this.add(this.musicMute);
		this.add(this.songCombo);
		this.add(this.addSong);
		this.add(this.removeSong);
		// this.add(this.changeSong);

		// adds the actionlistener to the buttons
		this.addPlayer.addActionListener(this);
		this.swap.addActionListener(this);
		this.kill.addActionListener(this);
		// this.discoMute.addActionListener(this);
		this.musicMute.addActionListener(this);
		this.songCombo.addActionListener(this);
		this.addSong.addActionListener(this);
		this.removeSong.addActionListener(this);
		// this.changeSong.addActionListener(this);

		// sets the background to black and makes the panel is visible.
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	/**
	 * 
	 * Changes the profit of the Casino by x amount
	 * 
	 * @param ammount
	 */

	public void changeProfit(double ammount) {
		if (this.myFrame.getScreen().getGame() == true) {
			this.changeLock.lock();
			try {
				this.profit += ammount;
				this.profitLabel.setText("Cash: $" + this.profit);
				this.repaint();
			} finally {
				this.changeLock.unlock();
			}
		} else {
			this.changeLock.lock();
			try {
				this.profit += ammount;

				this.profitLabel.setText("Profit: $" + this.profit);
				this.repaint();
			} finally {
				this.changeLock.unlock();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// if the user presses the add button
		if (e.getSource().equals(this.addPlayer)) {
			if (this.myFrame.getScreen().getGame() == true) {
				JOptionPane
						.showConfirmDialog(
								this,
								"This option is accessible only if you are the manager",
								"Access Denied", JOptionPane.CLOSED_OPTION);
			} else {
				this.myFrame.addPlayer();
			}
		}

		// if the user presses the swap button
		if (e.getSource().equals(this.swap)) {
			if (this.myFrame.getScreen().getGame() == true) {
				JOptionPane
						.showConfirmDialog(
								this,
								"This option is accessible only if you are the manager",
								"Access Denied", JOptionPane.CLOSED_OPTION);
			} else {
				this.myFrame.swap();
			}
		}

		// if the user presses the kill and loot button.
		if (e.getSource().equals(this.kill)) {
			if (this.myFrame.getScreen().getGame() == true) {
				JOptionPane
						.showConfirmDialog(
								this,
								"This option is accessible only if you are the manager",
								"Access Denied", JOptionPane.CLOSED_OPTION);
			} else {
				this.myFrame.kill();
			}
		}

		// if the user press the PAUSE/PLAY button
		if (e.getSource().equals(this.musicMute)) {
			if (this.songCombo.getSelectedIndex() == 0) {
				this.clickClip.close();
				this.musicPlaying = false;
			}
			if ((this.musicPlaying == false)) {
				if (this.clickClip.isActive()) {
					this.pos = this.clickClip.getFramePosition();
					this.clickClip.stop();
					this.musicPlaying = false;
				} else {
					this.clickClip.setFramePosition(this.pos);
					this.clickClip.loop(Clip.LOOP_CONTINUOUSLY);
					this.musicPlaying = true;
				}
			} else {
				this.pos = this.clickClip.getFramePosition();
				this.clickClip.stop();
				this.musicPlaying = false;
			}
		}

		if (e.getSource().equals(this.songCombo)) {
			try {
				int index = this.songCombo.getSelectedIndex();
				if (this.songName.get(index).equals("Select Song")) {

					this.clickClip.close();
					this.musicPlaying = false;
				} else {
					this.clickClip.close();
					this.song = this.songPath.get(index - 1);
					this.in = new FileInputStream(this.song);
					this.clickClip = AudioSystem.getClip();
					this.ais = AudioSystem
							.getAudioInputStream(new BufferedInputStream(
									this.in));
					this.clickClip.open(this.ais);
					this.clickClip.loop(Clip.LOOP_CONTINUOUSLY);
					this.musicPlaying = false;
					this.pos = 0;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		if (e.getSource().equals(this.addSong)) {
			FileSystemView fav = FileSystemView.getFileSystemView();
			JFileChooser songFile = new JFileChooser(fav.getRoots()[0]);
			File file = null;
			String[] s = new String[2];
			int option = songFile.showOpenDialog(ManagerOptionsPanel.this);
			if (option == JFileChooser.APPROVE_OPTION) {
				file = songFile.getSelectedFile();
				s = file.getName().split("\\.");
				if (s[1].equals("wav")) {
					for (int i = 0; i < this.songName.size(); i++) {
						if (this.songName.get(i).equals(file.getName())) {
							int n = JOptionPane
									.showConfirmDialog(
											this.myFrame,
											"The File already exists in the list. Do you want to replace it?",
											this.song,
											JOptionPane.YES_NO_OPTION);
							if (n == JOptionPane.YES_OPTION) {
								this.songPath.set(i, file.getPath());
								this.songName.set(i, file.getName());
								return;
							}
						}
					}
					this.songPath.add(file.getPath());
					this.songName.add(file.getName());
					this.songCombo.addItem(file.getName());
				}
			}
		}

		if (e.getSource().equals(this.removeSong)) {

			this.clickClip.close();
			this.musicPlaying = false;
			new SongRemove(this);
		}

	}

	/**
	 * Returns the list of song names.
	 * 
	 * @return songList, the array list of the songs.
	 */
	public ArrayList<String> getSongName() {
		return this.songName;
	}

	/**
	 * Returns the list of Song paths.
	 * 
	 * @return songPath, the list of path of the song files.
	 */
	public ArrayList<String> getSongPath() {
		return this.songPath;
	}

	/**
	 * Removes the song from the list at the given position.
	 * 
	 * @param i
	 */
	public void removeGivenSong(int i) {
		if (i == 0) {
			this.clickClip.close();
			this.musicPlaying = false;
		} else {
			this.songCombo.removeItemAt(i);
			this.songName.remove(i);
			this.songPath.remove(i - 1);
		}
	}
}
