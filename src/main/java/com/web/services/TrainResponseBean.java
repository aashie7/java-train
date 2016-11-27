package com.web.services;

public class TrainResponseBean {
	String source;
	String destination;
	int trainId;
	String days;
	int seats;
	String trainName;
	public TrainResponseBean() {
	}
	
	public TrainResponseBean(String trainName, int trainId, String source, String destination, int seats) {
		this.trainName = trainName;
		this.trainId=trainId;;
		this.source=source;
		this.destination=destination;
		this.seats=seats; 
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

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}


	
	@Override
	public String toString() {
		return "Trains {trainName:" + trainName + ", trainId: " + trainId + ", source: " + source +
				", destination: " + destination +", seats: " + seats +"}";
	}

}
