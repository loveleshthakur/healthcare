package com.healthcare.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.healthcare.entity.Address;
import com.healthcare.entity.GovernmentIdentity;
import com.healthcare.entity.Patient;
import com.healthcare.entity.Phone;
import com.healthcare.repository.PatientRepository;

public class PatientServiceTest {


	@InjectMocks
	@Autowired
	PatientService service;
	
	@Mock
	@Autowired 
	PatientRepository patientRepository;
	
	private Patient patient;
	private List<Patient> patients;
	private GovernmentIdentity govtId;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		 GovernmentIdentity govtId;
			patient = new Patient();
			govtId = new  GovernmentIdentity();
			
			govtId.setId(1);
			govtId.setIdentityType("AADHAR");
			
			String identityNo= "812381238123";
			govtId.setIdentityNo(identityNo);
			
			patient.setPatientId(1);
			patient.setName("Hemanth");
			Set<Phone> phone= new HashSet<Phone>();
			Phone phNo = new Phone();
			phNo.setId(100);
			phNo.setPhoenumber(8123792427L);
			phone.add(phNo );
			patient.setPhone(phone);
			Set<Address> addresses = new HashSet<Address>();
			Address address = new Address();
			address.setCity("Bangalore");
			address.setPin(560078);
			address.setState("Karnataka");
			address.setStreet("2nd main JP Nagar");
			
			addresses.add(address  );
			patient.setAddresses(addresses );

			Set<GovernmentIdentity> govtIds = new HashSet<GovernmentIdentity>();
			govtIds.add(govtId);
			patient.setGovtIds(govtIds);
			patients =new  ArrayList<Patient>();
			patients.add(patient);		
	}

	@Test
	public void testSaveOrUpdate() {
 
	Mockito.when(service.saveOrUpdate(patient)).thenReturn(patient);
	
	Patient patientResult = service.saveOrUpdate(patient );
	
	assertEquals("Hemanth", patientResult.getName());
	}

	@Test
	public void testGetAllPatient() {
		
		Mockito.when(service.getAllPatient()).thenReturn(patients);
		List<Patient> patientList = service.getAllPatient();
		assertEquals("Hemanth", patientList.get(0).getName());
	}

	@Test
	public void testFindPatient() {
		int id=1;
		service.saveOrUpdate(patient);
		/*
		 * Mockito.when(service.findPatient(id)).thenReturn(patient); Patient
		 * patientResult = service.findPatient(id);
		 */		
	}

	@Test
	public void testFindByName() {
		String name ="Hemanth";
		Mockito.when(service.findByName(name)).thenReturn(patients);
		
		List<Patient> patientResult = service.findByName(name);
		assertNotNull(patientResult);
		
	}

	@Test
	public void testFindByGovtId() {
		String govtId="812381238123";
		Mockito.when(service.findByGovtId(govtId)).thenReturn(patients);
		List<Patient> patientResult = service.findByGovtId(govtId);
	}

	@Test
	public void testDeletePatient() {
		int id=1;
		
		String expected="Patient with Id "+id +" is deleted successfully";
		
		String actual = service.deletePatient(1);
		 assertEquals(expected, actual);

	
	}

}
