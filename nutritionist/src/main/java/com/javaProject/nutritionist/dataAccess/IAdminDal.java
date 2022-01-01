package com.javaProject.nutritionist.dataAccess;

import com.javaProject.nutritionist.Entities.Admin;

public interface IAdminDal {
	Admin getAdminInfoByIdentity(String NationalIdentity);
	Admin login(String nationalIdentity, String password);
}
