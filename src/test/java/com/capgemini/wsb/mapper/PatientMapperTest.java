package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.*;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PatientMapperTest {
    @Test
    public void testMapToTO() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("john.doe@example.com");
        patientEntity.setPatientNumber("P001");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientEntity.setHasInsurance(true);

        List<AddressEntity> addresses = new ArrayList<>();
        AddressEntity address = new AddressEntity();
        address.setId(101L);
        addresses.add(address);

        patientEntity.setAddresses(addresses);

        List<VisitEntity> visits = new ArrayList<>();
        VisitEntity visit = new VisitEntity();
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(301L);
        visit.setId(201L);
        visit.setPatient(patientEntity);
        visit.setDoctor(doctorEntity);
        visits.add(visit);

        patientEntity.setVisits(visits);

        // when
        PatientTO patientTO = PatientMapper.mapToTO(patientEntity);

        System.out.println(patientEntity.getId());
        System.out.println(patientTO.getId());

        // then
        assertEquals(patientEntity.getId(), patientTO.getId());
        assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity.getLastName(), patientTO.getLastName());
        assertEquals(patientEntity.getTelephoneNumber(), patientTO.getTelephoneNumber());
        assertEquals(patientEntity.getEmail(), patientTO.getEmail());
        assertEquals(patientEntity.getPatientNumber(), patientTO.getPatientNumber());
        assertEquals(patientEntity.getDateOfBirth(), patientTO.getDateOfBirth());
        assertEquals(patientEntity.isHasInsurance(), patientTO.isHasInsurance());
        assertEquals(1, patientEntity.getAddresses().size());
        assertEquals(1, patientEntity.getVisits().size());
    }

    @Test
    public void testMapToEntity() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setId(1L);
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("P001");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setHasInsurance(true);

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

        // Utwórz ShortenedPatientTO i ustaw tylko wymagane pola
        ShortenedPatientTO shortenedPatientTO = new ShortenedPatientTO();
        shortenedPatientTO.setId(patientTO.getId());
        shortenedPatientTO.setFirstName(patientTO.getFirstName());
        shortenedPatientTO.setLastName(patientTO.getLastName());
        visit.setPatient(shortenedPatientTO);

        ShortenedDoctorTO shortenedDoctorTO = new ShortenedDoctorTO();
        shortenedDoctorTO.setId(doctorTO.getId());
        shortenedDoctorTO.setFirstName(doctorTO.getFirstName());
        shortenedDoctorTO.setLastName(doctorTO.getLastName());
        visit.setDoctor(shortenedDoctorTO);

        visits.add(visit);

        patientTO.setVisits(visits);

        // when
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);

        // then
        assertEquals(patientTO.getId(), patientEntity.getId());
        assertEquals(patientTO.getFirstName(), patientEntity.getFirstName());
        assertEquals(patientTO.getLastName(), patientEntity.getLastName());
        assertEquals(patientTO.getTelephoneNumber(), patientEntity.getTelephoneNumber());
        assertEquals(patientTO.getEmail(), patientEntity.getEmail());
        assertEquals(patientTO.getPatientNumber(), patientEntity.getPatientNumber());
        assertEquals(patientTO.getDateOfBirth(), patientEntity.getDateOfBirth());
        assertEquals(patientTO.isHasInsurance(), patientEntity.isHasInsurance());
        assertEquals(1, patientTO.getAddresses().size());
        assertEquals(1, patientTO.getVisits().size());
    }


    @Test
    public void testMapToTONull() {
        assertNull(PatientMapper.mapToTO(null));
    }

    @Test
    public void testMapToEntityNull() {
        assertNull(PatientMapper.mapToEntity(null));
    }
}
