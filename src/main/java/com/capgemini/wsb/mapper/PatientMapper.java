package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public final class PatientMapper {
    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setHasInsurance(patientEntity.isHasInsurance());
        patientTO.setAddresses(patientEntity.getAddresses().stream().map(AddressEntity::getId).collect(Collectors.toList()));
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null)
        {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setHasInsurance(patientTO.isHasInsurance());
        patientEntity.setAddresses(patientTO.getAddresses().stream().map(addressID -> {
            AddressEntity address = new AddressEntity();
            address.setId(addressID);
            return address;
        }).collect(Collectors.toList()));
        return patientEntity;
    }
}
