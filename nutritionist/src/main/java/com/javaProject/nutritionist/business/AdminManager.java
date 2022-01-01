package com.javaProject.nutritionist.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Admin;
import com.javaProject.nutritionist.dataAccess.IAdminDal;

@Service
public class AdminManager implements IAdminService{
	
	private IAdminDal adminDal;
	
	
	
	@Autowired
	public AdminManager(IAdminDal adminDal) {
		this.adminDal = adminDal;
	}




	@Override
	@Transactional
	public Admin getAdminInfoByIdentity(String NationalIdentity) {
		return this.adminDal.getAdminInfoByIdentity(NationalIdentity);
	}




	@Override
	@Transactional
	public Admin login(String nationalIdentity, String password) {
		return this.adminDal.login(nationalIdentity, password);
	}

}
