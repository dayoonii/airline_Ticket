package com.java.ex.DB;

public class PassengerDTO {
	
	private String name;
	private String id;
	private String pw;
	private String hp;
	private String email;
	private String address;
	private String nation;
	private String gender;
	
	public PassengerDTO(String name, String id, String pw, String hp, String email, 
			String address, String nation, String gender) {
		
		this.name=name;
		this.id=id;
		this.pw=pw;
		this.hp=hp;
		this.email=email;
		this.address=address;
		this.nation=nation;
		this.gender=gender;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	}
