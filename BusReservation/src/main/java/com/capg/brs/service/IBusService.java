package com.capg.brs.service;

import com.capg.brs.entity.Bus;

public interface IBusService {
	public Bus addBus(Bus bus);

	public Iterable<Bus> viewAllBuses();

	public Bus viewBus(Long busId);

	

	public String removeBus(Long busId);
}
