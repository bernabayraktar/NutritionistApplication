package com.javaProject.nutritionist.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Patient;
import com.javaProject.nutritionist.dataAccess.IPatientDal;

@Service
public class PatientManager implements IPatientService{
	
	private IPatientDal patientDal;
	
	@Autowired
	public PatientManager(IPatientDal patientDal) {
		this.patientDal = patientDal;
	}

	@Override
	@Transactional
	public void addPatient(Patient patient) {
		patientDal.addPatient(patient);
		
	}

	@Override
	@Transactional
	public void deletePatient(String nationalIdentity) {
		patientDal.deletePatient(nationalIdentity);
		
	}

	@Override
	@Transactional
	public void changeDiet(String nationalIdentity, String newDiet) {
		patientDal.changeDiet(nationalIdentity, newDiet);
		
	}

	@Override
	@Transactional
	public List<Patient> getPatientsForNutritionist(String nutritionistIdentity) {
		return patientDal.getPatientsForNutritionist(nutritionistIdentity);
	}

	@Override
	@Transactional
	public Patient getPatient(String nationalIdentity) {
		return patientDal.getPatient(nationalIdentity);
	}

	@Override
	@Transactional
	public void changePatientPassword(Patient patient) {
		this.patientDal.changePatientPassword(patient);
		
	}

	@Override
	@Transactional
	public Patient login(String nationalIdentity, String Password) {
		return this.patientDal.login(nationalIdentity, Password);
	}

}
