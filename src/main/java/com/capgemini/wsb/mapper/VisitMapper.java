package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.impl.DoctorServiceImpl;
import com.capgemini.wsb.service.impl.PatientServiceImpl;

import java.util.stream.Collectors;

public final class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setPatientID(visitEntity.getPatient().getId());
        visitTO.setDoctorID(visitEntity.getDoctor().getId());
        if (visitEntity.getMedicalTreatments() != null) {
            visitTO.setMedicalTreatments(visitEntity.getMedicalTreatments().stream().map(MedicalTreatmentMapper::mapToTO).collect(Collectors.toList()));
        }
        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null)
        {
            return null;
        }
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(visitTO.getPatientID());
        visitEntity.setPatient(patientEntity);

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(visitTO.getDoctorID());
        visitEntity.setDoctor(doctorEntity);

        if (visitTO.getMedicalTreatments() != null) {
            visitEntity.setMedicalTreatments(visitTO.getMedicalTreatments().stream().map(MedicalTreatmentMapper::mapToEntity).collect(Collectors.toList()));
        }
        return visitEntity;
    }
}
