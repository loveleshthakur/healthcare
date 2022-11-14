package com.healthcare.repository;
import org.springframework.data.repository.CrudRepository;

import com.healthcare.entity.Patient;

public interface PatientRepository extends  CrudRepository<Patient, Integer> {

}
