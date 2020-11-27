package com.capg.brs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.dto.BookingDTO;
import com.capg.brs.service.BookingServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookings")
@Transactional
public class BookingController {
	
	@Autowired
	BookingServiceImpl bookingService;
	
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking( @Valid @RequestBody BookingDTO booking) {
		if (booking.getNoOfPassengers() <= booking.getBusSchedule().getAvailableSeats()) {
		 booking=bookingService.makeBooking(booking);
		return new ResponseEntity<String>("bookingId:"+booking.getBookingId(), HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("seats not available",HttpStatus.OK);
	}
	
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable String bookingId) {

		BookingDTO b = bookingService.getBookingById(bookingId);

		return new ResponseEntity<BookingDTO>(b, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<BookingDTO> deleteBooking(@Valid @PathVariable String bookingId) {
		bookingService.cancelTickets(bookingId);
		return new ResponseEntity<BookingDTO>(HttpStatus.OK);

	}
}
