package com.healthcare.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.healthcare.entity.Address;
import com.healthcare.entity.GovernmentIdentity;
import com.healthcare.entity.Patient;
import com.healthcare.entity.Phone;
import com.healthcare.healthcare.HealthcareApplicationTests;
import com.healthcare.repository.PatientRepository;
import com.healthcare.service.PatientService;

public class PatientControllerTest extends HealthcareApplicationTests{

	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@InjectMocks
	@Autowired
	PatientController controller;
	
	@Mock
	@Autowired 
	PatientService service;
	
	@Mock
	@Autowired 
	PatientRepository patientRepository;

	private MockMvc mockMvc;

	private Patient patient;

	private ArrayList<Patient> patients;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
		 GovernmentIdentity govtId;
			patient = new Patient();
			govtId = new  GovernmentIdentity();
			
			govtId.setId(1);
			govtId.setIdentityType("AADHAR");
			
			String identityNo= "812381238123";
			govtId.setIdentityNo(identityNo);
			
			patient.setPatientId(1);
			patient.setName("Anand");
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
	public void testSavePatient() {

		int actual =controller.savePatient(patient);
		assertEquals(1, actual);
	}

	@Test
	public void testGetAllPatient() throws Exception {
		
		mockMvc.perform(get("/patient")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
		controller.savePatient(patient);
		controller.getAllPatient();
		
System.out.println(controller.getAllPatient());
		
		
		
	
	}

	@Test
	public void testGetPatient() throws Exception {
		
				
		Mockito.when(controller.getPatient(1)).thenReturn(patient);
		Patient patientResult = controller.getPatient(1);
		assertNotNull(patientResult);
		System.out.println(">>>>>>>>>>>>>>>>>> "+patientResult);
		assertEquals("Anand", patientResult.getName());
		assertEquals(8123792427L, patientResult.getPhone().iterator().next().getPhoenumber());
	
	}
	

	@Test
	public void testFindPatientByName() {
		
		String name="Anand";
		Mockito.when(controller.findPatientByName(name)).thenReturn(patients);
		List<Patient> patientResult = controller.findPatientByName(name);
		
		assertEquals(name, patientResult.iterator().next().getName());
		
	}

	@Test
	public void testFindPatientByGovtId() {
		String name="Anand";
		String identityNo="812381238123";
		Mockito.when(controller.findPatientByGovtId(identityNo)).thenReturn(patients);
		List<Patient> patientResult = controller.findPatientByGovtId(identityNo);
		
		assertEquals(name, patientResult.iterator().next().getName());
	}

	@Test
	public void testDeletePatient() {

      int id=1;
		
		String expected="Patient with Id "+id +" is deleted successfully";
		Mockito.when(controller.deletePatient(1)).thenReturn(expected);
		String actual = controller.deletePatient(1);
		 assertEquals(expected, actual);
	}

}
