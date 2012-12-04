package com.strawnplachta;

import javax.jdo.annotations.PersistenceCapable;

/** This is the class for students that received an SRCI grant */
@PersistenceCapable
public class SRCI extends ProgramOfDistinction {
	private String dateReceived;
	private String projectDescription;
	private float grantAmount;
	private String mentor;

	public SRCI (String dateReceived, String projectDescription, float grantAmount, String mentor) {
		this.dateReceived = dateReceived;
		this.projectDescription = projectDescription;
		this.grantAmount = grantAmount;
		this.mentor = mentor;
	}

	public void setDateReceived (String dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getDateReceived () {
		return this.dateReceived;
	}

	public void setProjectDescription (String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectDescription () {
		return this.projectDescription;
	}

	public void setGrantAmount (float grantAmount) {
		this.grantAmount = grantAmount;
	}

	public float getGrantAmount () {
		return this.grantAmount;
	}

	public void setMentor (String mentor) {
		this.mentor = mentor;
	}

	public String getMentor () {
		return this.mentor;
	}
}