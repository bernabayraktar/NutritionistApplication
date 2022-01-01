package com.javaProject.nutritionist.business;

import com.javaProject.nutritionist.Entities.Admin;

public interface IAdminService {
	Admin getAdminInfoByIdentity(String NationalIdentity);
	Admin login(String nationalIdentity, String password);
}
