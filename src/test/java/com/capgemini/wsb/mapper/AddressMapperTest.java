package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AddressMapperTest {

    @Test
    public void testMapToTO() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1L);
        addressEntity.setAddressLine1("Street 1");
        addressEntity.setAddressLine2("Apartment 101");
        addressEntity.setCity("City");
        addressEntity.setPostalCode("12345");

        List<DoctorEntity> doctors = new ArrayList<>();
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(1L);
        doctors.add(doctorEntity);
        addressEntity.setDoctors(doctors);

        List<PatientEntity> patients = new ArrayList<>();
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patients.add(patientEntity);
        addressEntity.setPatients(patients);

        // when
        AddressTO addressTO = AddressMapper.mapToTO(addressEntity);

        // then
        assertEquals(addressEntity.getId(), addressTO.getId());
        assertEquals(addressEntity.getAddressLine1(), addressTO.getAddressLine1());
        assertEquals(addressEntity.getAddressLine2(), addressTO.getAddressLine2());
        assertEquals(addressEntity.getCity(), addressTO.getCity());
        assertEquals(addressEntity.getPostalCode(), addressTO.getPostalCode());
        assertEquals(1, addressTO.getDoctors().size());
        assertEquals(1, addressTO.getPatients().size());
    }

    @Test
    public void testMapToEntity() {
        // given
        AddressTO addressTO = new AddressTO();
        addressTO.setId(1L);
        addressTO.setAddressLine1("Street 1");
        addressTO.setAddressLine2("Apartment 101");
        addressTO.setCity("City");
        addressTO.setPostalCode("12345");

        List<DoctorTO> doctorTOs = new ArrayList<>();
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(1L);
        doctorTOs.add(doctorTO);
        addressTO.setDoctors(doctorTOs);

        List<PatientTO> patientTOs = new ArrayList<>();
        PatientTO patientTO = new PatientTO();
        patientTO.setId(1L);
        patientTOs.add(patientTO);
        addressTO.setPatients(patientTOs);

        // when
        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);

        // then
        assertEquals(addressTO.getId(), addressEntity.getId());
        assertEquals(addressTO.getAddressLine1(), addressEntity.getAddressLine1());
        assertEquals(addressTO.getAddressLine2(), addressEntity.getAddressLine2());
        assertEquals(addressTO.getCity(), addressEntity.getCity());
        assertEquals(addressTO.getPostalCode(), addressEntity.getPostalCode());
        assertEquals(1, addressEntity.getDoctors().size());
        assertEquals(1, addressEntity.getPatients().size());
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
