package com.strawnplachta;

import java.awt.EventQueue;
import java.util.HashMap;

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

public class HandleActions
{
	Model model;
	MainGUI view;
	private int actionChoice = 1;
	private int deleteActionChoice = 0;

	public void HandleActions()
	{	
		actionChoice = 1;
		deleteActionChoice = 0;
	}

	public void addGUI(MainGUI view)
	{
		this.view = view;
	}

	public void addProgramOfDistinction(Model model)
	{
		this.model = model;
	}


	public void addStudent() 
	{
		view.editable(true);
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(false);	
	    view.bringToFront(false, false, false, false, true);
	    setSubmitButtonAction(0);
	}

	
	public void viewStudent() 
	{
		view.editable(true);
		setSubmitButtonAction(1);
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.bringToFront(false, false, true, false, false);
		view.showDeleteButton(false);
	}
	public void generateReports() 
	{
		view.editable(true);
		view.makeCheckBoxesVisibleOrInvisible(true);
		view.bringToFront(false, false, false, false, true);
		view.showDeleteButton(false);
		setSubmitButtonAction(4);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(false);

	}
	
	public void addUser() 
	{
		view.editable(true);
		view.bringToFront(false, false, false, true, false);
		setSubmitButtonAction(5);
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(false);
	}

	public void editUser() 
	{
		view.editable(true);
		setSubmitButtonAction(2);
		setDeleteButtonAction(1);
		view.changeDeleteButtonText("Delete User");
		view.showDeleteButton(true);
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.bringToFront(true, false, false, false, false);
		view.changeSubmitButtonText("Submit");
	}

	public void deleteUser()
	{
		int choice = view.promptYesNo("Are you sure you want to delete this user?", "Delete User");
		if(choice == JOptionPane.YES_OPTION)
		{
			view.prompt("User has been deleted");
		}

		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
	}

	public void changePassword()
	{
		view.bringToFront(false, true, false, false, false);
		setSubmitButtonAction(7);
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(false);
	}

	public void deleteStudent()
	{
		int choice =  view.promptYesNo("Are you sure you would like to delete this student?", "Delete Student");
		if (choice == JOptionPane.YES_OPTION)
        {
            //model.deleteStudent();
        view.bringToFront(false, false, true, false, false);
        view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
        }
        
	}
	
	public void addStudentSubmit()
	{
		view.getGeneralData();
		view.prompt("Student added Successfully!");
		setSubmitButtonAction(1);
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.bringToFront(false, false, true, false, false);
		view.showDeleteButton(false);
	}

	public void searchSubmit()
	{
		view.search();
		view.editable(false);
		view.bringToFront(false, false, false, false, true);
		view.showDeleteButton(true);
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.prompt("Student Found!");
		view.changeSubmitButtonText("Edit");
		setSubmitButtonAction(2);
		view.showDeleteButton(false);
	}

	public void editStudentSubmit()
	{
		view.changeSubmitButtonText("Submit");
		view.makeCheckBoxesVisibleOrInvisible(false);
		setSubmitButtonAction(3);
		setDeleteButtonAction(0);
		view.changeDeleteButtonText("Delete Student");
		view.showDeleteButton(true);
		view.editable(true);
	}

	public void commitEditStudentSubmit()
	{
		int choice;
		choice = view.promptYesNo("Are you sure everything is correct?", "Edit Student");
		if (choice == JOptionPane.YES_OPTION)
        {
            view.editable(false);
        }
        else
        {
        	view.prompt("No Changes were saved");
        }
	}

	public void generateReportsSubmit()
	{
		view.prompt("Reports to sent to a file!");
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(false);
	}

	public void addUserSubmit()
	{
		view.prompt("User added Successfully!");
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(false);
	}

	public void editUserSubmit()
	{
		view.prompt("User Updated Successfully!");
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(true);
	}

	public void changePasswordSubmit()
	{
			
		view.prompt("Password Changed Successfully!");
		view.makeCheckBoxesVisibleOrInvisible(false);
		view.changeSubmitButtonText("Submit");
		view.showDeleteButton(false);
	}

	public void closeWindow()
	{
		int choice;
		choice = view.promptYesNo("Are you sure you would like to exit?", "Exit Application");
		if (choice == JOptionPane.YES_OPTION)
        {
            System.exit(1);
        }
	}

	public void setSubmitButtonAction(int choice)
	{
		actionChoice = choice;
	}

	public void submitAction()
	{
		switch (actionChoice)
		{
			case 0:
				addStudentSubmit();
				break;
			case 1:
				searchSubmit();
				break;
			case 2:
				editStudentSubmit();
				break;
			case 3:
				commitEditStudentSubmit();
				break;
			case 4:
				generateReportsSubmit();
				break;
			case 5:
				addUserSubmit();
				break;
			case 6:
				editUserSubmit();
				break;
			case 7:
				changePasswordSubmit();
				break;
		}

	}

	public void setDeleteButtonAction(int choice)
	{
		deleteActionChoice = choice;
	}

	public void deleteButtonAction()
	{
		switch(deleteActionChoice)
		{
			case 0:
				deleteStudent();
				break;
			case 1:
				deleteUser();
				break;
		}
	}

	public void setCheckBoxes(int start, int end, boolean checked)
	{
		view.checkAll(start, end, checked);
	}

	public void createStudentObject(String fname, String lname, int id, String address, int zip,
								String major, String minor, String email, float gpa,
								int completedCreds, String sex)
	{
		/* test student
		Student student = new Student("Ben", "Strap", 479403, "2265 Fraser Road", 48631, 
            "Computer Science", "Psychology", "bcstrawn@svsu.edu", 3.75f, 113, "male");
        ProgramOfDistinction program1 = new Honors("September 1, 2009", "NS Chart", false, 
        false, "unkown", "Dr. James");
        student2.getPrograms().add(program1);*/

		Student student = new Student(fname, lname, id, address, zip, major, minor, 
			email, gpa, completedCreds, sex);
		model.addStudent(student);
		
	}

	public void searchStudents(String fname, String lname, String id)
	{
		HashMap<String, String> parameters = new HashMap<String, String>();
		if(!fname.equals(""))
		{
			parameters.put("firstName", fname);
		}
		
		if(!lname.equals(""))
		{

			parameters.put("lastName", lname);
		}

		if(!id.equals(""))
		{
			parameters.put("StudentID", id);
		}
		model.searchForStudents(parameters);
	}
} 


