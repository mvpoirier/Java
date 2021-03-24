/*
 * NAME:	Mr. Poirier
 * DATE:	March 24, 2021
 * PURPOSE: GUI Tutorial Video with WindowBuilder and Eclipse.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ExampleGUI1a {

	private JFrame frmExampleGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExampleGUI1a window = new ExampleGUI1a();
					window.frmExampleGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExampleGUI1a() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExampleGUI = new JFrame();
		frmExampleGUI.setTitle("Example GUI #1");
		frmExampleGUI.setBounds(100, 100, 450, 300);
		frmExampleGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExampleGUI.getContentPane().setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.PINK);
		topPanel.setBounds(0, 0, 450, 39);
		frmExampleGUI.getContentPane().add(topPanel);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel botPanel = new JPanel();
		botPanel.setBackground(new Color(173, 216, 230));
		botPanel.setBounds(0, 38, 450, 234);
		frmExampleGUI.getContentPane().add(botPanel);
		botPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelOne = new JPanel();
		panelOne.setBackground(new Color(50, 205, 50));
		botPanel.add(panelOne, "name_421258369621014");
		
		JLabel lblPanelOne = new JLabel("Panel One!");
		panelOne.add(lblPanelOne);
		
		JPanel panelTwo = new JPanel();
		botPanel.add(panelTwo, "name_421641745570721");
		panelTwo.setBackground(new Color(255, 255, 0));
		
		JLabel lblPanelTwo = new JLabel("Panel Two!");
		panelTwo.add(lblPanelTwo);
		
		JPanel panelThree = new JPanel();
		panelThree.setBackground(new Color(148, 0, 211));
		botPanel.add(panelThree, "name_421309573581612");
		
		JLabel lblPanelThree = new JLabel("Panel Three!");
		panelThree.add(lblPanelThree);
		
		JButton btnOne = new JButton("One");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// The code that will run when btnOne is clicked.
				panelOne.setVisible(true);
				panelTwo.setVisible(false);
				panelThree.setVisible(false);
			}
		});
		topPanel.add(btnOne);
		
		JButton btnTwo = new JButton("Two");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// The code that will run when btnTwo is clicked.
				panelOne.setVisible(false);
				panelTwo.setVisible(true);
				panelThree.setVisible(false);
			}
		});
		topPanel.add(btnTwo);
		
		JButton btnThree = new JButton("Three");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// The code that will run when btnThree is clicked.
				panelOne.setVisible(false);
				panelTwo.setVisible(false);
				panelThree.setVisible(true);
			}
		});
		topPanel.add(btnThree);
	}
}
