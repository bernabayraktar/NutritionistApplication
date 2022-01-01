package com.javaProject.nutritionist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaProject.nutritionist.Entities.Admin;
import com.javaProject.nutritionist.business.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private IAdminService adminService;
	
	
	@Autowired
	public AdminController(IAdminService adminService) {
		this.adminService = adminService;
	}



	@GetMapping("/{NationalIdentity}")
	public Admin get(@PathVariable String NationalIdentity) {
		return this.adminService.getAdminInfoByIdentity(NationalIdentity);
	}
	
	@GetMapping("/login/{info}")
	public Admin login(@PathVariable String info) {
		String[] infos = info.split("_");
		return this.adminService.login(infos[0], infos[1]);
	}

}
