/*
 * NAME:	Mr. Poirier
 * DATE:	2021-03-04
 * PURPOSE:	Using JFrames, JPanels, and CardLayout to switch between views.
 * 			A simple way to develop complex multiscreen GUI interfaces in Java.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyJPanelApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyJPanelApp window = new MyJPanelApp();
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
	public MyJPanelApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel main = new JPanel(); // Main JPanel that is in Card Layout
		frame.getContentPane().add(main);
		main.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(102, 255, 102));
		main.add(panel1, "panel1");
		panel1.setLayout(null);
		panel1.setVisible(true);
		
		JButton btnSwitch2 = new JButton("Switch to Panel 2");
		btnSwitch2.setBounds(132, 128, 177, 29);
		panel1.add(btnSwitch2);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 0));
		main.add(panel2, "panel2");
		panel2.setLayout(null);
		
		JButton btnSwitch1 = new JButton("Switch to Panel 1");
		btnSwitch1.setBounds(132, 128, 177, 29);
		panel2.add(btnSwitch1);
		
		btnSwitch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
			}
		});
		
		btnSwitch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(true);
				panel2.setVisible(false);
			}
		});
	}
}
