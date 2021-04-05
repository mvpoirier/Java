/*
 * NAME:	Mr. Poirier
 * DATE:	March 12, 2021
 * PURPOSE:	An example of how to implement a program that uses multiple user-defined JFrames.
 * 			JFrameMain.java - Driver Class and Primary JFrame (Swing Designer > Application Window)
 * 			JFrameTwo.java - Secondary JFrame (Swing Designer > JFrame)
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JFrameTwo extends JFrame {

	private JPanel contentPane;
	private JLabel lblCounter; // Exposed component to be changed by JFrameMain
	
	// *** REMOVED public static void main()... method for second JFrame! ***

	
	/**
	 * Create the frame.
	 */
	public JFrameTwo() {
		setTitle("JFrameTwo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(5, 5, 440, 268);
		MainPanel.setBackground(new Color(64, 224, 208));
		contentPane.add(MainPanel);
		MainPanel.setLayout(null);
		
		lblCounter = new JLabel("1");
		lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounter.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblCounter.setBounds(6, 110, 428, 48);
		MainPanel.add(lblCounter);
		
		JLabel lblCloseMe = new JLabel("(Please close this window, again...)");
		lblCloseMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseMe.setBounds(6, 197, 428, 16);
		MainPanel.add(lblCloseMe);
	}
	
	// Public 'getter' method needed to communicate with JFrameMain
	// Design Mode > Right-Click Component > Expose Component...
	public JLabel getLblCounter() { 
		return lblCounter;
	}
}
