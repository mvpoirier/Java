import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * FILE:	GraphicalUserInterfaces/FileAppForm2.java
 * PURPOSE:	Shows how 'child' JFrames can communicate with the parent JFrame
 *
 * @author 	github.com/mvpoirier
 * @since 	2019-11-16
 */

public class FileAppForm2 extends JFrame {

	private JFrame parentFrame;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public FileAppForm2(JFrame frameB) {
		this.parentFrame = frameB; //reference to parent frame that called this frame
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		JButton btnChangeFileappLabel = new JButton("Change FileApp Title");
		btnChangeFileappLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentFrame.setTitle(textField.getText());
				parentFrame.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnChangeFileappLabel, BorderLayout.CENTER);
		setTitle("FileAppForm2");
	}
}
