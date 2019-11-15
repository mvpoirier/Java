/**
 * FILE:	GraphicalUserInterfaces/FileChooserWindowBuilder.java
 * PURPOSE:	Demonstrate using FileChooser within WindowBuilder on Eclipse.
 * SOURCE:	https://stackoverflow.com/questions/24202474/add-jfilechooser-to-eclipse-window-builder
 * 			How to open multiple JFrames: https://www.youtube.com/watch?v=xh6n4bIZEpQ
 *
 * @author 	github.com/mvpoirier
 * @since 	2019-11-15
 */

/*
 * https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
 * https://stackoverflow.com/questions/3548140/how-to-open-and-save-using-java
 * https://stackoverflow.com/questions/24202474/add-jfilechooser-to-eclipse-window-builder
 * https://www.eclipse.org/windowbuilder/
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

public class FileChooser extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FileChooser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JFileChooser fileChooser = new JFileChooser();
		contentPane.add(fileChooser, BorderLayout.CENTER);
	}

}
