package com.capg.brs.repository;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.dto.BusScheduleDTO;
import com.capg.brs.entity.BusSchedule;
import com.capg.brs.entity.BusStop;

@Repository
public interface IBusScheduleRepository extends JpaRepository<BusScheduleDTO,String>{


  @Query("select u from BusSchedule u where sheduleId=?1")
  public BusScheduleDTO getSchedule(String scheduleId);
  
  
  @Query("select r from BusSchedule r where r.source=?1 and r.destination=?2 and date(r.departureTime)=?3")
	List<BusSchedule> getBusSchedule(BusStop fromLocation, BusStop toLocation, Date date);


@SuppressWarnings("unchecked")
public BusScheduleDTO save(@Valid BusScheduleDTO schedule);
}
