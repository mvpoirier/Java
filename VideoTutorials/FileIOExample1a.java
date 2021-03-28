/*
 * NAME:	Mr. Poirier
 * DATE:	March 23, 2021
 * PURPOSE: Tutorial on how to use GUIs, File IO, and Try/Catch Exceptions 
 * 			in order to read/write to a CSV file efficiently.
 */

// FILE I/O & Exceptions
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;

// JFILECHOOSER
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

// LINKED LIST
import java.util.LinkedList;

// WINDOW BUILDER DESIGN MODE
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class FileIOExample1a {

	private JFrame frame;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtAge;
	private JTextField txtCountry;
	private JTextField txtPhone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileIOExample1a window = new FileIOExample1a();
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
	public FileIOExample1a() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel top = new JPanel();
		FlowLayout fl_top = (FlowLayout) top.getLayout();
		fl_top.setVgap(3);
		fl_top.setAlignOnBaseline(true);
		top.setBorder(new LineBorder(new Color(0, 0, 0)));
		top.setBackground(new Color(47, 79, 79));
		top.setBounds(6, 6, 574, 26);
		frame.getContentPane().add(top);
		
		JLabel lblTitle = new JLabel("Mr. Poirier's AWESOME Address Book!");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		JPanel side = new JPanel();
		side.setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) side.getLayout();
		flowLayout.setVgap(20);
		side.setBackground(new Color(173, 216, 230));
		side.setBounds(6, 37, 135, 299);
		frame.getContentPane().add(side);
		
		JButton btnMenuView = new JButton("View");
		side.add(btnMenuView);
		btnMenuView.setEnabled(false); // default setting
		
		JButton btnMenuAdd = new JButton("Add");
		side.add(btnMenuAdd);
		
		JButton btnMenuLoad = new JButton("Load");
		side.add(btnMenuLoad);
		
		JButton btnMenuSave = new JButton("Save");
		side.add(btnMenuSave);
		
		JLabel lblMenuEntries = new JLabel("Total Entries:");
		lblMenuEntries.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		side.add(lblMenuEntries);
		
		JLabel lblMenuNum = new JLabel("0");
		side.add(lblMenuNum);
		top.add(lblTitle);
		
		JPanel main = new JPanel();
		main.setBorder(new LineBorder(new Color(0, 0, 0)));
		main.setBounds(145, 37, 435, 299);
		frame.getContentPane().add(main);
		main.setLayout(new CardLayout(0, 0));
		
		JPanel view = new JPanel();
		view.setBackground(new Color(255, 218, 185));
		main.add(view, "name_14353414839215");
		view.setLayout(null);
		
		JList viewList = new JList();
		viewList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		viewList.setBounds(6, 18, 136, 233);
		view.add(viewList);
		
		JPanel viewEntry = new JPanel();
		viewEntry.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "View Contact", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		viewEntry.setBounds(154, 18, 273, 233);
		view.add(viewEntry);
		viewEntry.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblView1 = new JLabel("First Name: ");
		lblView1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView1.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView1);
		
		JLabel lblFirst = new JLabel("N/A");
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		viewEntry.add(lblFirst);
		
		JLabel lblView2 = new JLabel("Last Name: ");
		lblView2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView2.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView2);
		
		JLabel lblLast = new JLabel("N/A");
		lblLast.setHorizontalAlignment(SwingConstants.CENTER);
		lblLast.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		viewEntry.add(lblLast);
		
		JLabel lblView3 = new JLabel("Age: ");
		lblView3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView3.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView3);
		
		JLabel lblAge = new JLabel("N/A");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		viewEntry.add(lblAge);
		
		JLabel lblView4 = new JLabel("Country: ");
		lblView4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView4.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView4);
		
		JLabel lblCountry = new JLabel("N/A");
		lblCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		viewEntry.add(lblCountry);
		
		JLabel lblView5 = new JLabel("Phone: ");
		lblView5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView5.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView5);
		
		JLabel lblPhone = new JLabel("N/A");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		viewEntry.add(lblPhone);
		
		JLabel lblView6 = new JLabel("Email: ");
		lblView6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView6.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView6);
		
		JLabel lblEmail = new JLabel("N/A");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		viewEntry.add(lblEmail);
		
		JButton btnViewNext = new JButton("Next");
		btnViewNext.setBounds(294, 263, 75, 29);
		view.add(btnViewNext);
		
		JButton btnViewPrev = new JButton("Prev");
		btnViewPrev.setBounds(207, 263, 75, 29);
		view.add(btnViewPrev);
		
		JButton btnSort = new JButton("Sort...");
		btnSort.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		btnSort.setBounds(28, 263, 93, 29);
		view.add(btnSort);
		
		JPanel add = new JPanel();
		add.setBackground(new Color(216, 191, 216));
		main.add(add, "name_14321049469960");
		add.setLayout(null);
		
		JPanel addEntry = new JPanel();
		addEntry.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Add Contact", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addEntry.setBounds(10, 10, 320, 275);
		add.add(addEntry);
		addEntry.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblAdd1 = new JLabel("First Name: ");
		lblAdd1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntry.add(lblAdd1);
		
		txtFirst = new JTextField();
		addEntry.add(txtFirst);
		txtFirst.setColumns(10);
		
		JLabel lblAdd2 = new JLabel("Last Name: ");
		lblAdd2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntry.add(lblAdd2);
		
		txtLast = new JTextField();
		addEntry.add(txtLast);
		txtLast.setColumns(10);
		
		JLabel lblAdd3 = new JLabel("Age: ");
		lblAdd3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntry.add(lblAdd3);
		
		txtAge = new JTextField();
		addEntry.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblAdd4 = new JLabel("Country: ");
		lblAdd4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntry.add(lblAdd4);
		
		txtCountry = new JTextField();
		addEntry.add(txtCountry);
		txtCountry.setColumns(10);
		
		JLabel lblAdd5 = new JLabel("Phone: ");
		lblAdd5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntry.add(lblAdd5);
		
		txtPhone = new JTextField();
		addEntry.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblAdd6 = new JLabel("Email: ");
		lblAdd6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntry.add(lblAdd6);
		
		txtEmail = new JTextField();
		addEntry.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(342, 248, 85, 37);
		add.add(btnNewButton);
				
		// ACTIONS
		btnMenuView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setVisible(true);
				add.setVisible(false);
				btnMenuView.setEnabled(false);
				btnMenuAdd.setEnabled(true);
			}
		});
		
		btnMenuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setVisible(false);
				add.setVisible(true);
				btnMenuView.setEnabled(true);
				btnMenuAdd.setEnabled(false);
			}
		});
		
		btnMenuLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// LOAD FILE
			}
		});
		
		btnMenuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SAVE FILE
			}
		});
	}
}
