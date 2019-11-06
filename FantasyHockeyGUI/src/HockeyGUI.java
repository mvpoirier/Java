/**
 * Displaying a fantasy hockey team with a GUI interface, using a user-implemented Linked List.
 * @author 	Mike Poirier
 * @version 1.0
 * @date 	2019-07-27
 */

//Imports from Eclipse WindowBuilder GUI design add-on
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

//Imports for individual dialog boxes
import javax.swing.JOptionPane;

//Imports for File I/O
//import java.util.*;
//import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 	Main method: Create fantasy teams, and run GUI.
 */

public class HockeyGUI extends JFrame {

	int num = 0;
	private JPanel contentPane;

	public static void main(String[] args) throws IOException { // Need to throw IOE when creating a file.

		FantasyTeam chosenTeam;

		// wpgJets: hard-coded test team of players from the Winnipet Jets.
		FantasyTeam wpgJets = new FantasyTeam();
		HockeyPlayer bW = new HockeyPlayer("Blake", "Wheeler", 32, "Jets", "RW", 26);
		HockeyPlayer dB = new HockeyPlayer("Dustin", "Byfuglien", 34, "Jets", "RD", 33);
		FantasyTeam.insert(wpgJets, bW);
		FantasyTeam.insert(wpgJets, dB);
		FantasyTeam.printTeam(wpgJets);

		// mockarooTeam: an imported team in a .csv file, delinated by tabs, from
		// https://mockaroo.com/
		// Read the file, and populate the fanatasy team
		FantasyTeam mockarooTeam = new FantasyTeam();
		FileReader reader = new FileReader("MOCK_DATA.csv");
		BufferedReader br = new BufferedReader(reader);
		String line;
		br.readLine(); // ignore header (row 1)
		int teamNum = 0;
		while ((line = br.readLine()) != null && teamNum < 30) {
			String[] stats = line.split(","); // split each data member, separated by a comma, store in a String array
			HockeyPlayer newPlayer = new HockeyPlayer(stats[0], stats[1], Integer.parseInt(stats[2]), stats[3],
					stats[4], Integer.parseInt(stats[5]));
			FantasyTeam.insert(mockarooTeam, newPlayer);
			teamNum++;
		}
		FantasyTeam.printTeam(mockarooTeam);

		// Ask user which team (wpgJets or mockarooTeam) to use with JOptionPane prompt.
		Object[] options = { "Winnipeg Jets", "Mockaroo Team" };
		int n = JOptionPane.showOptionDialog(null, "Which fantasy team would you like to import?", "Team Choice",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		// Set chosenTeam, based on user choice
		if (n == 0) {
			chosenTeam = wpgJets;
		} else {
			chosenTeam = mockarooTeam;
		}

		// Run GUI JFrame interface, designed using Eclipse's WindowBuilder addon
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HockeyGUI frame = new HockeyGUI(chosenTeam);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: Designed in Eclipse's WindowBuilder addon
	 */

	public HockeyGUI(FantasyTeam team) {
		setResizable(false);
		setTitle("HockeyPlayers Fantasy Roster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblLastname = new JLabel("lastName");
		contentPane.add(lblLastname);

		JLabel lblFirstname = new JLabel("firstName");
		contentPane.add(lblFirstname);

		JLabel lblTeam = new JLabel("team");
		contentPane.add(lblTeam);

		JLabel lblAge = new JLabel("age");
		contentPane.add(lblAge);

		JLabel lblPosition = new JLabel("position");
		contentPane.add(lblPosition);

		JLabel lblNumber = new JLabel("jerseyNumber");
		contentPane.add(lblNumber);

		JButton btnNextPlayer = new JButton("Next Player");
		btnNextPlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnNextPlayer);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnReset);

		// actions for when next button is clicked
		btnNextPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Node currNode = team.head;

				for (int i = 0; i < num; i++) {
					currNode = currNode.next;
				}

				if (currNode != null) {
					lblLastname.setText(currNode.player.getLastName());
					lblFirstname.setText(currNode.player.getFirstName());
					lblAge.setText("Age: " + Integer.toString(currNode.player.getAge()));
					lblTeam.setText(currNode.player.getTeam());
					lblPosition.setText(currNode.player.getPosition());
					lblNumber.setText("#" + Integer.toString(currNode.player.getNumber()));
					num++;
				} else {
					JOptionPane.showMessageDialog(null, "End of Fantasy Team Roster!\n" + num + " players total.");
				}

			}
		});

		// actions for when reset button is clicked.
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				num = 0;
				lblLastname.setText("lastName");
				lblFirstname.setText("firstName");
				lblAge.setText("age");
				lblTeam.setText("team");
				lblPosition.setText("position");
				lblNumber.setText("jerseyNumber");
				JOptionPane.showMessageDialog(null, "Fantasy Roster is Reset!");
			}
		});

	}
}
