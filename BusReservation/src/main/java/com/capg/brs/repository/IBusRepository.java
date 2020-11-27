package com.capg.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.dto.BusDTO;
import com.capg.brs.entity.Bus;


@Repository
public interface IBusRepository extends JpaRepository<BusDTO, Long> {



	@Query("select seatCapacity from Bus b where busId=?1")
	int findSeatCapacityByBusId(Integer busId);

	 @Query("SELECT b FROM Bus b WHERE busId = ?1")
	 public BusDTO getBus(Long busId);

	BusDTO save(Bus bus);
}
