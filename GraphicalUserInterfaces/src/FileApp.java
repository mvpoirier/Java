/**
 * FILE:	GraphicalUserInterfaces/FileApp.java
 * PURPOSE:	File > New > Other... > Window Builder > Swing Designer > Application Window
 * 			How to open multiple JFrames: https://www.youtube.com/watch?v=xh6n4bIZEpQ
 * 			How to open/save with JFileChooser: https://stackoverflow.com/questions/3548140/how-to-open-and-save-using-java
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

import javax.swing.JFileChooser;
import java.io.File;


public class FileApp {

	private JFrame frame;
	private int netWorth;

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
		frame.setTitle("FileApp");
		
		JLabel lblMyFileApplication = new JLabel("FileApp: GUIs and FILE I/O");
		frame.getContentPane().add(lblMyFileApplication);
		
		JButton btnOpenFile = new JButton("JFileChooser: OPEN & SAVE");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OPEN FILE
				JFileChooser fileChooser1 = new JFileChooser();
				if (fileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser1.getSelectedFile();
				  System.out.println("OPEN: " + file.getPath());
				}
				
				// SAVE FILE
				JFileChooser fileChooser2 = new JFileChooser();
				if (fileChooser2.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser2.getSelectedFile();
				  System.out.println("SAVE: " + file.getPath());
				}
			}
		});
		
		JButton btnNewForm = new JButton("New JFrame: FileAppForm2");
		btnNewForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileAppForm2 frame2 = new FileAppForm2(frame); //pass reference to this.frame to frame2
				frame2.setVisible(true); //show frame 2
				frame.dispose(); //hide current frame
			}
		});
		frame.getContentPane().add(btnNewForm);
		frame.getContentPane().add(btnOpenFile);
	}
}
