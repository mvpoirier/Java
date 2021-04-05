import java.awt.BorderLayout; // Eclpise IDE Window Builder imports for JFrame Designer
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

import java.util.Random; // Random numbers



public class GuessNumber extends JFrame {

	private JPanel contentPane;
	private JTextField txtChoice;
	
	public Random rN = new Random();
	public int randNum = rN.nextInt(10) + 1;
	public int numGuess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessNumber frame = new GuessNumber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuessNumber() {
		setResizable(false);
		setTitle("Number Guessing GUI");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAction = new JLabel("Guess a Number (1 - 10)");
		lblAction.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAction, BorderLayout.NORTH);
		
		JLabel lblResult = new JLabel("Waiting for response...");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblResult, BorderLayout.SOUTH);
		
		txtChoice = new JTextField();
		txtChoice.setText("#");
		txtChoice.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		txtChoice.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(txtChoice, BorderLayout.EAST);
		txtChoice.setColumns(2);
		
		JButton btnGuess = new JButton("Guess & Click!");
		
		/* REMOVED MOUSELISTENER
		 * STACKOVERFLOW: https://stackoverflow.com/questions/15850808/java-mouselistener-not-always-working
		 */
		
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// THIS CODE RUNS WHEN BUTTON IS CLICKED.
				numGuess = Integer.parseInt(txtChoice.getText());
				
				if (randNum == numGuess) {
					lblResult.setText("The number was " + randNum + ", congrats! Play again?");
					randNum = rN.nextInt(10) + 1;
				}
				else if (randNum > numGuess){
					lblResult.setText("The number " + numGuess + " is too low, try again.");
				}
				else
				{
					lblResult.setText("The number " + numGuess + " is too high, try again.");
				}
			}
		});
		btnGuess.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnGuess, BorderLayout.CENTER);
	}
}
