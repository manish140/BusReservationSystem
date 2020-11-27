package com.capg.brs.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.brs.dto.UserDTO;
@Service
@Transactional
public interface IUserService {

	public Optional<UserDTO> userLogin(int userId,String password);
	
	public String register(UserDTO user);
}
