package com.java.ex.DB;

public class addserviceDTO {
	
	private String meal;
	private String baggage;
	private int add_price;
	private String fare;
	
	public addserviceDTO(String meal, String baggage, int add_price, String fare) {
		this.meal = meal;
		this.baggage=baggage;
		this.add_price=add_price;
		this.fare=fare;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getBaggage() {
		return baggage;
	}

	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}

	public int getAdd_price() {
		return add_price;
	}

	public void setAdd_price(int add_price) {
		this.add_price = add_price;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

}
