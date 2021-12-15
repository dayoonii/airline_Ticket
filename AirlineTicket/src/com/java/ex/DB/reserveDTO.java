package com.java.ex.DB;

import java.sql.Date;
import java.sql.Time;

public class reserveDTO {
	

	private String reserve_id;
	private String name;
	private Date departdate;
	private Time departTime;
	private String depart;
	private String arrive;
	private String seatLevel;
	private String baggage;
	private String meal;

	public reserveDTO(String reserve_id, String name, Date depardate, Time departTime,
			String depart, String arrive, String seatLevel, String baggage, String meal) {
		
		this.reserve_id=reserve_id;
		this.name=name;
		this.departdate = depardate;
		this.departTime=departTime;
		this.depart=depart;
		this.arrive = arrive;
		this.seatLevel=seatLevel;
		this.baggage=baggage;
		this.meal=meal;
	}

	public String getReserve_id() {
		return reserve_id;
	}

	public void setReserve_id(String reserve_id) {
		this.reserve_id = reserve_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDepartdate() {
		return departdate;
	}

	public void setDepartdate(Date departdate) {
		this.departdate = departdate;
	}

	public Time getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Time departTime) {
		this.departTime = departTime;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public String getSeatLevel() {
		return seatLevel;
	}

	public void setSeatLevel(String seatLevel) {
		this.seatLevel = seatLevel;
	}

	public String getBaggage() {
		return baggage;
	}

	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}


	

}
