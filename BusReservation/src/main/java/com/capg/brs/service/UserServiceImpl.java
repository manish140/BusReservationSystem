package com.capg.brs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.dto.UserDTO;
import com.capg.brs.entity.User;
import com.capg.brs.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository dao;
	

	public static final User IUserRepository = new User();

	@Override
	public String register(UserDTO user) {
		
		 dao.save(user);
		 return "account successfully created";
	}

	
	public Optional<UserDTO> userLogin(int userId,String password)
	{
		
		Optional<User> result;
		result=dao.findById(userId);
		if(result!=null)
		{
			User user=dao.getOne(userId);
		
			String pass=user.getPassword();
			if(pass.equals(password))
			{
				return Optional.empty();
			}
			else
			{
				return Optional.empty();
			}
		}
		else
		{
			return Optional.empty();
		}
	
}

	
}
