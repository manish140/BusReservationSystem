package com.capg.brs.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.brs.dto.BusScheduleDTO;
import com.capg.brs.service.BusScheduleServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/schedules")
public class BusScheduleController {
	
	@Autowired
	BusScheduleServiceImpl busSchedule;
	
	@PostMapping("/addSchedule")
	public ResponseEntity<BusScheduleDTO> addBusSchedule(@Valid @RequestBody BusScheduleDTO schedule) {
		busSchedule.addBusSchedule(schedule);
		return new ResponseEntity<BusScheduleDTO>(schedule, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{scheduleId}")
	public ResponseEntity<BusScheduleDTO> viewBusScheduleById(@PathVariable String scheduleId) {

		BusScheduleDTO s = busSchedule.viewBusScheduleById(scheduleId);

		return new ResponseEntity<BusScheduleDTO>(s, HttpStatus.OK);
	}
	
	@GetMapping("/allSchedules")
	public ResponseEntity<List<BusScheduleDTO>> viewAllBusSchedules() {
		List<BusScheduleDTO> allSchedules = busSchedule.viewAllBusSchedules();
		return new ResponseEntity<List<BusScheduleDTO>>(allSchedules, HttpStatus.OK);
		}
	
	@DeleteMapping("/{scheduleId}")
	public ResponseEntity<BusScheduleDTO> deleteSchedule(@Valid @PathVariable String scheduleId) {
		busSchedule.deleteBusSchedule(scheduleId);
		return new ResponseEntity<BusScheduleDTO>(HttpStatus.OK);

	}
}
