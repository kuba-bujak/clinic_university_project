package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.*;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.persistence.dao.impl.VisitDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.impl.DoctorServiceImpl;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import com.capgemini.wsb.service.impl.VisitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private VisitServiceImpl visitService;

    @Autowired
    private DoctorServiceImpl doctorService;

    @Transactional
    @Test
    public void findById() {
        PatientTO patientTO = patientService.findById(1L);

        assertEquals("Piotr", patientTO.getFirstName());
        assertEquals("Wisniewski", patientTO.getLastName());
    }
    @Transactional
    @Test
    public void addPatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("P001");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setHasInsurance(true);

        // when
        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        // then
        assertNotNull(savedPatientTO.getId());
        assertEquals(patientTO.getFirstName(), savedPatientTO.getFirstName());
        assertEquals(patientTO.getLastName(), savedPatientTO.getLastName());
    }
    @Transactional
    @Test
    public void removePatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("P001");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setHasInsurance(true);

        PatientTO savedPatientTO = patientService.addPatient(patientTO);
        Long patientId = savedPatientTO.getId();

        // when
        patientService.removePatient(patientId);

        // then
        assertNull(patientService.findById(patientId));
    }

    @Transactional
    @Test
    public void testDeletePatientWithVisits() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("P001");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setHasInsurance(true);

        ShortenedPatientTO shortenedPatientTO = new ShortenedPatientTO();
        shortenedPatientTO.setId(patientTO.getId());

        ShortenedDoctorTO shortenedDoctorTO1 = new ShortenedDoctorTO();
        shortenedDoctorTO1.setId(doctorService.findById(1L).getId());

        ShortenedDoctorTO shortenedDoctorTO2 = new ShortenedDoctorTO();
        shortenedDoctorTO2.setId(doctorService.findById(2L).getId());

        List<VisitTO> visits = new ArrayList<>();

        VisitTO visitTO1 = new VisitTO();
        visitTO1.setPatient(shortenedPatientTO);
        visitTO1.setDoctor(shortenedDoctorTO1);

        VisitTO visitTO2 = new VisitTO();
        visitTO2.setPatient(shortenedPatientTO);
        visitTO2.setDoctor(shortenedDoctorTO2);

        visits.add(visitTO1);
        visits.add(visitTO2);

        patientTO.setVisits(visits);

        int visitInitSize = visitService.findAllVisits().size();

        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        assertEquals(21, savedPatientTO.getId().intValue());
        assertEquals(2, savedPatientTO.getVisits().size());
        assertEquals(20, doctorService.DoctorsNumber());

        patientService.removePatient(savedPatientTO.getId());

        assertNull(patientService.findById(savedPatientTO.getId()));
        assertEquals(visitInitSize, visitService.findAllVisits().size());
        assertEquals(20, doctorService.DoctorsNumber());

    }

    @Transactional
    @Test
    public void testDeletePatientWithoutDoctors() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("P001");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setHasInsurance(true);

        ShortenedPatientTO shortenedPatientTO = new ShortenedPatientTO();
        shortenedPatientTO.setId(patientTO.getId());



        List<VisitTO> visits = new ArrayList<>();

        VisitTO visitTO1 = new VisitTO();
        visitTO1.setPatient(shortenedPatientTO);

        VisitTO visitTO2 = new VisitTO();
        visitTO2.setPatient(shortenedPatientTO);

        visits.add(visitTO1);
        visits.add(visitTO2);

        patientTO.setVisits(visits);



        int visitInitSize = visitService.findAllVisits().size();

        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        assertEquals(21, savedPatientTO.getId().intValue());
        assertEquals(2, savedPatientTO.getVisits().size());

        patientService.removePatient(savedPatientTO.getId());

        assertNull(patientService.findById(savedPatientTO.getId()));
        assertEquals(visitInitSize, visitService.findAllVisits().size());

    }

}
