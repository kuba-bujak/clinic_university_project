package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.*;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;


    @Test
    void findById() {
        PatientTO patientTO = patientService.findById(1L);

        assertEquals("Piotr", patientTO.getFirstName());
        assertEquals("Wiśniewski", patientTO.getLastName());
    }

    @Test
    void addPatient() {
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

    @Test
    void removePatient() {
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

    @Test
    void getAllVisitsForPatient() {
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

        List<AddressTO> addresses = new ArrayList<>();
        AddressTO address = new AddressTO();
        address.setId(101L);
        addresses.add(address);

        patientTO.setAddresses(addresses);

        List<VisitTO> visits = new ArrayList<>();
        VisitTO visit = new VisitTO();
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(500L);
        visit.setId(101L);
        visit.setPatient(patientTO);
        visit.setDoctor(doctorTO);
        visits.add(visit);

        patientTO.setVisits(visits);

        // when
        List<VisitTO> visits2 = patientService.getAllVisitsForPatient(patientId);

        // then
        assertFalse(visits.isEmpty()); // upewnienie się, że lista wizyt nie jest pusta
        assertEquals(1, visits2.size()); // upewnienie się, że jest tylko jedna wizyta dla tego pacjenta
    }

}
