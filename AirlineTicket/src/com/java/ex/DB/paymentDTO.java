package com.java.ex.DB;

public class paymentDTO {
	private String resreve_id;
	private String id;
	private String name;
	private String Flight_name;
	private String seatNum;
	private int total_price;

	public paymentDTO() {
		super();
	}

	public paymentDTO(String resreve_id, String id, String name, String flight_name, String seatNum,
			int total_price) {
		super();
		this.resreve_id = resreve_id;
		this.id = id;
		this.name = name;
		this.Flight_name = flight_name;
		this.seatNum = seatNum;
		this.total_price = total_price;
	}

	public String getResreve_id() {
		return resreve_id;
	}

	public void setResreve_id(String resreve_id) {
		this.resreve_id = resreve_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlight_name() {
		return Flight_name;
	}

	public void setFlight_name(String flight_name) {
		Flight_name = flight_name;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "paymentDTO [resreve_id=" + resreve_id + ", id=" + id + ", name=" + name + ", Flight_name=" + Flight_name
				+ ", seatNum=" + seatNum + ", total_price=" + total_price + "]";
	}

}
