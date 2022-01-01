package com.javaProject.nutritionist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaProject.nutritionist.Entities.Nutritionist;
import com.javaProject.nutritionist.business.INutritionistService;

@RestController
@RequestMapping("/nutritionist")
public class NutritionistController {
	private INutritionistService nutritionistService;
	 
	@Autowired
	public NutritionistController(INutritionistService nutritionistService) {
		this.nutritionistService = nutritionistService;
	}
	
	
	@PostMapping("/addNutritionist")
	public void addNutritionist(@RequestBody Nutritionist nutritionist) {
		this.nutritionistService.addNutritionist(nutritionist);
	}
	
	@PostMapping("/deleteNutritionist")
	public void deleteNutritionist(@RequestBody String nationalIdentity) {
		this.nutritionistService.deleteNutritionist(nationalIdentity);
	}
	
	@GetMapping("/{nationalIdentity}")
	public Nutritionist getNutritionist(@PathVariable String nationalIdentity) {
		return this.nutritionistService.getNutritionist(nationalIdentity);
	}
	
	@GetMapping("/login/{info}")
	public Nutritionist login(@PathVariable String info) {
		String[] infos = info.split("_");
		return this.nutritionistService.login(infos[0], infos[1]);
	}
	
	

}
