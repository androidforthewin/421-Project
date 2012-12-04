package com.strawnplachta;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/** This is the class to represent the students in the program of distinction */
@PersistenceCapable
public class Student {
	private String firstName;
	private String lastName;
	@PrimaryKey
	private int studentID;
	private String address;
	private int zip;
	private String major;
	private String minor;
	private String email;
	private float gpa;
	private int completedCredits;
	private String sex;
	private Set<ProgramOfDistinction> programs;

	public Student()
	{
		this.firstName = null;
		this.lastName = null;
		this.studentID = -1;
		this.address = null;
		this.zip = -1;
		this.major = null;
		this.minor = null;
		this.email = null;
		this.gpa = -1;
		this.completedCredits = -1;
		this.sex = null;
		this.programs = new HashSet<ProgramOfDistinction>();
	}
	
	public Student (String firstName, String lastName, int studentID, String address, int zip, 
		String major, String minor, String email, float gpa, int completedCredits, String sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.address = address;
		this.zip = zip;
		this.major = major;
		this.minor = minor;
		this.email = email;
		this.gpa = gpa;
		this.completedCredits = completedCredits;
		this.sex = sex;
		this.programs = new HashSet<ProgramOfDistinction>();
	}

	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName () {
		return this.firstName;
	}


	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public String getLastName () {
		return this.lastName;
	}


	public void setStudentID (int studentID) {
		this.studentID = studentID;
	}

	public int getStudentID () {
		return this.studentID;
	}


	public void setAddress (String address) {
		this.address = address;
	}

	public String getAddress () {
		return this.address;
	}


	public void setZip (int zip) {
		this.zip = zip;
	}

	public int getZip () {
		return this.zip;
	}

	public void setMajor (String major) {
		this.major = major;
	}

	public String getMajor () {
		return this.major;
	}

	public void setMinor (String minor) {
		this.minor = minor;
	}

	public String getMinor () {
		return this.minor;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	public String getEmail () {
		return this.email;
	}

	public void setGpa (float gpa) {
		this.gpa = gpa;
	}

	public float getGpa () {
		return this.gpa;
	}

	public void setCompletedCredits (int completedCredits) {
		this.completedCredits = completedCredits;
	}

	public int getCompletedCredits () {
		return this.completedCredits;
	}

	public void setSex (String sex) {
		this.sex = sex;
	}

	public String getSex () {
		return this.sex;
	}

	public Set<ProgramOfDistinction> getPrograms () {
		return this.programs;
	}
}