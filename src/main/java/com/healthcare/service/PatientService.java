package com.healthcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.Patient;
import com.healthcare.repository.PatientRepository;
@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository ;
	/*@author Lovelesh
	 *@param  
	 */
	public void saveOrUpdate(Patient patient) {
		patientRepository.save(patient);
    }

	public List<Patient> getAllPatient() {
		 
		return patientRepository.findAll();
	}

	public Patient findPatient(int id) {
		return patientRepository.findById(id).get();
	}
	public List<Patient> findByName(String name) {
		List <Patient>  patientList = new ArrayList<Patient>();
		return patientRepository . findPatientByName(name);
}

	public List<Patient> findByGovtId(String id) {
		return patientRepository . findPatientByGovtId(id);
	}
}
