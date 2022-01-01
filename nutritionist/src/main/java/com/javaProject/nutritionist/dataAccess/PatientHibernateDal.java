package com.javaProject.nutritionist.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Patient;

@Repository
public class PatientHibernateDal implements IPatientDal{
	
	private EntityManager entityManager;
	
	@Autowired
	public PatientHibernateDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void addPatient(Patient patient) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(patient);
		
	}

	@Override
	@Transactional
	public void deletePatient(String nationalIdentity) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Patient where NationalIdentity = '" + nationalIdentity + "'";
		Patient patient = session.createQuery(sql, Patient.class).getSingleResult();
		session.delete(patient);
	}

	@Override
	@Transactional
	public void changeDiet(String nationalIdentity, String newDiet) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Patient where NationalIdentity = '" + nationalIdentity + "'";
		Patient patient = session.createQuery(sql, Patient.class).getSingleResult();
		patient.setDiet(newDiet);
		session.saveOrUpdate(patient);
		
	}

	@Override
	@Transactional
	public List<Patient> getPatientsForNutritionist(String nutritionistIdentity) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Patient where NutritionistNationalIdentity = '" + nutritionistIdentity + "'";
		List<Patient> patients = session.createQuery(sql, Patient.class).getResultList();
		return patients;
	}

	@Override
	@Transactional
	public Patient getPatient(String nationalIdentity) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Patient where NationalIdentity = '" + nationalIdentity + "'";
		Patient patient = session.createQuery(sql, Patient.class).getSingleResult();
		return patient;
	} 
	
	@Override
	@Transactional
	public void changePatientPassword(Patient patient) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(patient);
		
	}

	@Override
	@Transactional
	public Patient login(String nationalIdentity, String Password) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Patient where NationalIdentity = '" + nationalIdentity + "' and Password = '" + Password + "'";
		Patient patient = session.createQuery(sql, Patient.class).getSingleResult();
		return patient;
	}

}
