package com.javaProject.nutritionist.Entities;

import javax.persistence.*;

@Entity
@Table(name = "nutritionisttbl")
public class Nutritionist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Nationalidentity")
	private String NationalIdentity;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Surname")
	private String Surname;
	
	@Column(name = "Password")
	private String Password;
	
	
	public Nutritionist(int id, String nationalIdentity, String name, String surname, String password) {
		this.id = id;
		NationalIdentity = nationalIdentity;
		Name = name;
		Surname = surname;
		Password = password;
	}
	
	public Nutritionist() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNationalIdentity() {
		return NationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		NationalIdentity = nationalIdentity;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	
}
