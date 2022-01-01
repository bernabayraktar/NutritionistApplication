package com.javaProject.nutritionist.dataAccess;

import com.javaProject.nutritionist.Entities.Nutritionist;

public interface INutritionistDal {
	void addNutritionist(Nutritionist nutritionist);
	void deleteNutritionist(String nationalIdentity);
	Nutritionist getNutritionist(String nationalIdentity);
	Nutritionist login(String nationalIdentity, String password);
}
