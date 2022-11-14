package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.Patient;
import com.healthcare.repository.PatientRepository;
@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository ;
	
	public void saveOrUpdate(Patient patient) {
		patientRepository.save(patient);
    }
	
}
