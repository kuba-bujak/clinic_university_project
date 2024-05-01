package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
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
        patientEntity.setDateOfBirth(LocalDate.parse("1990-01-01"));
        patientEntity.setHasInsurance(true);

        List<AddressEntity> addresses = new ArrayList<>();
        AddressEntity address = new AddressEntity();
        address.setId(101L);
        addresses.add(address);

        patientEntity.setAddresses(addresses);

        // when
        PatientTO patientTO = PatientMapper.mapToTO(patientEntity);

        // then
        assertEquals(patientEntity.getId(), patientTO.getId());
        assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity.getLastName(), patientTO.getLastName());
        assertEquals(patientEntity.getTelephoneNumber(), patientTO.getTelephoneNumber());
        assertEquals(patientEntity.getEmail(), patientTO.getEmail());
        assertEquals(patientEntity.getPatientNumber(), patientTO.getPatientNumber());
        assertEquals(patientEntity.getDateOfBirth(), patientTO.getDateOfBirth());
        assertEquals(patientEntity.isHasInsurance(), patientTO.isHasInsurance());
        assertEquals(patientEntity.getAddresses().size(), patientTO.getAddresses().size());
        assertEquals(patientEntity.getAddresses().get(0).getId(), patientTO.getAddresses().get(0));
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
        patientTO.setDateOfBirth(LocalDate.parse("1990-01-01"));
        patientTO.setHasInsurance(true);

        List<Long> addressIds = new ArrayList<>();
        addressIds.add(101L);
        patientTO.setAddresses(addressIds);

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
        assertEquals(patientTO.getAddresses().size(), patientEntity.getAddresses().size());
        assertEquals(patientTO.getAddresses().get(0), patientEntity.getAddresses().get(0).getId());
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
