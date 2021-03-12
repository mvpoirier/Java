/*
 * NAME:	Mr. Poirier
 * DATE:	March 12, 2021
 * PUPROSE:	An example of how to create a Top Menu GUI with JPanels.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TopMenuGUI {

	private JFrame frmJpanelSwitcher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopMenuGUI window = new TopMenuGUI();
					window.frmJpanelSwitcher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TopMenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJpanelSwitcher = new JFrame();
		frmJpanelSwitcher.setTitle("JPanel Switcher");
		frmJpanelSwitcher.getContentPane().setBackground(Color.WHITE);
		frmJpanelSwitcher.getContentPane().setLayout(null);
		
		/*
		 * ADD CONTENTS
		 */
		JPanel panelTop = new JPanel();
		panelTop.setBackground(SystemColor.scrollbar);
		panelTop.setBounds(0, 0, 449, 39);
		frmJpanelSwitcher.getContentPane().add(panelTop);
		
		JButton btnPanel1 = new JButton("JPanel 1");
		panelTop.add(btnPanel1);
		btnPanel1.setEnabled(false);
	
		JButton btnPanel2 = new JButton("JPanel 2");
		panelTop.add(btnPanel2);
		btnPanel2.setEnabled(true);
		
		JButton btnPanel3 = new JButton("JPanel 3");
		panelTop.add(btnPanel3);
		btnPanel3.setEnabled(true);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(new Color(204, 204, 255));
		panelBottom.setBounds(0, 39, 450, 240);
		frmJpanelSwitcher.getContentPane().add(panelBottom);
		panelBottom.setLayout(new CardLayout(0, 0));
		
		JPanel panelOne = new JPanel();
		panelOne.setBackground(new Color(153, 204, 0));
		panelBottom.add(panelOne, "name_164445894221408");
		panelOne.setLayout(null);
		
		JLabel lblPanel1 = new JLabel("JPanel 1");
		lblPanel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel1.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblPanel1.setBounds(0, 0, 450, 240);
		panelOne.add(lblPanel1);
		
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(new Color(255, 204, 0));
		panelBottom.add(panelTwo, "name_164495310504530");
		panelTwo.setLayout(new CardLayout(0, 0));
		
		JLabel lblPanel2 = new JLabel("JPanel 2");
		panelTwo.add(lblPanel2, "name_165629012785257");
		lblPanel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel2.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JPanel panelThree = new JPanel();
		panelThree.setBackground(new Color(153, 204, 255));
		panelBottom.add(panelThree, "name_164513744678334");
		panelThree.setLayout(new CardLayout(0, 0));
		
		JLabel lblPanel3 = new JLabel("JPanel 3");
		panelThree.add(lblPanel3, "name_165716939047155");
		lblPanel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel3.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		frmJpanelSwitcher.setBackground(Color.WHITE);
		frmJpanelSwitcher.setBounds(100, 100, 450, 300);
		frmJpanelSwitcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * INITIAL SETUP
		 */
		panelOne.setVisible(true);
		panelTwo.setVisible(false);
		panelThree.setVisible(false);
		
		btnPanel1.setEnabled(false);
		btnPanel2.setEnabled(true);
		btnPanel3.setEnabled(true);
		
		/*
		 * ACTIONS PERFORMED (BUTTONS)
		 */
		
		btnPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOne.setVisible(true);
				panelTwo.setVisible(false);
				panelThree.setVisible(false);
				
				btnPanel1.setEnabled(false);
				btnPanel2.setEnabled(true);
				btnPanel3.setEnabled(true);
				
				// Providing the parent JFrame will center message on that frame.
				JOptionPane.showMessageDialog(frmJpanelSwitcher, "Switching to Panel 1!");
			}
		});
		
		btnPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOne.setVisible(false);
				panelTwo.setVisible(true);
				panelThree.setVisible(false);
				
				btnPanel1.setEnabled(true);
				btnPanel2.setEnabled(false);
				btnPanel3.setEnabled(true);
				
				// Providing 'null' will center the message in the middle of the screen.
				JOptionPane.showMessageDialog(null, "Switching to Panel 2!");
			}
		});
		
		btnPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOne.setVisible(false);
				panelTwo.setVisible(false);
				panelThree.setVisible(true);
				
				btnPanel1.setEnabled(true);
				btnPanel2.setEnabled(true);
				btnPanel3.setEnabled(false);
				
				JOptionPane.showMessageDialog(null, "Switching to Panel 3!");
			}
		});
	}
}
