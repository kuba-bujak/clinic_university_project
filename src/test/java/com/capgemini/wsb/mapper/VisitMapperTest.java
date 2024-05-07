package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.*;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class VisitMapperTest {
    @Test
    public void testMapToTO() {
        // given
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(1L);
        visitEntity.setDescription("Description");
        visitEntity.setTime(LocalDateTime.now());

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        visitEntity.setPatient(patientEntity);

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(1L);
        visitEntity.setDoctor(doctorEntity);

        List<MedicalTreatmentEntity> medicalTreatmentEntities = new ArrayList<>();
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(1L);
        medicalTreatmentEntities.add(medicalTreatmentEntity);
        visitEntity.setMedicalTreatments(medicalTreatmentEntities);

        // when
        VisitTO visitTO = VisitMapper.mapToTO(visitEntity);

        // then
        assertEquals(visitEntity.getId(), visitTO.getId());
        assertEquals(visitEntity.getDescription(), visitTO.getDescription());
        assertEquals(visitEntity.getTime(), visitTO.getTime());
        assertEquals(visitEntity.getPatient().getId(), visitTO.getPatient().getId());
        assertEquals(visitEntity.getDoctor().getId(), visitTO.getDoctor().getId());
        assertEquals(1, visitEntity.getMedicalTreatments().size());
    }

    @Test
    public void testMapToEntity() {
        // given
        VisitTO visitTO = new VisitTO();
        visitTO.setId(1L);
        visitTO.setDescription("Description");
        visitTO.setTime(LocalDateTime.now());

        ShortenedPatientTO shortenedPatientTO = new ShortenedPatientTO();
        shortenedPatientTO.setId(1L);
        visitTO.setPatient(shortenedPatientTO);

        ShortenedDoctorTO shortenedDoctorTO = new ShortenedDoctorTO();
        shortenedDoctorTO.setId(1L);
        visitTO.setDoctor(shortenedDoctorTO);

        List<MedicalTreatmentTO> medicalTreatmentTOs = new ArrayList<>();
        MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTO.setId(1L);
        medicalTreatmentTOs.add(medicalTreatmentTO);
        visitTO.setMedicalTreatments(medicalTreatmentTOs);

        // when
        VisitEntity visitEntity = VisitMapper.mapToEntity(visitTO);

        // then
        assertEquals(visitTO.getId(), visitEntity.getId());
        assertEquals(visitTO.getDescription(), visitEntity.getDescription());
        assertEquals(visitTO.getTime(), visitEntity.getTime());
        assertEquals(visitTO.getPatient().getId(), visitEntity.getPatient().getId());
        assertEquals(visitTO.getDoctor().getId() , visitEntity.getDoctor().getId());
        assertEquals(1, visitTO.getMedicalTreatments().size());
    }

    @Test
    public void testMapToTONull() {
        assertNull(VisitMapper.mapToTO(null));
    }

    @Test
    public void testMapToEntityNull() {
        assertNull(VisitMapper.mapToEntity(null));
    }
}
