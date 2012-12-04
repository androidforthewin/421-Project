package com.strawnplachta;

import javax.jdo.annotations.PersistenceCapable;

/** This is the class for when a student is a Roberts Fellow */
@PersistenceCapable
public class Roberts extends ProgramOfDistinction {
	private String dateJoined;
	private String serviceProjectDescription;
	private boolean serviceProjectCompleted;
	private String tripDestination;

	public Roberts (String dateJoined, String serviceProjectDescription, boolean serviceProjectCompleted,
		String tripDestination) {
		this.dateJoined = dateJoined;
		this.serviceProjectDescription = serviceProjectDescription;
		this.serviceProjectCompleted = serviceProjectCompleted;
		this.tripDestination = tripDestination;
	}


	public void setDateJoined (String dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getDateJoined() {
		return this.dateJoined;
	}

	public void setServiceProjectDescription (String serviceProjectDescription) {
		this.serviceProjectDescription = serviceProjectDescription;
	}

	public String getServiceProjectDescription () {
		return this.serviceProjectDescription;
	}

	public void setServiceProjectCompleted (boolean serviceProjectCompleted) {
		this.serviceProjectCompleted = serviceProjectCompleted;
	}

	public boolean getServiceProjectCompleted () {
		return serviceProjectCompleted;
	}

	public void setTripDestination (String tripDestination) {
		this.tripDestination = tripDestination;
	}

	public String getTripDestination () {
		return tripDestination;
	}
}