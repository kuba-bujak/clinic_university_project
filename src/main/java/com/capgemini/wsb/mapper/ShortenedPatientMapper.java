package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.ShortenedDoctorTO;
import com.capgemini.wsb.dto.ShortenedPatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public final class ShortenedPatientMapper {
    public static ShortenedPatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final ShortenedPatientTO shortenedPatientTO = new ShortenedPatientTO();
        shortenedPatientTO.setId(patientEntity.getId());
        shortenedPatientTO.setFirstName(patientEntity.getFirstName());
        shortenedPatientTO.setLastName(patientEntity.getLastName());
        return shortenedPatientTO;
    }

    public static PatientEntity mapToEntity(final ShortenedPatientTO shortenedPatientTO) {
        if (shortenedPatientTO == null) {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(shortenedPatientTO.getId());
        patientEntity.setFirstName(shortenedPatientTO.getFirstName());
        patientEntity.setLastName(shortenedPatientTO.getLastName());
        return patientEntity;
    }
}
