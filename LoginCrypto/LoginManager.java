import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class LoginManager {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginManager window = new LoginManager();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginManager() {
		initialize();
		
		// Hide manager, initialize and display login screen.
		frame.setVisible(false);
		LoginStart start = new LoginStart(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login Manager");
	}
}
