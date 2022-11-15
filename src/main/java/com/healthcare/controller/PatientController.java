package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.entity.GovernmentIdentity;
import com.healthcare.entity.Patient;
import com.healthcare.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService  service;
	
	@PostMapping("/patient")
    private int savePatient(@RequestBody Patient patient) {
		service.saveOrUpdate(patient);
        return patient.getPatientId();
    }
    @GetMapping("/patient")
    private List <Patient> getAllPatient() 
    {
		return service.getAllPatient();
    }
    
    @GetMapping ("/patient/{id}")
    private Patient getPatient(@PathVariable("id") int id)
    {
    	return service.findPatient(id);
    }
    @GetMapping ("/patient/name/{name}")
    private  List <Patient> findPatientByName(@PathVariable("name") String name) {
		return service.findByName(name.toLowerCase());
	}
    @GetMapping ("/patient/govtid/{id}")
    private  List <Patient> findPatientByGovtId(@PathVariable("id") String id) {
		return service.findByGovtId(id.toLowerCase());
	}
}
