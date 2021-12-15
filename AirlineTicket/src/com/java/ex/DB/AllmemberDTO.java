package com.java.ex.DB;

public class AllmemberDTO {
	
	private String name;
	private String ID;
	private String HP;
	private String total_boarding;
	private int total_price;
	private String Mileage;
	
	public AllmemberDTO(String name, String ID, String HP,String total_boarding,int total_price, String Mileage) {
		
		this.name = name;
		this.ID = ID;
		this.HP =HP;
		this.total_boarding = total_boarding;
		this.total_price = total_price;
		this.Mileage = Mileage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHP() {
		return HP;
	}

	public void setHP(String hP) {
		HP = hP;
	}

	public String getTotal_boarding() {
		return total_boarding;
	}

	public void setTotal_boarding(String total_boarding) {
		this.total_boarding = total_boarding;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getMileage() {
		return Mileage;
	}

	public void setMileage(String mileage) {
		Mileage = mileage;
	}


}
