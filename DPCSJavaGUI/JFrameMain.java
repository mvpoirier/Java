/*
 * NAME:	Mr. Poirier
 * DATE:	March 12, 2021
 * PURPOSE:	An example of how to implement a program that uses multiple user-defined JFrames.
 * 			JFrameMain.java - Driver Class and Primary JFrame (Swing Designer > Application Window)
 * 			JFrameTwo.java - Secondary JFrame (Swing Designer > JFrame)
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameMain {

	private JFrame frame;
	private JFrameTwo frame2; //ADDED
	private int count = 0; //ADDED

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain window = new JFrameMain();
					window.frame.setVisible(true);
					//window.frame2.setVisible(true); //ADDED
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JFrameMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JFrameMain");
		frame.getContentPane().setLayout(null);
		
		frame2 = new JFrameTwo(); //ADDED
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //ADDED
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 450, 278);
		MainPanel.setBackground(new Color(218, 165, 32));
		frame.getContentPane().add(MainPanel);
		MainPanel.setLayout(null);
		
		JButton btnShowFrame2 = new JButton("Show JFrame 2");
		btnShowFrame2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnShowFrame2.setBounds(137, 115, 188, 41);
		MainPanel.add(btnShowFrame2);
		
		JLabel lblFrameMain;
		lblFrameMain = new JLabel("Waiting..");
		lblFrameMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrameMain.setBounds(137, 202, 188, 16);
		MainPanel.add(lblFrameMain);
		
		// Adds counter and uses getter method (Right Click > Expose...) to increase label from other JFrame
		btnShowFrame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!frame2.isVisible()) {
					frame2.setVisible(true);
					count++;
					frame2.getLblCounter().setText(Integer.toString(count));
					frame.toFront(); // restore focus to JFrameMain
				}
			}
		});
		
		// Listens and provides an error message if user clicks on a disabled button.
		btnShowFrame2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!btnShowFrame2.isEnabled())
					JOptionPane.showMessageDialog(lblFrameMain, "ERROR: Need to close JFrameTwo first!");
			}
		});
		
		/*
		 * Use Component Listeners on the JFrame to provide actions when the window is visible or hidden.
		 * https://stackoverflow.com/questions/22713093/how-to-listen-for-visible-property-of-window-in-swing-awt
		 */
		
		frame2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				lblFrameMain.setText("It's hidden! " + count);
				btnShowFrame2.setEnabled(true);
			}
		});
		
		frame2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				lblFrameMain.setText("It's alive! " + count);
				btnShowFrame2.setEnabled(false);
			}
		});
	}
}
