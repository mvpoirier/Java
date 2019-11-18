/**
 * FILE:	LoginExample/MainGUI.java
 * PURPOSE:	Example of how to create a login window, and go to the next JFrame.
 *
 * @author 	github.com/mvpoirier
 * @since 	2019-11-18
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * CLASS:	MainGUI	
 * PURPOSE:	Application Window (main method), using WindowBuilder
 */
public class MainGUI {

	private JFrame frame;
	private JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); //the frame of THIS window
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("MainGUI - Login Screen");
		
		txtUser = new JTextField();
		txtUser.setBounds(156, 122, 130, 26);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblEnterUsername = new JLabel("Enter username:");
		lblEnterUsername.setBounds(168, 85, 118, 16);
		frame.getContentPane().add(lblEnterUsername);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(166, 160, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		/*
		 * WHEN I CLICK THE LOGIN BUTTON
		 */
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create frame2, pass pointer of THIS frame, and user name
				WelcomeScreen frame2 = new WelcomeScreen(frame, txtUser.getText());
				frame2.setVisible(true); //show WelcomeScreen
				frame.setVisible(false); //hide MainGUI
				//frame.dispose(); //only use if you want to reset all components?
			}
		});
	}
}
