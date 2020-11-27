package com.capg.brs.dto;

import java.time.LocalDateTime;

import com.capg.brs.entity.Bus;
import com.capg.brs.entity.BusStop;

public class BusScheduleDTO {
	private String scheduleId;
	private Bus bus;
	private BusStop source;
    private BusStop destination;
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public BusStop getSource() {
		return source;
	}
	public void setSource(BusStop source) {
		this.source = source;
	}
	public BusStop getDestination() {
		return destination;
	}
	public void setDestination(BusStop destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	double fare;
	private int availableSeats;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
}
