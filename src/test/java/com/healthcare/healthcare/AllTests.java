package com.healthcare.healthcare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.healthcare.controller.PatientControllerTest;
import com.healthcare.service.PatientServiceTest;

@RunWith(Suite.class)
@SuiteClasses({PatientServiceTest.class,PatientControllerTest.class})
public class AllTests {}
