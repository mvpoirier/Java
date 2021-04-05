/*
 * NAME:	Mr. Poirier
 * DATE:	March 24, 2021
 * PURPOSE: GUI Tutorial Video with WindowBuilder and Eclipse.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class JPanelCardLayout {

	private JFrame frmExampleGuiTutorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanelCardLayout window = new JPanelCardLayout();
					window.frmExampleGuiTutorial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JPanelCardLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExampleGuiTutorial = new JFrame();
		frmExampleGuiTutorial.setTitle("Example GUI Tutorial #1");
		frmExampleGuiTutorial.setBounds(300, 300, 600, 400);
		frmExampleGuiTutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExampleGuiTutorial.getContentPane().setLayout(null);
		
		// COMPONENTS
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 228, 196));
		topPanel.setBounds(0, 0, 600, 39);
		frmExampleGuiTutorial.getContentPane().add(topPanel);
		
		JButton btn1 = new JButton("1");
		topPanel.add(btn1);
		
		JButton btn2 = new JButton("2");
		topPanel.add(btn2);
		
		JButton btn3 = new JButton("3");
		topPanel.add(btn3);
		
		JPanel botPanel = new JPanel();
		botPanel.setBounds(0, 37, 600, 335);
		frmExampleGuiTutorial.getContentPane().add(botPanel);
		botPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(50, 205, 50));
		botPanel.add(panel1, "name_422888327354509");
		
		JLabel lbl1 = new JLabel("Panel One!");
		panel1.add(lbl1);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 215, 0));
		botPanel.add(panel2, "name_422893858443411");
		
		JLabel lbl2 = new JLabel("Panel Two!");
		panel2.add(lbl2);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(30, 144, 255));
		botPanel.add(panel3, "name_422897312448596");
		
		JLabel lbl3 = new JLabel("Panel Three!");
		lbl3.setForeground(new Color(255, 255, 255));
		lbl3.setFont(new Font("Dialog", Font.BOLD, 29));
		panel3.add(lbl3);
		
		// ACTIONS
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
			}
		});
	}

}
