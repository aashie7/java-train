package com.web.services;

import java.util.Date;

public class TrainBean {

	String source;
	String destination;
	int trainId;
	int seats;
	String trainName;

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "TrainBean [source=" + source + ", destination=" + destination + ", trainId=" + trainId + ", seats="
				+ seats + ", trainName=" + trainName + "]";
	}
}
