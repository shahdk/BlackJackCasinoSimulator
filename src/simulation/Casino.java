package simulation;


import java.util.ArrayList;
import java.util.HashMap;
/**
 * The Casino "storage" class
 * 
 * @author stewarzt, shahdk, carterj3. Created Oct 20, 2011.
 */
public class Casino {

	/**
	 * Debug Mode
	 */
	public boolean isDebugging = false;
	private Table table1, table2, table3;
	private HashMap<Player, Table> playersAtTable;
	private ArrayList<Player> myPlayers;

	/**
	 * Creates the Casino class
	 * 
	 * @param t1
	 *            table 1
	 * @param t2
	 *            table 2
	 * @param t3
	 *            table 3
	 * @param frame 
	 */
	public Casino(Table t1, Table t2, Table t3, CasinoFrame frame) {
		this.table1 = t1;
		this.table2 = t2;
		this.table3 = t3;
		this.playersAtTable = new HashMap<Player, Table>();
		this.myPlayers = new ArrayList<Player>();
		String[] firstNames = { "A. ", "B. ", "C. ", "D. ", "E. ", "F. ",
				"G. ", "H. ", "I. ", "J. ", "K. ", "L. ", "M. ", "N. ", "O. ",
				"P. ", "Q. ", "R. ", "S. ", "T. ", "U. ", "V. ", "W. ", "X. ",
				"Y. ", "Z. " };

		String[] lastNames = { "Bond", "Pitt", "Evans", "Ford", "Hope", "Beck",
				"Webb", "Ray", "Parker", "Wells", "Forest", "Lake", "Smith",
				"Shah", "Carter", "Fair", "Puetz", "Stewart", "Lowe", "Katz",
				"Barber", "Bander", "Hand", "Wand", "Mac", "Woods" };

		for (int x = 1; x <= 200; x++) {
			Player temp = new Player(
					firstNames[(int) (Math.random() * (firstNames.length - 1))]
							+ lastNames[(int) (Math.random() * (lastNames.length - 1))],
					0, this.isDebugging);

			if (!this.myPlayers.contains(temp)) {
				this.playersAtTable.put(temp, null);
				this.myPlayers.add(temp);
			}

		}

		for (int x = 1; x <= 16; x += 2) {
			boolean added = false;
			while (!added) {
				Player temp = this.myPlayers.get((int) ((Math.random()
						* this.myPlayers.size() - 1)));
				if (this.playersAtTable.get(temp) == null) {
					temp.setPosition(x);
					this.table1.addPlayer(temp);
					this.playersAtTable.put(temp, this.table1);
					temp.setTable(this.table1);
					added = true;
				}

			}

		}
		for (int x = 1; x <= 16; x += 2) {
			boolean added = false;
			while (!added) {
				Player temp = this.myPlayers.get((int) ((Math.random()
						* this.myPlayers.size() - 1)));
				if (this.playersAtTable.get(temp) == null) {
					temp.setPosition(x);
					this.table2.addPlayer(temp);
					this.playersAtTable.put(temp, this.table2);
					temp.setTable(this.table2);
					added = true;
				}

			}

		}

		for (int x = 1; x <= 16; x += 2) {
			boolean added = false;
			while (!added) {
				Player temp = this.myPlayers.get((int) ((Math.random()
						* this.myPlayers.size() - 1)));
				if (this.playersAtTable.get(temp) == null) {
					temp.setPosition(x);
					this.table3.addPlayer(temp);
					this.playersAtTable.put(temp, this.table3);
					temp.setTable(this.table3);
					added = true;
				}

			}

		}
		
	}

	/**
	 * Adds a Player from the HashMap
	 * 
	 * @param tableNum
	 * @param label
	 */
	public void addPlayer(int tableNum, PlayerLabel label) {
		Player temp = new Player("", 0, this.isDebugging);
		boolean added = false;

		if (null == (label)) {
			return;
		}

		while (!added) {
			try {
				temp = this.myPlayers.get((int) ((Math.random()
						* this.myPlayers.size() - 1)));
				if (this.playersAtTable.get(temp) == null) {
					temp.setPosition(label.getPosition());
					label.setPlayer(temp);
					added = true;
				}
			} catch (Exception e) {
				try {
					Thread.sleep(500);
				} catch (Exception e2) {
					if (this.isDebugging) {
						e2.printStackTrace();
					}
				}
				if (this.isDebugging) {
					e.printStackTrace();
				}

			}

		}

		switch (tableNum) {

		case 1:

			this.table1.addPlayer(temp);
			this.playersAtTable.put(temp, this.table1);
			break;

		case 2:
			this.table2.addPlayer(temp);
			this.playersAtTable.put(temp, this.table2);
			break;

		case 3:
			this.table3.addPlayer(temp);
			this.playersAtTable.put(temp, this.table3);
			break;

		}
	}
}
