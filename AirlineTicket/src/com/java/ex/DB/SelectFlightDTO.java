package com.java.ex.DB;

public class SelectFlightDTO {
	private String departTime;
	private String arriveTime;
	private String seatLevel;
	private String fare;
	
	public SelectFlightDTO(String departTime, String arriveTime, String seatLevel, String fare) {
		
		this.departTime=departTime;
		this.arriveTime=arriveTime;
		this.seatLevel=seatLevel;
		this.fare = fare;
		
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getSeatLevel() {
		return seatLevel;
	}

	public void setSeatLevel(String seatLevel) {
		this.seatLevel = seatLevel;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}
	
	
	

}
