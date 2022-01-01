package com.javaProject.nutritionist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaProject.nutritionist.Entities.Diet;
import com.javaProject.nutritionist.business.IDietService;

@RestController
@RequestMapping("/diet")
public class DietController {
	private IDietService dietService;
	
	@Autowired
	public DietController(IDietService dietService) {
		this.dietService = dietService;
	}
	
	@GetMapping("/{dietName}")
	public Diet getDiet(@PathVariable String dietName) {
		dietName = dietName.replace("-", " ");
		return this.dietService.getDiet(dietName);
	}
	
	

}
