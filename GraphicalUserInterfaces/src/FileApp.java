/**
 * FILE:	GraphicalUserInterfaces/FileApp.java
 * PURPOSE:	File > New > Other... > Window Builder > Swing Designer > Application Window
 *
 * @author 	github.com/mvpoirier
 * @since 	2019-11-15
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * CLASS:	FileApp	
 * PURPOSE:	
 */
public class FileApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileApp window = new FileApp();
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
	public FileApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblMyFileApplication = new JLabel("My File Application");
		frame.getContentPane().add(lblMyFileApplication);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FileChooser fileWindow = new FileChooser(); //creates file chooser JFrame
				fileWindow.setVisible(true);
			}
		});
		frame.getContentPane().add(btnOpenFile);
	}

}
