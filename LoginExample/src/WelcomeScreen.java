/**
 * FILE:	LoginExample/WelcomeScreen.java
 * PURPOSE:	Welcome screen that will display the user from the MainGUI
 *
 * @author 	github.com/mvpoirier
 * @since 	2019-11-18
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * CLASS:	WelcomeScreen	
 * PURPOSE:	JFrame (no main method), using WindowBuilder
 */
public class WelcomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Constructor: Called when JFrame is initialized
	 * @param parentFrame - the MainGUI parent frame
	 * @param user - the user name entered 
	 */
	public WelcomeScreen(JFrame parentFrame, String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Welcome Screen");
		
		JLabel lblWelcome = new JLabel("Welcome:");
		lblWelcome.setBounds(178, 105, 82, 16);
		contentPane.add(lblWelcome);
		
		JLabel lblUser = new JLabel(user);
		lblUser.setBounds(123, 133, 164, 16);
		contentPane.add(lblUser);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(6, 243, 117, 29);
		contentPane.add(btnGoBack);
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //hide current frame (WelcomeScreen)
				parentFrame.setVisible(true); //show parent frame (MainGUI)
			}
		});
	}

}
