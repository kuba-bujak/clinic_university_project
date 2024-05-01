package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AddressMapperTest {

    @Test
    public void testMapToTO() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1L);
        addressEntity.setAddressLine1("Street 1");
        addressEntity.setAddressLine2("Apartment 101");
        addressEntity.setCity("City");
        addressEntity.setPostalCode("12345");

        List<PatientEntity> patients = new ArrayList<>();
        PatientEntity patient1 = new PatientEntity();
        patient1.setId(101L);
        patients.add(patient1);

        addressEntity.setPatients(patients);

        AddressTO addressTO = AddressMapper.mapToTO(addressEntity);

        assertEquals(addressEntity.getId(), addressTO.getId());
        assertEquals(addressEntity.getAddressLine1(), addressTO.getAddressLine1());
        assertEquals(addressEntity.getAddressLine2(), addressTO.getAddressLine2());
        assertEquals(addressEntity.getCity(), addressTO.getCity());
        assertEquals(addressEntity.getPostalCode(), addressTO.getPostalCode());
        assertEquals(addressEntity.getPatients().size(), addressTO.getPatients().size());
        assertEquals(addressEntity.getPatients().get(0).getId(), addressTO.getPatients().get(0));
    }

    @Test
    public void testMapToEntity() {
        AddressTO addressTO = new AddressTO();
        addressTO.setId(1L);
        addressTO.setAddressLine1("Street 1");
        addressTO.setAddressLine2("Apartment 101");
        addressTO.setCity("City");
        addressTO.setPostalCode("12345");

        List<Long> patientIds = new ArrayList<>();
        patientIds.add(101L);
        addressTO.setPatients(patientIds);

        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);

        assertEquals(addressTO.getId(), addressEntity.getId());
        assertEquals(addressTO.getAddressLine1(), addressEntity.getAddressLine1());
        assertEquals(addressTO.getAddressLine2(), addressEntity.getAddressLine2());
        assertEquals(addressTO.getCity(), addressEntity.getCity());
        assertEquals(addressTO.getPostalCode(), addressEntity.getPostalCode());
        assertEquals(addressTO.getPatients().size(), addressEntity.getPatients().size());
        assertEquals(addressTO.getPatients().get(0), addressEntity.getPatients().get(0).getId());
    }

    @Test
    public void testMapToTONull() {
        assertNull(AddressMapper.mapToTO(null));
    }

    @Test
    public void testMapToEntityNull() {
        assertNull(AddressMapper.mapToEntity(null));
    }
}
