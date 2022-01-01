package com.javaProject.nutritionist.business;

import com.javaProject.nutritionist.Entities.Nutritionist;

public interface INutritionistService {
	void addNutritionist(Nutritionist nutritionist);
	void deleteNutritionist(String nationalIdentity);
	Nutritionist getNutritionist(String nationalIdentity);
	Nutritionist login(String nationalIdentity, String password);
}
