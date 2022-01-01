package com.javaProject.nutritionist.dataAccess;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Admin;


@Repository
public class AdminHibernateDal implements IAdminDal{
	
	private EntityManager entityManager;
	
	@Autowired
	public AdminHibernateDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Admin getAdminInfoByIdentity(String NationalIdentity) {
		Session session = entityManager.unwrap(Session.class);
		String sqlQuery = "from Admin where NationalIdentity = '" + NationalIdentity + "'";
		Admin admin = session.createQuery(sqlQuery, Admin.class).getSingleResult();
		return admin;
	}

	@Override
	@Transactional
	public Admin login(String nationalIdentity, String password) {
		Session session = entityManager.unwrap(Session.class);
		String sql = "from Admin where NationalIdentity = '" + nationalIdentity + "' and Password = '" + password + "'";
		Admin admin = session.createQuery(sql, Admin.class).getSingleResult();
		return admin;
	}
	
	

}
