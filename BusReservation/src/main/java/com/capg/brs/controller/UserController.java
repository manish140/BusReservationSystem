package com.capg.brs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.dto.UserDTO;
import com.capg.brs.exceptions.UserNotFoundException;
import com.capg.brs.service.IUserService;


@RestController
@RequestMapping("/Bus")
@CrossOrigin("http://localhost:4200")

public class UserController {
	@Autowired
	private IUserService service;
	
	
	
	@PostMapping(path="/create")
	public ResponseEntity<String> register( UserDTO user ){
			if(user.getPassword().equals(user.getConfirmpassword())) {
				service.register(user);
				return new ResponseEntity<String>("Account created successfully",HttpStatus.OK);
				 
			}
			else {
				return new ResponseEntity<String>("Please check your details",HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			
		}
	@GetMapping("/userlogin/{userId}/{password}")
	public ResponseEntity<UserDTO> userLogin(@PathVariable("userId") int userId,@PathVariable("password") String password)
	{
		
		Optional<UserDTO> login=service.userLogin(userId, password);
		if(login==null)
		{
			throw new UserNotFoundException("User does not exist");
		}
		else
		{
			return new ResponseEntity<UserDTO>(HttpStatus.OK);
		}
		
	}
}