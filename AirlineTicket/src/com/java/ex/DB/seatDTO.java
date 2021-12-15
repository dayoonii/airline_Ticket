package com.java.ex.DB;

public class seatDTO {
	
	private String seatLevel;
	private String seatNum;
	private int seatPrice;
	
	public seatDTO(String seatLevel, String seatNum, int seatPrice) {

	this.seatLevel=seatLevel;
	this.seatNum=seatNum;
	this.seatPrice=seatPrice;
}

	public String getSeatLevel() {
		return seatLevel;
	}

	public void setSeatLevel(String seatLevel) {
		this.seatLevel = seatLevel;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public int getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}
}
