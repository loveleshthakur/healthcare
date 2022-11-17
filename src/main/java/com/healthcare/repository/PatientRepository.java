package com.healthcare.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.entity.Patient;

public interface PatientRepository extends  JpaRepository<Patient, Integer> {

	@Query("SELECT p FROM Patient p WHERE LOWER(p.name) = ?1 ")
	public  List <Patient> findPatientByName(String name);

	@Query(value = "SELECT p.patient_Id , p.dob , p.name FROM patient p , Government_Identity gi where  gi.identity_No =?1 AND p.patient_Id=gi.patient_Id ",nativeQuery = true)
		public List<Patient> findPatientByGovtId(String id);
}
