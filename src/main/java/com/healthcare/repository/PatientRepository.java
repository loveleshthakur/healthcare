package com.healthcare.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthcare.entity.GovernmentIdentity;
import com.healthcare.entity.Patient;

public interface PatientRepository extends  JpaRepository<Patient, Integer> {

	@Query("SELECT p FROM Patient p WHERE LOWER(p.name) = ?1 ")
	public  List <Patient> findPatientByName(String name);
/*	
	SELECT * FROM development.patient 
	where patient_id in (select patient_patient_id from patient_govt_id where govt_id_id in 
	(SELECT id FROM development.government_identifiers where identity_no ='812381238123'
	 ))
	*/
	//@Query(value = "SELECT p FROM Patient p join GovernmentIdentity gi on gi.identityNo =?1 AND p.id=gi.patientId ",nativeQuery = false)
	
	@Query("SELECT p FROM Patient p where p.patientId in (select gi.patientId from GovernmentIdentity gi where gi.patientId = :id ) ")
	
	public List<Patient> findPatientByGovtId(@Param("id") String id);
}
