package com.capg.brs.dto;

import java.time.LocalDate;
import java.util.List;

import com.capg.brs.entity.BusSchedule;
import com.capg.brs.entity.Passenger;
import com.capg.brs.entity.User;

public class BookingDTO {
	private String bookingId;
	private User user;
	private BusSchedule busSchedule;
	private List<Passenger> passenger;
	private LocalDate bookingDate;

	private int noOfPassengers;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BusSchedule getBusSchedule() {
		return busSchedule;
	}

	public void setBusSchedule(BusSchedule busSchedule) {
		this.busSchedule = busSchedule;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
}
