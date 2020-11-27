package com.capg.brs.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.dto.BookingDTO;

@Repository
public interface IBookingRepository extends JpaRepository<BookingDTO, String> {


	@Query("SELECT b FROM Booking b WHERE bookingId = ?1")
	public BookingDTO getBooking(String bookingId);

	@SuppressWarnings("unchecked")
	public BookingDTO save(@Valid BookingDTO booking);

	


}
