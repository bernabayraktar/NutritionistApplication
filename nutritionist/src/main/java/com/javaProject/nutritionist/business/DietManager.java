package com.javaProject.nutritionist.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Diet;
import com.javaProject.nutritionist.dataAccess.IDietDal;

@Service
public class DietManager implements IDietService{
	
	private IDietDal dietDal;
	
	
	@Autowired
	public DietManager(IDietDal dietDal) {
		this.dietDal = dietDal;
	}



	@Override
	@Transactional
	public Diet getDiet(String dietName) {
		return dietDal.getDiet(dietName);
	}

}
