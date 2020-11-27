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

import com.capg.brs.dto.BusDTO;
import com.capg.brs.service.BusServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/buses")
public class BusController {

	
	@Autowired
	BusServiceImpl busService;
	
	@PostMapping("/addBus")
	public ResponseEntity<BusDTO> addBus(@Valid @RequestBody BusDTO bus) {
		busService.addBus(bus);
		return new ResponseEntity<BusDTO>(bus, HttpStatus.CREATED);
	}
	
	@GetMapping("/{busId}")
	public ResponseEntity<BusDTO> getBusById(@PathVariable Long busId) {

		BusDTO b = busService.getBusById(busId);

		return new ResponseEntity<BusDTO>(b, HttpStatus.OK);
	}
	
	@GetMapping("/allBuses")
	public ResponseEntity<List<BusDTO>> getAllBuses() {
		List<BusDTO> allBuses = busService.getAll();
		return new ResponseEntity<List<BusDTO>>(allBuses, HttpStatus.OK);
	}
	
	@DeleteMapping("/{busId}")
	public ResponseEntity<BusDTO> deleteBus(@Valid @PathVariable long busId) {
		busService.deleteBus(busId);
		return new ResponseEntity<BusDTO>(HttpStatus.OK);

	}
}
