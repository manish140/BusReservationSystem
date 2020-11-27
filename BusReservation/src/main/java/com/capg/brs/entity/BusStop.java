package com.capg.brs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="busstop8")
public class BusStop {

	@Id
	private String busStopCode;
	private String busStopName;
	private String busStopLocation;
	
	public String getBusStopName() {
		return busStopName;
	}
	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}
	public String getBusStopLocation() {
		return busStopLocation;
	}
	public void setBusStopLocation(String busStopLocation) {
		this.busStopLocation = busStopLocation;
	}
	public String getBusStopCode() {
		return busStopCode;
	}
	public void setBusStopCode(String busStopCode) {
		this.busStopCode = busStopCode;
	}
}
