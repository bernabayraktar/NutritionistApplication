package com.javaProject.nutritionist.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaProject.nutritionist.Entities.Nutritionist;
import com.javaProject.nutritionist.dataAccess.INutritionistDal;

@Service
public class NutritionistManager implements INutritionistService{
	
	private INutritionistDal nutritionistDal;
	
	
	@Autowired
	public NutritionistManager(INutritionistDal nutritionistDal) {
		this.nutritionistDal = nutritionistDal;
	}

	@Override
	@Transactional
	public void addNutritionist(Nutritionist nutritionist) {
		this.nutritionistDal.addNutritionist(nutritionist);
		
	}

	@Override
	@Transactional
	public void deleteNutritionist(String nationalIdentity) {
		this.nutritionistDal.deleteNutritionist(nationalIdentity);
		
	}

	@Override
	@Transactional
	public Nutritionist getNutritionist(String nationalIdentity) {
		return this.nutritionistDal.getNutritionist(nationalIdentity);
	}

	@Override
	@Transactional
	public Nutritionist login(String nationalIdentity, String password) {
		return this.nutritionistDal.login(nationalIdentity, password);
	}

}
