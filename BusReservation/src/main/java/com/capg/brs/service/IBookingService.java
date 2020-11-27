package com.capg.brs.service;

import com.capg.brs.dto.BookingDTO;

public interface IBookingService {

public BookingDTO makeBooking(BookingDTO bookingDetails);
public BookingDTO getBookingById(String bookingId);
	boolean cancelTickets(String bookingId);
	
}
