/*
 * NAME:	Mr. Poirier
 * DATE:	2021-04-12
 * PURPOSE:	An example of using JPanels with a top menu,
 * 			to develop a simple calculator.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants; // Message dialog windows

public class SimpleCalc2 {

	private JFrame frame;
	private JTextField txtAdd1;
	private JTextField txtAdd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc2 window = new SimpleCalc2();
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
	public SimpleCalc2() {
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
		
		// GUI COMPONENTS
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 46, 450, 232);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(new CardLayout(0, 0));
		
		JPanel panelAdd = new JPanel();
		panelAdd.setBackground(new Color(0, 250, 154));
		panelMain.add(panelAdd, "name_33337506141752");
		panelAdd.setLayout(null);
		
		JLabel lblAddTitle = new JLabel("Addition");
		lblAddTitle.setBounds(190, 6, 61, 16);
		panelAdd.add(lblAddTitle);
		
		txtAdd1 = new JTextField();
		txtAdd1.setBounds(113, 67, 66, 44);
		panelAdd.add(txtAdd1);
		txtAdd1.setColumns(10);
		
		txtAdd2 = new JTextField();
		txtAdd2.setColumns(10);
		txtAdd2.setBounds(267, 67, 66, 44);
		panelAdd.add(txtAdd2);
		
		JLabel lblAddSum = new JLabel("Enter two numbers...");
		lblAddSum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddSum.setBounds(85, 123, 272, 16);
		panelAdd.add(lblAddSum);
		
		JButton btnAdd = new JButton("Add!");
		btnAdd.setBounds(161, 170, 117, 29);
		panelAdd.add(btnAdd);
		
		JPanel panelSub = new JPanel();
		panelSub.setBackground(new Color(238, 130, 238));
		panelMain.add(panelSub, "name_34804285612054");
		panelSub.setLayout(null);
		
		JLabel lblSubTitle = new JLabel("Subtract");
		lblSubTitle.setBounds(183, 6, 61, 16);
		panelSub.add(lblSubTitle);
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTop.setBackground(new Color(0, 255, 255));
		panelTop.setBounds(6, 6, 438, 35);
		frame.getContentPane().add(panelTop);
		
		JButton btnTopAdd = new JButton("Add");
		panelTop.add(btnTopAdd);
		
		JButton btnTopSub = new JButton("Sub");
		panelTop.add(btnTopSub);
		
		JButton btnTopMult = new JButton("Mult");
		panelTop.add(btnTopMult);
		
		JButton btnTopDiv = new JButton("Div");
		panelTop.add(btnTopDiv);
		
		JButton btnTopMod = new JButton("Mod");
		panelTop.add(btnTopMod);
		
		// GUI ACTIONS
		
		btnTopAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When the MENU TOP BUTTON "Add" is clicked...
				panelAdd.setVisible(true);
				panelSub.setVisible(false);
			}
		});
		
		btnTopSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When the MENU TOP BUTTON "Sub" is clicked...
				panelAdd.setVisible(false);
				panelSub.setVisible(true);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When "Add!" button is clicked...
				int num1, num2;
				
				try {
					// Try to do this...
					num1 = Integer.parseInt(txtAdd1.getText());
					num2 = Integer.parseInt(txtAdd2.getText());
					
					lblAddSum.setText(String.valueOf(num1 + num2));
				}
				catch (Exception ex){
					// If there is an error, do this instead...
					lblAddSum.setText("Incorrect input! Please try again.");
					JOptionPane.showMessageDialog(frame, "Error!");
					System.out.println(ex.toString());
				}
			}
		});
	}
}
