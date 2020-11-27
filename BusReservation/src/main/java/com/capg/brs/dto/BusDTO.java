package com.capg.brs.dto;

public class BusDTO {
	
		private Long busId;
		private String busOperator;
		private String busType;
		private int seatCapacity;
		public Long getBusId() {
			return busId;
		}
		public void setBusId(Long busId) {
			this.busId = busId;
		}
		public String getBusOperator() {
			return busOperator;
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
