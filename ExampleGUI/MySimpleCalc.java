/*
 * NAME:	Mr. Poirier
 * DATE:	2021-03-04
 * PURPOSE:	An example of creating a multiple JPanel Calculator GUI with CardLayout.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MySimpleCalc {

	private JFrame frame;
	private JTextField txtAddNum1;
	private JTextField txtAddNum2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySimpleCalc window = new MySimpleCalc();
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
	public MySimpleCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//MAIN JFRAME & JPANEL (with CardLayout)
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel main = new JPanel();
		frame.getContentPane().add(main);
		main.setLayout(new CardLayout(0, 0)); // CardLayout
		
		
		// START JPANEL & COMPONENTS (e.g. Labels, Buttons, TextFields)	
		JPanel start = new JPanel();
		start.setBackground(new Color(0, 255, 127));
		main.add(start, "start");
		start.setLayout(null);
		
		JButton btnStartAdd = new JButton("Addition or Subtraction");
		btnStartAdd.setBounds(123, 83, 182, 29);
		start.add(btnStartAdd);
		
		JLabel lblStartTitle = new JLabel("My Calculator!");
		lblStartTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartTitle.setBounds(101, 35, 223, 36);
		start.add(lblStartTitle);
		lblStartTitle.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		
		JButton btnStartMult = new JButton("Multiply or Divide");
		btnStartMult.setEnabled(false);
		btnStartMult.setBounds(123, 124, 182, 29);
		start.add(btnStartMult);
		
		JButton btnStartTrig = new JButton("Trigonometry");
		btnStartTrig.setEnabled(false);
		btnStartTrig.setBounds(123, 165, 182, 29);
		start.add(btnStartTrig);
		
		JLabel lblStartBottom = new JLabel("DP Computer Science: JPanel with CardLayout GUI Example");
		lblStartBottom.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartBottom.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		lblStartBottom.setBounds(6, 256, 438, 16);
		start.add(lblStartBottom);
		
		
		// ADDITION JPANEL & COMPONENTS
		JPanel addition = new JPanel();
		addition.setBackground(new Color(204, 255, 255));
		main.add(addition, "addition");
		addition.setLayout(null);
		
		JLabel lblAddTitle = new JLabel("My Calculator > Addition / Subtraction");
		lblAddTitle.setBounds(88, 6, 277, 16);
		addition.add(lblAddTitle);
		
		JButton btnAddBack = new JButton("Go Back");
		btnAddBack.setBounds(6, 243, 75, 29);
		addition.add(btnAddBack);
		
		txtAddNum1 = new JTextField();
		txtAddNum1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddNum1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtAddNum1.setText("");
		txtAddNum1.setBounds(73, 64, 117, 41);
		addition.add(txtAddNum1);
		txtAddNum1.setColumns(10);
		
		txtAddNum2 = new JTextField();
		txtAddNum2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddNum2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtAddNum2.setText("");
		txtAddNum2.setBounds(235, 64, 117, 41);
		addition.add(txtAddNum2);
		txtAddNum2.setColumns(10);
		
		JButton btnAddNum = new JButton("Add!");
		btnAddNum.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddNum.setBounds(152, 184, 117, 29);
		addition.add(btnAddNum);
		
		JLabel lblAddSum = new JLabel("");
		lblAddSum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddSum.setBackground(new Color(255, 255, 255));
		lblAddSum.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblAddSum.setBounds(73, 117, 282, 55);
		addition.add(lblAddSum);
		
		
		// ACTIONS (e.g. ActionListener for button clicks) 
		
		btnStartAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				addition.setVisible(true);
				txtAddNum1.setText("");
				txtAddNum2.setText("");
				lblAddSum.setText("");
			}
		});
		
		btnAddNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num1 = Integer.parseInt(txtAddNum1.getText());
					int num2 = Integer.parseInt(txtAddNum2.getText());
					int sum = num1 + num2;
					lblAddSum.setText(num1 + " + " + num2 + " = " + Integer.toString(sum));
				}
				catch (Exception ex) {
					lblAddSum.setText("Error!");
					JOptionPane.showMessageDialog(frame, "Invalid input provided.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnAddBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddBack.getParent().setVisible(false); //.getParent() == main JPanel (OOP Inheritance)
				start.setVisible(true);
			}
		});
	}
}
