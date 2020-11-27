package com.capg.brs.service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.brs.dto.BusScheduleDTO;
import com.capg.brs.exceptions.ScheduleDoesNotExistsException;
import com.capg.brs.repository.IBusScheduleRepository;


@Service
public class BusScheduleServiceImpl {
	@Autowired
	IBusScheduleRepository scheduleRepository;
	
	public List<BusScheduleDTO> getBusSchedule(String fromLocation, String toLocation, Date date) {
		List<BusScheduleDTO> availableBuses = new ArrayList<>();
		// Storing all scheduled flights data
		List<BusScheduleDTO> busList = scheduleRepository.findAll();
		// Filtering results with given input
		for (BusScheduleDTO busRoute : busList)
			if (busRoute.getSource().getBusStopLocation().equalsIgnoreCase(fromLocation)
					&& busRoute.getDestination().getBusStopLocation().equalsIgnoreCase(toLocation)
					&& busRoute.getDepartureTime().toLocalDate().equals(date.toLocalDate())) {
				availableBuses.add(busRoute);
			}

		return availableBuses;

	}	
		
	public BusScheduleDTO addBusSchedule(@Valid BusScheduleDTO schedule)
    {
		 return scheduleRepository.save(schedule);
	}
		    	
	public List<BusScheduleDTO> viewAllBusSchedules()
	 {	
		 return scheduleRepository.findAll();
	 }
	
	public BusScheduleDTO viewBusScheduleById(String scheduleId) {
		if (!scheduleRepository.existsById(scheduleId)) {
			throw new ScheduleDoesNotExistsException(" schedule not found");
		}
		 return scheduleRepository.getSchedule(scheduleId);
	}
		  
	public void deleteBusSchedule(String scheduleId) {
		if (!scheduleRepository.existsById(scheduleId)) {
			throw new ScheduleDoesNotExistsException(" schedule with "+scheduleId+"is not found");
		}
		scheduleRepository.deleteById(scheduleId);	
	 }
	
	
	
	
	
	
	
	
	


	
	

}
