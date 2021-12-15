package com.java.ex.DB;

public class add_passengerDTO {
	private String add_name;
	private String add_birth;
	private String add_hp;
	private String add_email;
	
	public add_passengerDTO(String add_name, String add_birth, String add_hp, String add_email) {
		this.add_birth = add_birth;
		this.add_name = add_name;
		this.add_hp = add_hp;
		this.add_email = add_email;
		
	}

	public String getAdd_name() {
		return add_name;
	}

	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}

	public String getAdd_birth() {
		return add_birth;
	}

	public void setAdd_birth(String add_birth) {
		this.add_birth = add_birth;
	}

	public String getAdd_hp() {
		return add_hp;
	}

	public void setAdd_hp(String add_hp) {
		this.add_hp = add_hp;
	}

	public String getAdd_email() {
		return add_email;
	}

	public void setAdd_email(String add_email) {
		this.add_email = add_email;
	}

	@Override
	public String toString() {
		return "add_passengerDTO [add_name=" + add_name + ", add_birth=" + add_birth + ", add_hp=" + add_hp
				+ ", add_email=" + add_email + "]";
	}

	
}
