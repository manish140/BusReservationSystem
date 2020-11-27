package com.capg.brs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="bus8")
@Entity
public class Bus {
	
	
	@Id
	private Long busId;
	private String busOperator;
	private String busType;
	private int seatCapacity;
	
	
	

	public String getBusOperator() {
		return busOperator;
	}
	
	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public void setBusOperator(String busOperator) {
		this.busOperator = busOperator;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
}
