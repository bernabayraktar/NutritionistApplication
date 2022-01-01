package com.javaProject.nutritionist.dataAccess;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Diet;

@Repository
public class DietHibernateDal implements IDietDal{
	private EntityManager entityManager;
	
	
	@Autowired
	public DietHibernateDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	@Transactional
	public Diet getDiet(String dietName) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Diet where Diet = '" + dietName + "'";
		Diet diet = session.createQuery(sql, Diet.class).getSingleResult();
		return diet;
	}
}
