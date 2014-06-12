package simulation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import simulation.ManagerOptionsPanel;


/**
 * A class to remove the given song.
 *
 * @author shahdk.
 *         Created Nov 12, 2011.
 */
public class SongRemove implements ActionListener{

	private JButton ok, cancel;
	private JComboBox list;
	private JFrame frame;
	private ManagerOptionsPanel pane;
	private int pos = 0;
	/**
	 * A class that removes the selected song from the list.
	 * @param panelO 
	 *
	 * 
	 */
	public SongRemove(ManagerOptionsPanel panelO){
		this.frame = new JFrame("Remove Song");
		this.frame.setSize(200,150);
		this.frame.setLocation(400,200);
		this.frame.setResizable(false);
		this.frame.setLayout(new BorderLayout());
		this.pane = panelO;
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 100));

		this.list = new JComboBox(panelO.getSongName().toArray());
		this.list.addActionListener(this);
		this.list.setSelectedIndex(0);
		panel.add(this.list);
		
		JPanel panel2 = new JPanel();
		//panel2.setPreferredSize(new Dimension(200, 50));
		panel2.setLayout(new GridLayout(1,2));
		this.ok = new JButton("OK");
		panel2.add(this.ok);
		this.ok.addActionListener(this);
		
		this.cancel = new JButton("Cancel");
		this.cancel.addActionListener(this);
		panel2.add(this.cancel);
		
		this.frame.add(panel, BorderLayout.NORTH);
		this.frame.add(panel2, BorderLayout.SOUTH);
		this.frame.setVisible(true);
		
		
		this.frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.ok)){
			this.pos = this.list.getSelectedIndex();
			this.pane.removeGivenSong(this.pos);
			this.frame.dispose();
		}
		
		if(arg0.getSource().equals(this.list)){
			this.pos = this.list.getSelectedIndex();
		}
		
		if(arg0.getSource().equals(this.cancel)){
			this.frame.dispose();
		}
	}

}
