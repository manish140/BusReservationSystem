package com.capg.brs.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.brs.dto.BookingDTO;
import com.capg.brs.dto.BusScheduleDTO;
import com.capg.brs.exceptions.BookingNotFoundException;
import com.capg.brs.repository.IBookingRepository;
import com.capg.brs.repository.IBusScheduleRepository;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	
	@Autowired
	 IBookingRepository bookingRepository;
	@Autowired
	IBusScheduleRepository scheduleRepository;

	
	
	public BookingDTO makeBooking(@Valid BookingDTO booking) {
    
		String scheduleId = booking.getBusSchedule().getScheduleId();
		BusScheduleDTO s = scheduleRepository.findById(scheduleId).get();
		int availableSeats = s.getAvailableSeats() - booking.getNoOfPassengers();
		s.setAvailableSeats(availableSeats);
		
		return  bookingRepository.save(booking);
	}

	public BookingDTO getBookingById(String bookingId) {
		if (!bookingRepository.existsById(bookingId)) {
			throw new BookingNotFoundException(" booking not found");
		}
		return bookingRepository.getBooking(bookingId);
	}
	
	public boolean cancelTickets(String bookingId) {
		boolean found = bookingRepository.existsById(bookingId);
		// If exists cancel tickets
		if (found) {
			//Getting previous booking details by booking id
			BookingDTO b=bookingRepository.findById(bookingId).get();
			//Getting schedule id from booking details 
			String scheduleid = b.getBusSchedule().getScheduleId();
			//Getting schedule details
			BusScheduleDTO s = scheduleRepository.findById(scheduleid).get();
			//Adding cancelled seats
			int availableSeats = s.getAvailableSeats() + b.getNoOfPassengers();
			s.setAvailableSeats(availableSeats);
			bookingRepository.deleteById(bookingId);
		}
		return found;
	}
}
