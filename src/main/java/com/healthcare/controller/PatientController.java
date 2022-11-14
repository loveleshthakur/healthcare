package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.entity.Patient;
import com.healthcare.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService  service;
	
	@PostMapping("/patient")
    private int savePatient(@RequestBody Patient patient) {
		service.saveOrUpdate(patient);
        return patient.getId();
    }


}
