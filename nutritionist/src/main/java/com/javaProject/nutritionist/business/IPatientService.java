package com.javaProject.nutritionist.business;

import java.util.List;

import com.javaProject.nutritionist.Entities.Patient;

public interface IPatientService {
	void addPatient(Patient patient);
	void deletePatient(String nationalIdentity);
	void changeDiet(String nationalIdentity, String newDiet);
	List<Patient> getPatientsForNutritionist(String nutritionistIdentity);
	Patient getPatient(String nationalIdentity);
	void changePatientPassword(Patient patient);
	Patient login(String nationalIdentity, String Password);
}
