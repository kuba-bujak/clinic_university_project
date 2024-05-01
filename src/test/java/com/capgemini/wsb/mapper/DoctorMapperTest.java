package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DoctorMapperTest {
    @Test
    public void testMapToTO() {
        // given
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(1L);
        doctorEntity.setFirstName("John");
        doctorEntity.setLastName("Doe");
        doctorEntity.setTelephoneNumber("123456789");
        doctorEntity.setEmail("john.doe@example.com");
        doctorEntity.setDoctorNumber("DOC001");
        doctorEntity.setSpecialization(Specialization.SURGEON);

        // when
        DoctorTO doctorTO = DoctorMapper.mapToTO(doctorEntity);

        // then
        assertEquals(doctorEntity.getId(), doctorTO.getId());
        assertEquals(doctorEntity.getFirstName(), doctorTO.getFirstName());
        assertEquals(doctorEntity.getLastName(), doctorTO.getLastName());
        assertEquals(doctorEntity.getTelephoneNumber(), doctorTO.getTelephoneNumber());
        assertEquals(doctorEntity.getEmail(), doctorTO.getEmail());
        assertEquals(doctorEntity.getDoctorNumber(), doctorTO.getDoctorNumber());
        assertEquals(doctorEntity.getSpecialization(), doctorTO.getSpecialization());
    }

    @Test
    public void testMapToEntity() {
        // given
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(1L);
        doctorTO.setFirstName("John");
        doctorTO.setLastName("Doe");
        doctorTO.setTelephoneNumber("123456789");
        doctorTO.setEmail("john.doe@example.com");
        doctorTO.setDoctorNumber("DOC001");
        doctorTO.setSpecialization(Specialization.SURGEON);

        // when
        DoctorEntity doctorEntity = DoctorMapper.mapToEntity(doctorTO);

        // then
        assertEquals(doctorTO.getId(), doctorEntity.getId());
        assertEquals(doctorTO.getFirstName(), doctorEntity.getFirstName());
        assertEquals(doctorTO.getLastName(), doctorEntity.getLastName());
        assertEquals(doctorTO.getTelephoneNumber(), doctorEntity.getTelephoneNumber());
        assertEquals(doctorTO.getEmail(), doctorEntity.getEmail());
        assertEquals(doctorTO.getDoctorNumber(), doctorEntity.getDoctorNumber());
        assertEquals(doctorTO.getSpecialization(), doctorEntity.getSpecialization());
    }

    @Test
    public void testMapToTONull() {
        assertNull(DoctorMapper.mapToTO(null));
    }

    @Test
    public void testMapToEntityNull() {
        assertNull(DoctorMapper.mapToEntity(null));
    }
}
