package com.capg.brs.exceptions;

public class BookingNotFoundException extends RuntimeException {
	public BookingNotFoundException(String message) {
		super(message);
	}
}
