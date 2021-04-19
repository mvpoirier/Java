/*
 * NAME:	Mr. Poirier
 * DATE:	March 23, 2021
 * PURPOSE: Tutorial on how to use GUIs, File IO, and Try/Catch Exceptions 
 * 			in order to read/write to a CSV file efficiently.
 */

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

public class AddressBookPART1 {

	private JFrame frmAddressBookTutorial;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBookPART1 window = new AddressBookPART1();
					window.frmAddressBookTutorial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddressBookPART1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddressBookTutorial = new JFrame();
		frmAddressBookTutorial.setTitle("Address Book Tutorial");
		frmAddressBookTutorial.setBounds(100, 100, 586, 364);
		frmAddressBookTutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddressBookTutorial.getContentPane().setLayout(null);
		
		JPanel top = new JPanel();
		FlowLayout fl_top = (FlowLayout) top.getLayout();
		fl_top.setVgap(3);
		fl_top.setAlignOnBaseline(true);
		top.setBorder(new LineBorder(new Color(0, 0, 0)));
		top.setBackground(new Color(47, 79, 79));
		top.setBounds(6, 6, 574, 26);
		frmAddressBookTutorial.getContentPane().add(top);
		
		/*
		 * GUI COMPONENTS ADDED TO JFRAME
		 */
		
		JLabel lblTitle = new JLabel("Mr. Poirier's AWESOME Address Book!");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		JPanel side = new JPanel();
		side.setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) side.getLayout();
		flowLayout.setVgap(20);
		side.setBackground(new Color(173, 216, 230));
		side.setBounds(6, 37, 135, 299);
		frmAddressBookTutorial.getContentPane().add(side);
		
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
		frmAddressBookTutorial.getContentPane().add(main);
		main.setLayout(new CardLayout(0, 0));
		
		/*
		 * VIEW JPANEL
		 */
		
		JPanel view = new JPanel();
		view.setBackground(new Color(255, 218, 185));
		main.add(view, "name_14353414839215");
		view.setLayout(null);
		
		JList<String> viewList = new JList<String>();
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
		btnViewNext.setBounds(234, 263, 75, 29);
		view.add(btnViewNext);
		
		JButton btnViewPrev = new JButton("Prev");
		btnViewPrev.setBounds(164, 263, 75, 29);
		view.add(btnViewPrev);
		
		JButton btnSort = new JButton("Sort...");
		btnSort.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		btnSort.setBounds(28, 263, 93, 29);
		view.add(btnSort);
		
		JButton btnViewDelete = new JButton("Delete");
		btnViewDelete.setForeground(Color.RED);
		btnViewDelete.setBounds(359, 263, 68, 29);
		view.add(btnViewDelete);
		
		/*
		 * ADD JPANEL
		 */
		
		JPanel add = new JPanel();
		add.setBackground(new Color(216, 191, 216));
		main.add(add, "name_14321049469960");
		add.setLayout(null);
		
		JPanel addEntryPanel = new JPanel();
		addEntryPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Add Contact", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addEntryPanel.setBounds(10, 10, 320, 275);
		add.add(addEntryPanel);
		addEntryPanel.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblAdd1 = new JLabel("First Name: ");
		lblAdd1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntryPanel.add(lblAdd1);
				
		JTextField txtFirst;
		txtFirst = new JTextField();
		addEntryPanel.add(txtFirst);
		txtFirst.setColumns(10);
		
		JLabel lblAdd2 = new JLabel("Last Name: ");
		lblAdd2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntryPanel.add(lblAdd2);

		JTextField txtLast;
		txtLast = new JTextField();
		addEntryPanel.add(txtLast);
		txtLast.setColumns(10);
		
		JLabel lblAdd3 = new JLabel("Age: ");
		lblAdd3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntryPanel.add(lblAdd3);
		
		JTextField txtAge;
		txtAge = new JTextField();
		addEntryPanel.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblAdd4 = new JLabel("Country: ");
		lblAdd4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntryPanel.add(lblAdd4);

		JTextField txtCountry;
		txtCountry = new JTextField();
		addEntryPanel.add(txtCountry);
		txtCountry.setColumns(10);
		
		JLabel lblAdd5 = new JLabel("Phone: ");
		lblAdd5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntryPanel.add(lblAdd5);
		
		JTextField txtPhone;
		txtPhone = new JTextField();
		addEntryPanel.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblAdd6 = new JLabel("Email: ");
		lblAdd6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdd6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addEntryPanel.add(lblAdd6);
		
		JTextField txtEmail;
		txtEmail = new JTextField();
		addEntryPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAddContact = new JButton("Add");
		btnAddContact.setForeground(new Color(0, 128, 0));
		btnAddContact.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnAddContact.setBounds(342, 256, 85, 29);
		add.add(btnAddContact);
				
		/*
		 * ACTION LISENTERS
		 */
		
		btnMenuView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SHOW VIEW JPANEL
				view.setVisible(true);
				add.setVisible(false);
				btnMenuView.setEnabled(false);
				btnMenuAdd.setEnabled(true);
			}
		});
		
		btnMenuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SHOW ADD JPANEL
				view.setVisible(false);
				add.setVisible(true);
				btnMenuView.setEnabled(true);
				btnMenuAdd.setEnabled(false);
			}
		});
		
		btnMenuLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// LOAD/OPEN FILE...
			}
		});
		
		btnMenuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SAVE FILE...
			}
		});
		
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VIEW > SORT CONTACTS...
			}
		});
		
		btnViewNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VIEW > NEXT CONTACT in LIST...
			}
		});
		
		btnViewPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VIEW > PREVIOUS CONTACT in LIST...
			}
		});
		
		btnViewDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VIEW > DELETE SELECTED CONTACT...
			}
		});
		
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ADD > ADD CONTACT
			}
		});
		
	}
}
