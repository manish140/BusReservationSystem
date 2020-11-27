package com.capg.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.dto.UserDTO;
import com.capg.brs.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{
	@Query("SELECT userId FROM User u WHERE userId = ?1")
	Integer findUserByUserId(User userId);

	void save(UserDTO user);





}