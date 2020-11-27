package com.capg.brs.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="booking8")
@Entity
public class Booking {
       
	@Id
	@Column(name = "booking_id")
	private String bookingId;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToOne
	@JoinColumn(name = "scheduleId")
	private BusSchedule busSchedule;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	private List<Passenger> passenger;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	private int noOfPassengers;

	public Booking() {
	}

	public Booking(String bookingId, User user, BusSchedule busSchedule, List<Passenger> passenger,
			LocalDate bookingDate, int noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.busSchedule = busSchedule;
		this.passenger = passenger;
		this.bookingDate = bookingDate;
		this.noOfPassengers = noOfPassengers;
	}

	public Booking(String bookingId) {
		this.bookingId = bookingId;
	}

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

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassengers(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	

	
	

	
}
