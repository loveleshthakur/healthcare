package com.healthcare.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.Patient;
import com.healthcare.repository.PatientRepository;
/**
 * Patient Controller is the Rest controller API for performing 
 * operations like Save patient , read patient , update and delete patient.
 * 
 * @author Lovelesh
 *
 */
@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository ;
	/**
	 * Patient detail object is saved in the patient table , is Patient is existing patient then it will update the patient details.
	 * @param patient - Patient details are saved
	 */
	public Patient saveOrUpdate(Patient patient) {
	 return	patientRepository.save(patient);
    }

	/**
	 * Retrieves all the Patient records from Patient Data base
	 * @return List - All patient entities are fetched
	 */
	public List<Patient> getAllPatient() {
		 
		return patientRepository.findAll();
	}

	/**
	 * Retrieves Patient Entity based on Patient Id
	 * @param id -must not be null
	 * @return Patient Entity is returned 
	 */
	public Patient findPatient(int id) {
		return patientRepository.findById(id).get();
	}
	
	/**
	 * Finds users with provided name.
	 * @param name - Name of the patient is passed
	 * @return Patients - List of Patient Entity is fetched
	 */
	public List<Patient> findByName(String name) {
		return patientRepository . findPatientByName(name);
    }
/**
 * Retrieves patient list by providing government Identity numbers like  Aadhar , Pan etc
 * @param id - Identity number of government id
 * @return  List of Patient is fetched
 */
	public List<Patient> findByGovtId(String id) {
		
		 
		 return patientRepository . findPatientByGovtId(id);
	}

	public String deletePatient(int id) {
			 patientRepository.deleteById(id);
			 return "Patient with Id "+id +" is deleted successfully";
		 
	}
}
