package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public final class AddressMapper
{

    public static AddressTO mapToTO(final AddressEntity addressEntity)
    {
        if (addressEntity == null)
        {
            return null;
        }
        final AddressTO addressTO = new AddressTO();
        addressTO.setId(addressEntity.getId());
        addressTO.setAddressLine1(addressEntity.getAddressLine1());
        addressTO.setAddressLine2(addressEntity.getAddressLine2());
        addressTO.setCity(addressEntity.getCity());
        addressTO.setPostalCode(addressEntity.getPostalCode());
        if (addressEntity.getPatients() != null) {
            addressTO.setPatients(addressEntity.getPatients().stream().map(PatientMapper::mapToTO).collect(Collectors.toList()));
        }
        if (addressEntity.getDoctors() != null) {
            addressTO.setDoctors(addressEntity.getDoctors().stream().map(DoctorMapper::mapToTO).collect(Collectors.toList()));
        }
        return addressTO;
    }

    public static AddressEntity mapToEntity(final AddressTO addressTO)
    {
        if(addressTO == null)
        {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressTO.getId());
        addressEntity.setAddressLine1(addressTO.getAddressLine1());
        addressEntity.setAddressLine2(addressTO.getAddressLine2());
        addressEntity.setCity(addressTO.getCity());
        addressEntity.setPostalCode(addressTO.getPostalCode());
        if (addressTO.getDoctors() != null) {
            addressEntity.setDoctors(addressTO.getDoctors().stream().map(DoctorMapper::mapToEntity).collect(Collectors.toList()));
        }
        if (addressTO.getPatients() != null) {
            addressEntity.setPatients(addressTO.getPatients().stream().map(PatientMapper::mapToEntity).collect(Collectors.toList()));
        }
        return addressEntity;
    }
}
