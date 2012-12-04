package com.bstrawn;

import javax.jdo.annotations.PersistenceCapable;

/** This is the class for when students receive an MSGC grant */
@PersistenceCapable
public class MSGC extends ProgramOfDistinction {
	private String dateJoined;
	private String projectDescription;
	private float grantAmount;
	private String mentor;

	public MSGC (String dateJoined, String projectDescription, float grantAmount, String mentor) {
		this.dateJoined = dateJoined;
		this.projectDescription = projectDescription;
		this.grantAmount = grantAmount;
		this.mentor = mentor;
	}

	public void setDateJoined (String dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getDateJoined () {
		return this.dateJoined;
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