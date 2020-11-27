package com.capg.brs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="passenger8")
public class Passenger {

	@Id
	@Column(name = "passenger_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerseq")
	@SequenceGenerator(name = "passengerseq", sequenceName = "PASSENGER_ID", allocationSize = 1)
	private long passengerId;
	@Column(name = "passenger_name")
	private String name;
	@Column(name = "passenger_age")
	private int age;
	@Column(name = "passenger_gender")
	private char gender;
	@Column(name = "passenger_phone")
	private long phone;

	public Passenger() {
		super();
	}

	public Passenger(long passengerId, String name, int age, char gender, long phone) {
		this.passengerId = passengerId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone; 
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}
