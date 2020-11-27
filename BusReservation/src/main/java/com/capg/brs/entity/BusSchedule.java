package com.capg.brs.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="schedule8")
@Entity
public class BusSchedule {

	@Id
	private String scheduleId;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "bus_number") 
	private Bus bus;
	@OneToOne                     
	@JoinColumn(name="source" , referencedColumnName="busStopCode")
	private BusStop source;
	
	@OneToOne
	@JoinColumn(name="destination" , referencedColumnName="busStopCode")
	private BusStop destination;
	
	double fare;
	private int availableSeats;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	
	
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
}
