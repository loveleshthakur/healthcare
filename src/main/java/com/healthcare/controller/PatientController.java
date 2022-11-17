package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.entity.Patient;
import com.healthcare.service.PatientService;
/**
 * Patient Controller is the Rest controller API for performing 
 * operations like Save patient , read patient , update and delete patient
 * @author Lovelesh
 */
@RestController
public class PatientController {
	
	@Autowired
	PatientService  service;

	/**
	 * Save Patient method is used accept new patient and save the data in Patient repository.
	 * Patients are created by sending HTTP POST requests to the API. 
	 * The body of the request should contain a JSON object describing the patient to create 
	 * @param patient
	 * @return PatiendId  
	 */
	@PostMapping("/patient")
    public int savePatient(@RequestBody Patient patient) {
		service.saveOrUpdate(patient);
        return patient.getPatientId();
    }
	
	/**
	 * PatientList is fetched by sending HTTP GET request to APi. Example User should send the request to /patient
	 * @return List   - Retrieves all patient
	 */
    @GetMapping("/patient")
    public List <Patient> getAllPatient() 
    {
		return service.getAllPatient();
    }
    
    /**
     * Single Patient is fetched by sending HTTP GET request by passing patient Id.
     * Example - Http Get Request  and url  /patient/1
     * @param id
     * @return Patient
     */
    @GetMapping ("/patient/{id}")
    public Patient getPatient(@PathVariable("id") int id)
    {
    	return service.findPatient(id);
    }
    /**
     * Patient List is fetched by sending HTTP Get request to API by passing name as parameter
     * @param name - Name of the patient is provided
     * @return List of patient entity is fetched
     */
    @GetMapping ("/patient/name/{name}")
    public  List <Patient> findPatientByName(@PathVariable("name") String name) {
		return service.findByName(name.toLowerCase());
	}
    /**
     * Patient List is fetched by sending HTTP Get request to API by passing Government Identification number as parameter
     * @param id
     * @return Patient 
     */
    @GetMapping ("/patient/govtid/{id}")
    public  List <Patient> findPatientByGovtId(@PathVariable("id") String id) {
		return service.findByGovtId(id.toLowerCase());
	}
    
    /**
     * Http Delete reuest is sent Api by passing patient Id and record will be deleted from the Patient table
     * @param id
     */
    @DeleteMapping ("/patient/{id}")
    public String deletePatient(@PathVariable("id") int id)
    {
     return service.deletePatient(id);
     
    }
    
}
