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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;

public class RunSOD
{
	public RunSOD()
	{

		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Model model = new Model();
					MainGUI view = new MainGUI();
					view.setVisible(true);
					view.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					HandleActions controller = new HandleActions();
					controller.addProgramOfDistinction(model);
					controller.addGUI(view);
					view.addHandleActions(controller);    
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//MainGUI view = new MainGUI();
		
	}

	public static void main(String[] args) 
	{
		RunSOD runit = new RunSOD();
	}
}