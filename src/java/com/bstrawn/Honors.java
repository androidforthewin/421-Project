package com.bstrawn;

import javax.jdo.annotations.PersistenceCapable;

/** This is the class for when students are a part of the Honors program */
@PersistenceCapable
public class Honors extends ProgramOfDistinction {
	private String dateJoined;
	private String researchTopic;
	private boolean thesisCompleted;
	private boolean classCompleted;
	private String thesisPresentationDate;
	private String mentor;

	public Honors (String dateJoined, String researchTopic, boolean thesisCompleted, 
		boolean classCompleted, String thesisPresentationDate, String mentor) {
		this.dateJoined = dateJoined;
		this.researchTopic = researchTopic;
		this.thesisCompleted = thesisCompleted;
		this.classCompleted = classCompleted;
		this.thesisPresentationDate = thesisPresentationDate;
		this.mentor = mentor;
	}

	public void setDateJoined (String dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getDateJoined () {
		return this.dateJoined;
	}

	public void setResearchTopic (String researchTopic) {
		this.researchTopic = researchTopic;
	}

	public String getResearchTopic () {
		return this.researchTopic;
	}

	public void setThesisCompleted (boolean thesisCompleted) {
		this.thesisCompleted = thesisCompleted;
	}

	public boolean getThesisCompleted () {
		return this.thesisCompleted;
	}

	public void setClassCompleted (boolean classCompleted) {
		this.classCompleted = classCompleted;
	}

	public boolean getClassCompleted () {
		return this.classCompleted;
	}

	public void setThesisPresentationDate (String thesisPresentationDate) {
		this.thesisPresentationDate = thesisPresentationDate;
	}

	public String getThesisPresentationDate () {
		return thesisPresentationDate;
	}

	public void setMentor (String mentor) {
		this.mentor = mentor;
	}

	public String getMentor () {
		return this.mentor;
	}
}