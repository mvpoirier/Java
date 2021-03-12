import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * FILE:	Radio.java
 * PURPOSE:	A simple GUI that collected RadioStation objects in a LinkedList,
 * 			and then displays them in the command prompt.
 *
 * @author 	github.com/mvpoirier
 * @since 	2019-12-03
 */

/**
 * CLASS:	Radio
 * PURPOSE:
 */
public class RadioStationAdder {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtStation;
	//private LinkedList<RadioStation> myStations;
	public LinkedList<RadioStation> myStations = new LinkedList<RadioStation>();
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioStationAdder window = new RadioStationAdder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RadioStationAdder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(64, 127, 130, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtStation = new JTextField();
		txtStation.setText("frequency");
		txtStation.setBounds(245, 127, 130, 26);
		frame.getContentPane().add(txtStation);
		txtStation.setColumns(10);

		JButton btnAddStation = new JButton("Add Station");
		btnAddStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Add radio station to my linked list
					myStations.add(new RadioStation(Double.parseDouble(txtStation.getText()), txtName.getText()));
				}
				catch (Exception ex){
					// If double could not be parsed, display error message
					System.out.println("\n\n*** ERROR: Frequency value not valid. ***\n\n");
				}

				// Reset text boxes
				txtName.setText("");
				txtStation.setText("");
				txtName.setFocusable(true);
				txtName.grabFocus();
			}
		});
		btnAddStation.setBounds(159, 165, 117, 29);
		frame.getContentPane().add(btnAddStation);

		JButton btnPrintStations = new JButton("Print to Console");
		btnPrintStations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Print all items in list
				RadioStation r;
				for (int i = 0; i < myStations.size(); i++) {
					r = myStations.get(i);
					System.out.println(r.name);
					System.out.println(r.freq);
					System.out.println();
				}
			}
		});
		btnPrintStations.setBounds(304, 243, 140, 29);
		frame.getContentPane().add(btnPrintStations);

		JLabel lblRadioStationAdder = new JLabel("Radio Station Adder");
		lblRadioStationAdder.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblRadioStationAdder.setBounds(123, 78, 197, 16);
		frame.getContentPane().add(lblRadioStationAdder);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Exit program (dispose frame)
				frame.dispose();
			}
		});
		btnExit.setBounds(6, 243, 117, 29);
		frame.getContentPane().add(btnExit);
	}
}

/**
 * CLASS:	RadioStation
 * PURPOSE:	RadioStation object with name and frequency data.
 */
class RadioStation {

	public double freq;
	public String name;

	public RadioStation (double freq, String name) {
		this.freq = freq;
		this.name = name;
	}
}