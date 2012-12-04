package com.strawnplachta;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;

public class MainGUI extends JFrame {

	//create element arrays
	private JCheckBox[] checkBoxArray = new JCheckBox[50];
	private JLabel[] labelArray = new JLabel[70];
	private JTextField[] textFieldArray = new JTextField[70];
	private JButton[] buttonArray = new JButton[10];
	
	
	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_1 ;
	private JRadioButton radioButtonMale;
	private JRadioButton radioButtonFemale;
	private JRadioButton radioAdministrator;
	private JRadioButton radioPowerUser;
	private JRadioButton radioSystemStaff;
	private JRadioButton radioAdministrator2;
	private JRadioButton radioPowerUser2;
	private JRadioButton radioSystemStaff2;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8; 
	private JPanel panel_10;
	private JPanel panel_12;
	private JPanel panel_14;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JSeparator separator_1;
	private JToggleButton tglbtnAdvancedSearch;
	
	/*private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();*/
	private JList list;
	private String[] users = {"Elliott, Tammy", "Gregory, kristen"};
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextPane textPane_1;
	private JTextPane textPane_2;
	private JTextPane textPane;
	private HandleActions controller;
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					    
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	//@SuppressWarnings("unchecked")
	public MainGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) 
			{
			/*	int choice;
			    choice = JOptionPane.showConfirmDialog(null, "Are you sure you would like to exit?", "Exit Application", JOptionPane.YES_NO_OPTION);
			        if (choice == JOptionPane.YES_OPTION)
			        {
			            System.exit(1);
			        }*/
			        controller.closeWindow();
			}
		});
		
		setTitle("Student Information Program\n");
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		int xPanel = 5;
		int yPanel = 5;
		int x2Panel = 580;
		int y2Panel = 465;
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(xPanel, yPanel, x2Panel, y2Panel);
		contentPane.add(tabbedPane);
		tabbedPane.setVisible(false);

		

		//Initialize checkBoxArray
		for(int i = 0; i < 44; i++)
			checkBoxArray[i] = new JCheckBox("");
		//Initialize textFieldArray
		for(int i = 0; i < 50; i++)
			textFieldArray[i] = new JTextField();

		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_1 *************************************************************
		//*******************************************************************************************************************************************
		
		panel_1 = new JPanel();
		tabbedPane.addTab("General", null, panel_1, null);
		panel_1.setLayout(null);
		
		//Check box array
		for(int i = 0; i < 10; i++) {
			checkBoxArray[i].setBounds(25, 10+i*35, 28, 23);
			panel_1.add(checkBoxArray[i]);
		}
		//checkBoxArray[0].setSelected(true);

		checkBoxArray[0].addItemListener(new ItemListener() 
		{
      		public void itemStateChanged(ItemEvent e) 
      		{
	        	if (checkBoxArray[0].isSelected())
	        	{
	        		controller.setCheckBoxes(1, 18, true);
	        	}
	        	else if(!checkBoxArray[0].isSelected())
	        	{
	        		controller.setCheckBoxes(1, 18, false);
	        	}
      		}
    	});

		for(int i = 0; i < 9; i++) {
			checkBoxArray[i+10].setBounds(295, 45+i*35, 28, 23);
			panel_1.add(checkBoxArray[i+10]);
		}
		
		//Label array
		labelArray[0] = new JLabel("Check All");
		labelArray[1] = new JLabel("First Name:");
		labelArray[2] = new JLabel("MI:");
		labelArray[3] = new JLabel("Zip:");
		labelArray[4] = new JLabel("State:");
		labelArray[5] = new JLabel("Phone #:");
		labelArray[6] = new JLabel("Email:");
		labelArray[7] = new JLabel("Email 2:");
		labelArray[8] = new JLabel("Completed Credits:");
		labelArray[9] = new JLabel("Sex:");
		labelArray[10] = new JLabel("Last Name:");
		labelArray[11] = new JLabel("Former:");
		labelArray[12] = new JLabel("Address:");
		labelArray[13] = new JLabel("City:");
		labelArray[14] = new JLabel("Major:");
		labelArray[15] = new JLabel("Minor:");
		labelArray[16] = new JLabel("GPA:");
		labelArray[17] = new JLabel("ID:");
		labelArray[18] = new JLabel("Last Updated:");

		for(int i = 0; i < 10; i++) {
			labelArray[i].setBounds(55, 13+i*35, 70, 16);
			labelArray[i].setHorizontalAlignment(JTextField.RIGHT);
			panel_1.add(labelArray[i]);
		}
		for(int i = 0; i < 9; i++) {
			labelArray[i+10].setBounds(325, 48+i*35, 70, 16);
			labelArray[i+10].setHorizontalAlignment(JTextField.RIGHT);
			panel_1.add(labelArray[i+10]);
		}
		
		//Text field array
		for(int i = 0; i < 8; i++) {
			textFieldArray[i].setBounds(135, 43+i*35, 135, 28);
			panel_1.add(textFieldArray[i]);
		}
		for(int i = 0; i < 9; i++) {
			textFieldArray[i+8].setBounds(405, 43+i*35, 135, 28);
			panel_1.add(textFieldArray[i+8]);
		}

		//Specifically sized elements
		labelArray[8].setSize(110, 16);
		labelArray[18].setSize(90, 16);
		textFieldArray[7].setBounds(175, 288, 95, 28);
		textFieldArray[16].setBounds(425, 323, 115, 28);
		
		radioButtonMale = new JRadioButton("Male");
		radioButtonMale.setBounds(135, 325, 60, 23);
		panel_1.add(radioButtonMale);
		
		radioButtonFemale = new JRadioButton("Female");
		radioButtonFemale.setBounds(200, 325, 70, 23);
		panel_1.add(radioButtonFemale);
		
		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_2 *************************************************************
		//*******************************************************************************************************************************************
		
		panel_2 = new JPanel();
		tabbedPane.addTab("SRCI", null, panel_2, null);
		panel_2.setLayout(null);
		
		//Check box array
		for(int i = 0; i < 9; i++) {
			checkBoxArray[i+19].setBounds(25, 10+i*35, 28, 23);
			panel_2.add(checkBoxArray[i+19]);
		}	
		//checkBoxArray[19].setSelected(true);

		checkBoxArray[19].addItemListener(new ItemListener() 
		{
      		public void itemStateChanged(ItemEvent e) 
      		{
	        	if (checkBoxArray[19].isSelected())
	        	{
	        		controller.setCheckBoxes(20, 36, true);
	        	}
	        	else
	        	{
	        		controller.setCheckBoxes(20, 36, false);
	        	}
      		}
    	});	

		for(int i = 0; i < 8; i++) {
			checkBoxArray[i+28].setBounds(290, 80+i*35, 28, 23);
			panel_2.add(checkBoxArray[i+28]);
		}

		checkBoxArray[36].setBounds(140, 10, 28, 23);
		panel_2.add(checkBoxArray[36]);
		
		//Label array
		labelArray[19] = new JLabel("Check All");
		labelArray[20] = new JLabel("Purpose:");
		labelArray[21] = new JLabel("College:");
		labelArray[22] = new JLabel("Amount:");
		labelArray[23] = new JLabel("Travel:");
		labelArray[24] = new JLabel("Dates:");
		labelArray[25] = new JLabel("Costs:");
		labelArray[26] = new JLabel("Semester:");
		labelArray[27] = new JLabel("Project Description:");
		labelArray[28] = new JLabel("Sample Doc:");
		labelArray[29] = new JLabel("Date Approved:");
		labelArray[30] = new JLabel("Date Completed:");
		labelArray[31] = new JLabel("Semester:");
		labelArray[32] = new JLabel("CoGrantees:");
		labelArray[33] = new JLabel("Permission Granted:");
		labelArray[34] = new JLabel("Faculty Mentor:");
		labelArray[35] = new JLabel("Notes:");
		labelArray[36] = new JLabel("Project Title:");
		
		for(int i = 0; i < 9; i++) {
			labelArray[i+19].setBounds(55, 10+i*35, 60, 23);
			labelArray[i+19].setHorizontalAlignment(JTextField.RIGHT);
			panel_2.add(labelArray[i+19]);
		}		
		for(int i = 0; i < 8; i++) {
			labelArray[i+28].setBounds(320, 80+i*35, 95, 23);
			labelArray[i+28].setHorizontalAlignment(JTextField.RIGHT);
			panel_2.add(labelArray[i+28]);
		}
		
		//Text field array
		for(int i = 0; i < 8; i++) {
			textFieldArray[i+17].setBounds(125, 8+i*35, 145, 28);
			panel_2.add(textFieldArray[i+17]);
		}
		for(int i = 0; i < 7; i++) {
			textFieldArray[i+25].setBounds(420, 78+i*35, 135, 28);
			panel_2.add(textFieldArray[i+25]);
		}
		
		//specifically sized elements
		labelArray[27].setSize(115, 23);
		labelArray[33].setSize(120, 23);
		labelArray[35].setSize(40, 23);
		labelArray[36].setBounds(170, 10, 90, 23);
		panel_2.add(labelArray[36]);
		textFieldArray[17].setBounds(260, 8, 295, 28);
		textFieldArray[18].setSize(430, 28);
		textFieldArray[30].setBounds(445, 253, 110, 28);
		textFieldArray[49].setBounds(445, 288, 110, 28);
		panel_2.add(textFieldArray[49]);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(370, 330, 185, 80);
		panel_2.add(scrollPane_1);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(60, 320, 210, 90);
		panel_2.add(scrollPane_2);
		
		textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(204, 255, 255));
		scrollPane_1.setViewportView(textPane_1);
		
		textPane = new JTextPane();
		textPane.setBackground(new Color(204, 204, 255));
		scrollPane_2.setViewportView(textPane);
		
		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_3 *************************************************************
		//*******************************************************************************************************************************************
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Honors", null, panel_3, null);
		panel_3.setLayout(null);
		
		//check boxes
		checkBoxArray[37].setBounds(29, 35, 28, 23);

		checkBoxArray[40].addItemListener(new ItemListener() 
		{
      		public void itemStateChanged(ItemEvent e) 
      		{
	        	if (checkBoxArray[40].isSelected())
	        	{
	        		controller.setCheckBoxes(37, 39, true);
	        	}
	        	else 
	        	{
	        		controller.setCheckBoxes(37, 39, false);
	        	}
      		}
    	});

		checkBoxArray[38].setBounds(29, 170, 28, 23);
		checkBoxArray[39].setBounds(29, 230, 28, 23);
		checkBoxArray[40].setBounds(29, 0, 28, 23);
		
		//labels
		labelArray[37] = new JLabel("Thesis:");
		labelArray[38] = new JLabel("Advisor:");
		labelArray[39] = new JLabel("Expected Graduation Date:");
		labelArray[40] = new JLabel("Check All");
		
		labelArray[37].setBounds(58, 35, 70, 23);
		labelArray[38].setBounds(58, 170, 70, 23);
		labelArray[39].setBounds(58, 230, 188, 23);
		labelArray[40].setBounds(58, 0, 70, 23);
		
		//add them to the panel
		for(int i = 37; i < 41; i++) {
			panel_3.add(checkBoxArray[i]);
			panel_3.add(labelArray[i]);
		}
		
		textFieldArray[31].setBounds(116, 167, 393, 28);
		panel_3.add(textFieldArray[31]);
		
		textFieldArray[32].setBounds(230, 230, 279, 28);
		panel_3.add(textFieldArray[32]);
		
		textPane_2 = new JTextPane();
		textPane_2.setBackground(new Color(204, 153, 255));
		textPane_2.setBounds(116, 35, 393, 120);
		panel_3.add(textPane_2);
		
		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_4 *************************************************************
		//*******************************************************************************************************************************************		
		panel = new JPanel();
		tabbedPane.addTab("Roberts Fellows", null, panel, null);
		panel.setLayout(null);
		
		checkBoxArray[41].setBounds(26, 41, 28, 23);
		checkBoxArray[42].setBounds(300, 41, 28, 23);
		checkBoxArray[43].setBounds(26, 6, 28, 23);

		checkBoxArray[43].addItemListener(new ItemListener() 
		{
      		public void itemStateChanged(ItemEvent e) 
      		{
	        	if (checkBoxArray[43].isSelected())
	        	{
	        		controller.setCheckBoxes(41, 43, true);
	        	}
	        	else
	        	{
	        		controller.setCheckBoxes(41, 43, false);
	        	}
      		}
    	});

		labelArray[41] = new JLabel("Check All");
		labelArray[42] = new JLabel("Class:");
		labelArray[43] = new JLabel("Year:");
		
		labelArray[41].setBounds(56, 6, 72, 23);
		labelArray[42].setBounds(56, 45, 61, 16);
		labelArray[43].setBounds(330, 45, 61, 16);

		for(int i = 41; i < 44; i++) {
			panel.add(checkBoxArray[i]);
			panel.add(labelArray[i]);
		}
		
		textFieldArray[33].setBounds(106, 41, 161, 23);
		panel.add(textFieldArray[33]);
		
		textFieldArray[34].setBounds(373, 41, 161, 23);
		panel.add(textFieldArray[34]);
		
		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_5 *************************************************************
		//*******************************************************************************************************************************************

		/*panel_5 = new JPanel();
		panel_5.setBounds(55, 306, 228, 28);
		panel_5.setBackground(SystemColor.window);
		panel_5.setLayout(new GridLayout(1, 3, 0, 0));
		
		panel_6 = new JPanel();
		tabbedPane.addTab("MSGC", null, panel_6, null);
		panel_6.setLayout(null);*/
		

		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_7 *************************************************************
		//*******************************************************************************************************************************************

		panel_7 = new JPanel();
		panel_7.setBounds(xPanel, yPanel, x2Panel, y2Panel);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		labelArray[44] = new JLabel("Last Name:");
		labelArray[45] = new JLabel("Search");
		labelArray[46] = new JLabel("First Name:");
		labelArray[47] = new JLabel("Or");
		labelArray[48] = new JLabel("Student ID:");
		
		labelArray[44].setBounds(36, 84, 70, 16);
		labelArray[45].setBounds(24, 6, 99, 46);
		labelArray[46].setBounds(34, 112, 72, 16);
		labelArray[47].setBounds(291, 84, 29, 31);
		labelArray[48].setBounds(341, 90, 70, 16);
		
		for(int i = 44; i < 49; i++) {
			panel_7.add(labelArray[i]);
		}
		
		labelArray[45].setFont(new Font("Meiryo", Font.PLAIN, 30));
		labelArray[47].setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		textFieldArray[35].setBounds(118, 78, 151, 28);
		textFieldArray[36].setBounds(118, 106, 151, 28);
		textFieldArray[37].setBounds(423, 84, 134, 28);
		panel_7.add(textFieldArray[35]);
		panel_7.add(textFieldArray[36]);
		panel_7.add(textFieldArray[37]);
		
		separator = new JSeparator();
		separator.setBounds(6, 43, 565, 16);
		panel_7.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(16, 6, 18, 455);
		panel_7.add(separator_1);
		
		tglbtnAdvancedSearch = new JToggleButton("Advanced Search");
		tglbtnAdvancedSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnAdvancedSearch.isSelected()) {
					panel_8.setVisible(true);
				} else {
					panel_8.setVisible(false);
				}
			}
		});
		tglbtnAdvancedSearch.setBounds(242, 146, 142, 29);
		panel_7.add(tglbtnAdvancedSearch);
		
		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_8 *************************************************************
		//*******************************************************************************************************************************************
		
		panel_8 = new JPanel();
		panel_8.setBounds(36, 199, 524, 168);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		panel_8.setVisible(false);
		
		labelArray[49] = new JLabel("Address:");
		labelArray[50] = new JLabel("State:");
		labelArray[51] = new JLabel("Zip:");
		labelArray[52] = new JLabel("Credits Completed:");
		
		checkBoxArray[44] = new JCheckBox("Roberts Fellows");
		checkBoxArray[45] = new JCheckBox("Honors");
		checkBoxArray[46] = new JCheckBox("SRCI");
		checkBoxArray[47] = new JCheckBox("MSGC");
		
		for(int i = 0; i < 4; i++) {
			textFieldArray[i+38].setBounds(75, 7+30*i, 210, 25);
			panel_8.add(textFieldArray[i+38]);
			labelArray[i+49].setBounds(10, 10+30*i, 120, 16);
			panel_8.add(labelArray[i+49]);
			checkBoxArray[i+44].setBounds(375, 10+30*i, 200, 23);
			panel_8.add(checkBoxArray[i+44]);
		}
		
		labelArray[53] = new JLabel("Program:");
		labelArray[53].setBounds(315, 10, 56, 16);
		panel_8.add(labelArray[53]);
		textFieldArray[41].setBounds(130, 97, 155, 25);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(299, -13, 17, 181);
		panel_8.add(separator_4);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		
		//*******************************************************************************************************************************************
		//********************************************************* Initialize Panel_10 *************************************************************
		//*******************************************************************************************************************************************	
		
		panel_10 = new JPanel();
		panel_10.setBounds(xPanel, yPanel, x2Panel, y2Panel);
		panel_10.setLayout(null);
		panel_10.setVisible(false);
		contentPane.add(panel_10);
		
		textFieldArray[42].setBounds(235, 96, 193, 28);
		panel_10.add(textFieldArray[42]);
		
		textFieldArray[43].setBounds(235, 136, 193, 28);
		panel_10.add(textFieldArray[43]);
		
		labelArray[54] = new JLabel("Add User");
		labelArray[55] = new JLabel("Username:");
		labelArray[56] = new JLabel("Password:");
		labelArray[57] = new JLabel("Priviledges:");
		
		for(int i = 0; i < 4; i++) {
			labelArray[i+54].setBounds(135, 57+i*40, 70, 25);
			panel_10.add(labelArray[i+54]);
		}
		labelArray[54].setBounds(36, 22, 124, 44);
		labelArray[54].setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		
		radioAdministrator = new JRadioButton("Administrator");
		radioSystemStaff = new JRadioButton("System Staff");
		radioPowerUser = new JRadioButton("Power User");
		radioAdministrator.setBounds(235, 175, 120, 23);
		radioPowerUser.setBounds(235, 200, 120, 23);
		radioSystemStaff.setBounds(235, 225, 120, 23);
		panel_10.add(radioAdministrator);
		panel_10.add(radioPowerUser);
		panel_10.add(radioSystemStaff);		
		
		separator_2 = new JSeparator();
		separator_2.setBounds(6, 60, 541, 12);
		panel_10.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(28, 20, 12, 435);
		panel_10.add(separator_3);
		
		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_12 ************************************************************
		//*******************************************************************************************************************************************			

		panel_12 = new JPanel();
		panel_12.setBounds(xPanel, yPanel, x2Panel, y2Panel);
		panel_12.setVisible(false);
		panel_12.setLayout(null);
		contentPane.add(panel_12);
		
		list = new JList(users);
		list.setBackground(new Color(204, 255, 204));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(41, 95, 123, 329);
		panel_12.add(list);
		
		labelArray[58] = new JLabel("Edit User");
		labelArray[59] = new JLabel("Select User");
		labelArray[60] = new JLabel("Username:");
		labelArray[61] = new JLabel("Password:");
		labelArray[62] = new JLabel("Priviledges:");
		labelArray[58].setBounds(443, 20, 113, 27);
		labelArray[59].setBounds(41, 67, 102, 16);
		labelArray[60].setBounds(275, 150, 246, 16);
		labelArray[61].setBounds(275, 200, 246, 16);
		labelArray[62].setBounds(275, 250, 246, 16);
		
		labelArray[58].setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		for(int i = 0; i < 5; i++) {
			panel_12.add(labelArray[i+58]);
		}	
		
		textFieldArray[44].setBounds(360, 145, 162, 28);
		panel_12.add(textFieldArray[44]);
		
		textFieldArray[45].setBounds(360, 195, 162, 28);
		panel_12.add(textFieldArray[45]);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(6, 45, 565, 16);
		panel_12.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(553, 6, 18, 455);
		panel_12.add(separator_6);

		radioAdministrator2 = new JRadioButton("Administrator");
		radioPowerUser2 = new JRadioButton("Power User");
		radioSystemStaff2 = new JRadioButton("System Staff");
		radioAdministrator2.setBounds(360, 250, 119, 23);
		radioPowerUser2.setBounds(360, 275, 101, 23);
		radioSystemStaff2.setBounds(360, 300, 110, 23);
		panel_12.add(radioAdministrator2);
		panel_12.add(radioPowerUser2);
		panel_12.add(radioSystemStaff2);
		
		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_14 ************************************************************
		//*******************************************************************************************************************************************	

		panel_14 = new JPanel();
		panel_14.setBounds(xPanel, yPanel, x2Panel, y2Panel);
		panel_14.setVisible(false);
		panel_14.setLayout(null);
		contentPane.add(panel_14);
		
		labelArray[63] = new JLabel("Current Password:");
		labelArray[64] = new JLabel("New Password:");
		labelArray[65] = new JLabel("Retype New Password:");
		labelArray[66] = new JLabel("Change Password");
		
		for(int i = 0; i < 3; i++) {
			labelArray[i+63].setBounds(110, 150+40*i, 150, 16);
			panel_14.add(labelArray[i+63]);
			textFieldArray[i+46].setBounds(270, 145+40*i, 150, 28);
			panel_14.add(textFieldArray[i+46]);
		}
		
		labelArray[66].setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		labelArray[66].setBounds(28, 6, 223, 47);
		panel_14.add(labelArray[66]);
		
		separator_7 = new JSeparator();
		separator_7.setBounds(6, 49, 575, 16);
		panel_14.add(separator_7);
		
		separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBounds(16, 6, 17, 361);
		panel_14.add(separator_8);

		//*******************************************************************************************************************************************
		//********************************************************** Initialize Panel_4 *************************************************************
		//*******************************************************************************************************************************************	
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(590, 5, 170, 465);
		contentPane.add(scrollPane);
	
		panel_4 = new JPanel();
		panel_4.setBackground(UIManager.getColor("Button.background"));
		panel_4.setLayout(null);
		scrollPane.setViewportView(panel_4);
		
		buttonArray[0] = new JButton("Add Student\n");
		buttonArray[1] = new JButton("View Student");
		buttonArray[2] = new JButton("Generate Reports");
		buttonArray[3] = new JButton("Add User");
		buttonArray[4] = new JButton("Edit User");
		buttonArray[5] = new JButton("Change Password");
		buttonArray[6] = new JButton("Delete Student");
		buttonArray[7] = new JButton("Submit");
		
		for(int i = 0; i < 8; i++) {
			buttonArray[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			buttonArray[i].setBounds(0, i*45, 168, 45);
			panel_4.add(buttonArray[i]);
		}
		
		buttonArray[6].setBounds(0, 373, 168, 45);
		buttonArray[6].setVisible(false);
		buttonArray[7].setBounds(0, 418, 168, 45);
	
		
		buttonArray[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.addStudent();
			}
		});
		buttonArray[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.viewStudent();
			}
		});
		buttonArray[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.generateReports();
			}
		});
		buttonArray[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.addUser();
			}
		});
		buttonArray[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.editUser();
			}
		});
		buttonArray[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.changePassword();
			}
		});
		buttonArray[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.deleteButtonAction();
			}
		});
		buttonArray[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.submitAction();
			}
		});

		makeCheckBoxesVisibleOrInvisible(false);
		editable(true);
	}
	

	
	private void getSearchTerms()
	{
		
	}


	
	public void makeCheckBoxesVisibleOrInvisible(boolean trueOrFalse)
	{
		for(int i = 0; i < 43; i++) {
			checkBoxArray[i].setVisible(trueOrFalse);
		}
	}
	
	public void checkAll(int start, int end, boolean select)
	{
		for(int i = start; i <= end; i++)
		{
			checkBoxArray[i].setSelected(select);
		}
	}

	public void bringToFront(boolean pan12, boolean pan14, boolean pan7, boolean pan10, boolean panTabbed)
	{
		panel_12.setVisible(pan12);
		panel_14.setVisible(pan14);
		panel_7.setVisible(pan7);
		panel_10.setVisible(pan10);
		tabbedPane.setVisible(panTabbed);
	}
	
	public void editable(boolean editOrNot)
	{
		for (int i = 0; i <48; i++) 
		{
			textFieldArray[i].setEditable(editOrNot);
		}
	}

	public int promptYesNo(String message, String titleBar)
	{
		int choice;
	    choice = JOptionPane.showConfirmDialog(null, message, titleBar, JOptionPane.YES_NO_OPTION);
        return choice;
	}

	public void prompt(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}

	public void showDeleteButton(boolean show)
	{
		buttonArray[6].setVisible(show);
	}

	public void addHandleActions(HandleActions controller)
	{
		this.controller = controller;
	}
	
	public void changeSubmitButtonText(String buttonText)
	{
		buttonArray[7].setText(buttonText);
	}

	public void changeDeleteButtonText(String buttonText)
	{
		buttonArray[6].setText(buttonText);
	}

	public void getGeneralData()
	{
		String fname;
		String lname;
		int id ;
		String address ;
		int zip;
		String major;
		String minor;
		String email;
		float gpa;
		int completedCreds; 
		String sex;

			fname = textFieldArray[0].getText();
			lname =	textFieldArray[8].getText();
			address	= textFieldArray[10].getText();
			major =	textFieldArray[12].getText();
			minor = textFieldArray[13].getText();
			email =	textFieldArray[5].getText();
			sex = textFieldArray[9].getText();

			if(textFieldArray[15].getText().equals(""))
			{
				id = 0;
			}
			else
			{
				id = Integer.parseInt(textFieldArray[15].getText());
			}
			
			if(textFieldArray[2].getText().equals(""))
			{
				zip = 0;
			}
			else
			{
				zip = Integer.parseInt(textFieldArray[2].getText());
			}
			
			if(textFieldArray[14].getText().equals(""))
			{
				gpa = 0;
			}
			else
			{
				gpa = Float.parseFloat(textFieldArray[14].getText());
			}
			
			if(textFieldArray[7].getText().equals(""))
			{
				completedCreds = 0;
			}
			else
			{
				completedCreds = Integer.parseInt(textFieldArray[7].getText());
			}
			


		controller.createStudentObject(fname, lname, id, address, zip, major, minor, email, 
									   gpa, completedCreds, sex);
	}

	public void search()
	{
		controller.searchStudents(textFieldArray[36].getText(), textFieldArray[35].getText(), textFieldArray[37].getText());
	}
}






