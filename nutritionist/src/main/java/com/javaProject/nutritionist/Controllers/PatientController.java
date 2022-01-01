package com.javaProject.nutritionist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaProject.nutritionist.Entities.Patient;
import com.javaProject.nutritionist.business.IPatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	private IPatientService patientService;
	
	@Autowired
	public PatientController(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping("/add")
	public void addPatient(@RequestBody Patient patient) {
		patientService.addPatient(patient);
	}
	
	@PostMapping("/delete")
	public void deletePatient(@RequestBody String nationalIdentity) {
		patientService.deletePatient(nationalIdentity);
	}
	
	@PostMapping("/changeDiet")
	public void changeDiet(@RequestBody String info) {
		String[] infos = info.split("_");
		String nationalIdentity = infos[0];
		String newDiet = infos[1];
		patientService.changeDiet(nationalIdentity, newDiet);
	}
	
	@GetMapping("/getAllPatients/{nutritionistIdentity}")
	public List<Patient> getPatientsForNutritionist(@PathVariable String nutritionistIdentity){
		return patientService.getPatientsForNutritionist(nutritionistIdentity);
	}
	
	@GetMapping("/getPatient/{nationalIdentity}")
	public Patient getPatient(@PathVariable String nationalIdentity) {
		return patientService.getPatient(nationalIdentity);
	}
	
	@PostMapping("/changePassword")
	public void changePatientPassword(@RequestBody Patient patient) {
		this.patientService.changePatientPassword(patient);
	}
	
	@GetMapping("/login/{info}")
	public Patient login(@PathVariable String info) {
		String[] infos = info.split("_");
		String nationalIdentity = infos[0];
		String Password = infos[1];
		return patientService.login(nationalIdentity, Password);
		
	}
	
	
	
	

}
