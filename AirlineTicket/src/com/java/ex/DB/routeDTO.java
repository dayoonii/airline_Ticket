package com.java.ex.DB;

public class routeDTO {
	
	private String Flight_name;
	private String depart;
	private String arrive;
	private String departdate;
	private String departTime;
	private String arriveTime;
	private String totalTime;
	
	public routeDTO(String Flight_name, String depart, String arrive, String departdate, String departTime, String arriveTime, String totalTime) {
		
		this.Flight_name=Flight_name;
		this.depart=depart;
		this.arrive=arrive;
		this.departdate=departdate;
		this.departTime=departTime;
		this.arriveTime=arriveTime;
		this.totalTime=totalTime;
	}

	public String getFlight_name() {
		return Flight_name;
	}

	public void setFlight_name(String flight_name) {
		Flight_name = flight_name;
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

	public String getDepartdate() {
		return departdate;
	}

	public void setDepartdate(String departdate) {
		this.departdate = departdate;
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

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	@Override
	public String toString() {
		return "routeDTO [Flight_name=" + Flight_name + ", depart=" + depart + ", arrive=" + arrive + ", departdate="
				+ departdate + ", departTime=" + departTime + ", arriveTime=" + arriveTime + ", totalTime=" + totalTime
				+ "]";
	}
	
	
}


