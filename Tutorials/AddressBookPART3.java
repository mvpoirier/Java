/*
 * NAME:	Mr. Poirier
 * DATE:	April 22, 2021
 * PURPOSE: Tutorial on how to use GUIs, File IO, and Try/Catch Exceptions 
 * 			in order to read/write to a CSV file efficiently.
 * 
 * 			PART 3 - Load contacts, display in a JList, select contacts, and sort by age and name.
 */


// Organize Required Imports in Eclipse: Source -> Organize Imports (Command + Shift + O)

// Correct Indentation: Source -> Correct Indentation (Command + I)

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon; // Add custom dialog icon
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class AddressBookPART3 {

	private JFrame frmAddressBookTutorial;
	private LinkedList<Address> contactList = new LinkedList<Address>();

	/*
	 * SETUP JFileChooser
	 * https://stackoverflow.com/q/21844188/11542212
	 */
    private int returnVal;
	private File workingDirectory = new File(System.getProperty("user.dir")); // Current working directory
	private JFileChooser chooser = new JFileChooser(workingDirectory);
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Contacts (.csv, .txt)", "csv", "txt");
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBookPART3 window = new AddressBookPART3();
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
	public AddressBookPART3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddressBookTutorial = new JFrame();
		frmAddressBookTutorial.setTitle("Address Book Tutorial - PART 3");
		frmAddressBookTutorial.setBounds(100, 100, 615, 364);
		frmAddressBookTutorial.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAddressBookTutorial.getContentPane().setLayout(null);
		
		JPanel top = new JPanel();
		FlowLayout fl_top = (FlowLayout) top.getLayout();
		fl_top.setVgap(3);
		fl_top.setAlignOnBaseline(true);
		top.setBorder(new LineBorder(new Color(0, 0, 0)));
		top.setBackground(new Color(47, 79, 79));
		top.setBounds(6, 6, 603, 26);
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
		main.setBounds(145, 37, 464, 299);
		frmAddressBookTutorial.getContentPane().add(main);
		main.setLayout(new CardLayout(0, 0));
		
		/*
		 * VIEW JPANEL
		 */
		
		JPanel view = new JPanel();
		view.setBackground(new Color(255, 218, 185));
		main.add(view, "view");
		view.setLayout(null);
		
		/*
		 * PART 3: 	Create a JList that will allow you to add/remove items with DefaultListModel,
		 * 			and a JScrollPanel to provide a JList that the user can scroll through.
		 * 			
		 * 			https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
		 * 			https://www.tutorialspoint.com/how-to-add-scrollbar-to-jlist-in-java
		 */
		
	    // Create JList with DeafultListModel
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> viewList = new JList<String>(listModel);
		viewList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		viewList.setBounds(6, 18, 136, 233);
		
		// Create a JScrollPane which will contain the JList
	    JPanel scrollPanel = new JPanel(new BorderLayout());
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(viewList);
	    viewList.setLayoutOrientation(JList.VERTICAL);
	    scrollPanel.add(scrollPane);
	    scrollPanel.setBounds(6, 18, 145, 233);
	    scrollPanel.setVisible(true);
	    view.add(scrollPanel);
		
		JPanel viewEntry = new JPanel();
		viewEntry.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "View Contact", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		viewEntry.setBounds(174, 18, 282, 233);
		view.add(viewEntry);
		viewEntry.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblView1 = new JLabel("First Name: ");
		lblView1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView1.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView1);
		
		JLabel lblFirst = new JLabel("N/A");
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		viewEntry.add(lblFirst);
		
		JLabel lblView2 = new JLabel("Last Name: ");
		lblView2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView2.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView2);
		
		JLabel lblLast = new JLabel("N/A");
		lblLast.setHorizontalAlignment(SwingConstants.CENTER);
		lblLast.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		viewEntry.add(lblLast);
		
		JLabel lblView3 = new JLabel("Age: ");
		lblView3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView3.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView3);
		
		JLabel lblAge = new JLabel("N/A");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		viewEntry.add(lblAge);
		
		JLabel lblView4 = new JLabel("Country: ");
		lblView4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView4.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView4);
		
		JLabel lblCountry = new JLabel("N/A");
		lblCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		viewEntry.add(lblCountry);
		
		JLabel lblView5 = new JLabel("Phone: ");
		lblView5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblView5.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		viewEntry.add(lblView5);
		
		JLabel lblPhone = new JLabel("N/A");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
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
		btnViewNext.setBounds(240, 263, 75, 29);
		view.add(btnViewNext);
		
		JButton btnViewPrev = new JButton("Prev");
		btnViewPrev.setBounds(174, 263, 75, 29);
		view.add(btnViewPrev);
		
		JButton btnSortAge = new JButton("Sort (Age)");
		btnSortAge.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnSortAge.setBounds(77, 249, 75, 29);
		view.add(btnSortAge);
		
		JButton btnViewDelete = new JButton("Delete");
		btnViewDelete.setForeground(Color.RED);
		btnViewDelete.setBounds(388, 263, 68, 29);
		view.add(btnViewDelete);
		
		JButton btnSortName = new JButton("Sort (Name)");
		btnSortName.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnSortName.setBounds(6, 249, 75, 29);
		view.add(btnSortName);
		
		/*
		 * ADD JPANEL
		 */
		
		JPanel add = new JPanel();
		add.setBackground(new Color(216, 191, 216));
		main.add(add, "add");
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
		
		// PART 1: SIDE PANEL > SHOW VIEW JPANEL
		btnMenuView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setVisible(true);
				add.setVisible(false);
				btnMenuView.setEnabled(false);
				btnMenuAdd.setEnabled(true);
			}
		});
		
		// PART 1: SIDE PANEL > SHOW ADD JPANEL
		btnMenuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setVisible(false);
				add.setVisible(true);
				btnMenuView.setEnabled(true);
				btnMenuAdd.setEnabled(false);
			}
		});
		
		// PART 2: WINDOW CLOSING > DOUBLE-CHECK EXIT...
		frmAddressBookTutorial.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object[] options = {"Yep!", "Nope."};
		        ImageIcon icon = new ImageIcon("icon_exit.png");
				int exitCheck = JOptionPane.showOptionDialog(frmAddressBookTutorial, // parent
						"Are you sure you want to exit?\nAny unsaved contacts will be lost!", // message
						"Exit Confirmation", // title
						JOptionPane.YES_NO_OPTION, // option type
						JOptionPane.WARNING_MESSAGE, // type of message
						icon, // custom icon or null (javax.swing.ImageIcon)
						options, // list of options or null
						options[1]); // default button selected or null
				
				if (exitCheck == 0) // If YES (0) is selected...
				{
					System.out.println("*** Program ended successfully. ***");
					System.exit(0);
				}
			}
		});
		
		
		
		/*
		 * PART 3: SIDE PANEL > LOAD FILE... (Complete!)
		 * https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
		 * https://stackoverflow.com/q/2183669/11542212
		 */
		btnMenuLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    chooser.setFileFilter(filter);
				returnVal = chooser.showOpenDialog(frmAddressBookTutorial);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	System.out.println("You chose to open " + 
			    		   chooser.getSelectedFile().getName() + ": " +
			    		   chooser.getSelectedFile().getAbsolutePath());
			    }
			    
			    try {
			    	FileReader fr = new FileReader(chooser.getSelectedFile().getAbsolutePath());
			    	BufferedReader br = new BufferedReader(fr);
			    	String input;
			    	String[] data;
			    	Address selectedContact;
			    	
			    	// Ignore file header & read line
			    	br.readLine(); 
			    	input = br.readLine();
			    	
			    	// Initialize and add each Address object from file
			    	while (input != null) {
			    		data = input.split(",");
			    		contactList.add(new Address(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], data[5]));
			    		input = br.readLine();
			    	}
			    	br.close();
			    	
			    	// JList: Clear & Add Address Objects
				    listModel.clear();
				    for (Address address : contactList)
				    	listModel.addElement(address.getFullName());
				    lblMenuNum.setText(String.valueOf(contactList.size()));
				    
				    // Display first item in list (index = 0)
			    	viewList.setSelectedIndex(0);
				    selectedContact = contactList.get(0);
			    	data = selectedContact.getData();
			    	
			    	lblFirst.setText(data[0]);
			    	lblLast.setText(data[1]);
			    	lblAge.setText(data[2]);
			    	lblCountry.setText(data[3]);
			    	lblPhone.setText(data[4]);
			    	lblEmail.setText(data[5]);
			    	
			    	btnMenuLoad.setEnabled(false);
			    	System.out.println("FILE LOADED SUCCESSFULLY!");
			    }
			    catch (IOException ex1) {
			    	// FILE I/O Exception
			    	JOptionPane.showMessageDialog(null, "Error! Cannot load chosen file.");
			    	System.out.println(ex1);
			    }
			    catch (Exception ex2) {
			    	// GENERAL Exception
			    	JOptionPane.showMessageDialog(null, "Error! Cannot create address objects.");
			    	System.out.println(ex2);
			    }
			}
		});
		
		// PART 2: SIDE PANEL > SAVE FILE... (Incomplete)
		btnMenuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    chooser.setFileFilter(filter);
				returnVal = chooser.showSaveDialog(frmAddressBookTutorial);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       System.out.println("You chose to save " + chooser.getSelectedFile().getName() + ": " +
					            chooser.getSelectedFile().getAbsolutePath()); // Absolute Path & Filename
				    	System.out.println("SAVE IS NOT CODED YET.");
			    }
			}
		});
		
		// PART 3: VIEW > NEXT CONTACT in LIST...
		btnViewNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int index = viewList.getSelectedIndex();
			    
			    // Check to make sure the NEXT index is valid
			    if (index == -1 || index == contactList.size() - 1)
			    	index = 0;
			    else
			    	index = index + 1;
			    
			    // Display NEXT item in list
				viewList.setSelectedIndex(index);
		    	Address selectedContact = contactList.get(index);
		    	String[] data = selectedContact.getData();
		    	
		    	lblFirst.setText(data[0]);
		    	lblLast.setText(data[1]);
		    	lblAge.setText(data[2]);
		    	lblCountry.setText(data[3]);
		    	lblPhone.setText(data[4]);
		    	lblEmail.setText(data[5]);
		    	
		    	// Consider adding JList Auto Scrolling...
		    	// https://stackoverflow.com/questions/2132444/jscrollpane-and-jlist-auto-scroll
			}
		});
		
		// PART 3: VIEW > PREVIOUS CONTACT in LIST...
		btnViewPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int index = viewList.getSelectedIndex();
			    
			    // Check to make sure the PREVIOUS index is valid
			    if (index == -1 || index == 0)
			    	index = contactList.size() - 1;
			    else
			    	index = index - 1;
			    
			    // Display PREVIOUS item in list
				viewList.setSelectedIndex(index);
		    	Address selectedContact = contactList.get(index);
		    	String[] data = selectedContact.getData();
		    	
		    	lblFirst.setText(data[0]);
		    	lblLast.setText(data[1]);
		    	lblAge.setText(data[2]);
		    	lblCountry.setText(data[3]);
		    	lblPhone.setText(data[4]);
		    	lblEmail.setText(data[5]);
		    	
		    	// Consider adding JList Auto Scrolling...
		    	// https://stackoverflow.com/questions/2132444/jscrollpane-and-jlist-auto-scroll
			}
		});
		

		/*
		 * 	PART 3: VIEW > SORT CONTACTS BY AGE...
		 * 	https://stackoverflow.com/q/33190156/11542212
		 * 	https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
		 *	https://stackoverflow.com/q/2183669/11542212
		 */
		btnSortAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Sort the LinkedList by the AGE data member of each Address object
				Collections.sort(contactList, new Comparator<Address>() {
				    @Override
				    public int compare(Address a1, Address a2) {
				        return a1.getAge() - a2.getAge();
				    }
				});
				
			    // Clear, Add, and Refresh List
			    listModel.clear();
			    for (Address address : contactList)
			    	listModel.addElement(address.getFullName());	
			    
			    // Display first item in list (index = 0)
			    viewList.setSelectedIndex(0);
		    	Address selectedContact = contactList.get(0);
		    	String[] data = selectedContact.getData();
		    	
		    	lblFirst.setText(data[0]);
		    	lblLast.setText(data[1]);
		    	lblAge.setText(data[2]);
		    	lblCountry.setText(data[3]);
		    	lblPhone.setText(data[4]);
		    	lblEmail.setText(data[5]);
			}
		});
				
		/*
		 * 	PART 3: VIEW > SORT CONTACTS BY LAST NAME...
		 * 	https://stackoverflow.com/q/33190156/11542212
		 * 	https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
		 *	https://stackoverflow.com/q/2183669/11542212
		 */
		btnSortName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Sort the LinkedList by the LAST data member of each Address object
				Collections.sort(contactList, new Comparator<Address>() {
				    @Override
				    public int compare(Address a1, Address a2) {
				        return a1.getLast().compareTo(a2.getLast());
				    }
				});
				
			    // Clear, Add, and Refresh List
			    listModel.clear();
			    for (Address address : contactList)
			    	listModel.addElement(address.getFullName());	
			    
			    // Display first item in list (index = 0)
			    viewList.setSelectedIndex(0);
		    	Address selectedContact = contactList.get(0);
		    	String[] data = selectedContact.getData();

		    	lblFirst.setText(data[0]);
		    	lblLast.setText(data[1]);
		    	lblAge.setText(data[2]);
		    	lblCountry.setText(data[3]);
		    	lblPhone.setText(data[4]);
		    	lblEmail.setText(data[5]);
			}
		});
		
		// PART 3: VIEW > USER CLICKS CONTACT > DISPLAY IN VIEW PANEL
		// https://stackoverflow.com/questions/5609200/adding-an-actionlistener-to-a-jlist
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) { // 2 = double-click
		           String selectedItem = (String) viewList.getSelectedValue();
		           int index = viewList.getSelectedIndex();
		           System.out.println("index: " + index + " value: " + selectedItem);
		           
		           Address selectedContact = contactList.get(index);
		           String[] data = selectedContact.getData();
		           
		           lblFirst.setText(data[0]);
		           lblLast.setText(data[1]);
		           lblAge.setText(data[2]);
		           lblCountry.setText(data[3]);
		           lblPhone.setText(data[4]);
		           lblEmail.setText(data[5]);
		         }
		    }
		};
		viewList.addMouseListener(mouseListener);
		
		// PART 3: VIEW > USER SELECTS CONTACT AND PRESSES ENTER KEY > DISPLAY IN VIEW PANEL
		// https://stackoverflow.com/questions/5609200/adding-an-actionlistener-to-a-jlist
		viewList.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
			    if (e.getKeyCode() == KeyEvent.VK_ENTER){
			    	String selectedItem = (String) viewList.getSelectedValue();
			    	int index = viewList.getSelectedIndex();
			    	System.out.println("index: " + index + " value: " + selectedItem);

			    	Address selectedContact = contactList.get(index);
			    	String[] data = selectedContact.getData();

			    	lblFirst.setText(data[0]);
			    	lblLast.setText(data[1]);
			    	lblAge.setText(data[2]);
			    	lblCountry.setText(data[3]);
			    	lblPhone.setText(data[4]);
			    	lblEmail.setText(data[5]);
			    }
			}
		});
		
		// PART 4: ADD > ADD CONTACT
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// PART 4: VIEW > DELETE SELECTED CONTACT...
		btnViewDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
