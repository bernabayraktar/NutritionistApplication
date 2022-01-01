package com.javaProject.nutritionist.dataAccess;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Nutritionist;

@Repository
public class NutritionistHibernateDal implements INutritionistDal{
	
	private EntityManager entityManager;
	
	@Autowired
	public NutritionistHibernateDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void addNutritionist(Nutritionist nutritionist) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(nutritionist);
		
	}

	@Override
	@Transactional
	public void deleteNutritionist(String nationalIdentity) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Nutritionist where NationalIdentity = '" + nationalIdentity + "'";
		Nutritionist nutritionist = session.createQuery(sql, Nutritionist.class).getSingleResult();
		session.delete(nutritionist);
		
	}

	@Override
	@Transactional
	public Nutritionist getNutritionist(String nationalIdentity) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Nutritionist where NationalIdentity = '" + nationalIdentity + "'";
		Nutritionist nutritionist = session.createQuery(sql, Nutritionist.class).getSingleResult();
		return nutritionist;
	}

	@Override
	@Transactional
	public Nutritionist login(String nationalIdentity, String password) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Nutritionist where NationalIdentity = '" + nationalIdentity + "' and Password = '" + password + "'";
		Nutritionist nutritionist = session.createQuery(sql, Nutritionist.class).getSingleResult();
		return nutritionist;
	}

}
