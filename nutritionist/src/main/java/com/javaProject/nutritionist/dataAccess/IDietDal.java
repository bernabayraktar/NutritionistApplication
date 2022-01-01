package com.javaProject.nutritionist.dataAccess;

import com.javaProject.nutritionist.Entities.Diet;

public interface IDietDal {
	Diet getDiet(String dietName);
}
