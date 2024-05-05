package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
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
        assertEquals(visitEntity.getPatient().getId(), visitTO.getPatientID());
        assertEquals(visitEntity.getDoctor().getId(), visitTO.getDoctorID());
        assertEquals(1, visitEntity.getMedicalTreatments().size());
    }

    @Test
    public void testMapToEntity() {
        // given
        VisitTO visitTO = new VisitTO();
        visitTO.setId(1L);
        visitTO.setDescription("Description");
        visitTO.setTime(LocalDateTime.now());

        PatientTO patientTO = new PatientTO();
        patientTO.setId(1L);
        visitTO.setPatientID(patientTO.getId());

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(1L);
        visitTO.setDoctorID(doctorTO.getId());

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
        assertEquals(visitTO.getPatientID(), visitEntity.getPatient().getId());
        assertEquals(visitTO.getDoctorID() , visitEntity.getDoctor().getId());
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
