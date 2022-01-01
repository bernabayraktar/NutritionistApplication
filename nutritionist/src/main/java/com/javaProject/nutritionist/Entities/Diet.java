package com.javaProject.nutritionist.Entities;

import javax.persistence.*;

@Entity
@Table(name = "diettbl")
public class Diet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Diet")
	private String Diet;
	
	@Column(name = "Monday")
	private String Monday;
	
	@Column(name = "Tuesday")
	private String Tuesday;
	
	@Column(name = "Wednesday")
	private String Wednesday;
	
	@Column(name = "Thursday")
	private String Thursday;
	
	@Column(name = "Friday")
	private String Friday;
	
	@Column(name = "Saturday")
	private String Saturday;
	
	@Column(name = "Sunday")
	private String Sunday;
	
	
	public Diet(int id, String diet, String monday, String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sunday) {
		super();
		this.id = id;
		Diet = diet;
		Monday = monday;
		Tuesday = tuesday;
		Wednesday = wednesday;
		Thursday = thursday;
		Friday = friday;
		Saturday = saturday;
		Sunday = sunday;
	}
	
	public Diet() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiet() {
		return Diet;
	}

	public void setDiet(String diet) {
		Diet = diet;
	}

	public String getMonday() {
		return Monday;
	}

	public void setMonday(String monday) {
		Monday = monday;
	}

	public String getTuesday() {
		return Tuesday;
	}

	public void setTuesday(String tuesday) {
		Tuesday = tuesday;
	}

	public String getWednesday() {
		return Wednesday;
	}

	public void setWednesday(String wednesday) {
		Wednesday = wednesday;
	}

	public String getThursday() {
		return Thursday;
	}

	public void setThursday(String thursday) {
		Thursday = thursday;
	}

	public String getFriday() {
		return Friday;
	}

	public void setFriday(String friday) {
		Friday = friday;
	}

	public String getSaturday() {
		return Saturday;
	}

	public void setSaturday(String saturday) {
		Saturday = saturday;
	}

	public String getSunday() {
		return Sunday;
	}

	public void setSunday(String sunday) {
		Sunday = sunday;
	}
	
	
	
	

}
