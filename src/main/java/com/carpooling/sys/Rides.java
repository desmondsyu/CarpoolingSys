package com.carpooling.sys;

public class Rides {
	private String startLocation, destination;
	private int seatsAvailable;

	public Rides(String startLocation, String destination, int seatsAvailable) {
		setStartLocation(startLocation);
		setDestination(destination);
		setSeatAvailable(seatsAvailable);
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setSeatAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public String getDestination() {
		return destination;
	}

	public int getSeatAvailable() {
		return seatsAvailable;
	}
}
