package com.capg.brs.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.capg.brs.entity.BusSchedule;

public interface IBusScheduleService {
	List<BusSchedule> getBusSchedule(String fromLocation, String toLocation, Date date);
   public BusSchedule addBusSchedule(BusSchedule busSchedule);
	
	public Optional<BusSchedule> viewBusSchedule(String scheduleId );
	
	public void deleteBusSchedule(String scheduleId);
	
	public List<BusSchedule> viewBusSchedules();
}
