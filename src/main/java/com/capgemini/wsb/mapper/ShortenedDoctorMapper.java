package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.ShortenedDoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
public final class ShortenedDoctorMapper {
    public static ShortenedDoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        final ShortenedDoctorTO shortenedDoctorTO = new ShortenedDoctorTO();
        shortenedDoctorTO.setId(doctorEntity.getId());
        shortenedDoctorTO.setFirstName(doctorEntity.getFirstName());
        shortenedDoctorTO.setLastName(doctorEntity.getLastName());
        return shortenedDoctorTO;
    }

    public static DoctorEntity mapToEntity(final ShortenedDoctorTO shortenedDoctorTO) {
        if (shortenedDoctorTO == null) {
            return null;
        }
        final DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(shortenedDoctorTO.getId());
        doctorEntity.setFirstName(shortenedDoctorTO.getFirstName());
        doctorEntity.setLastName(shortenedDoctorTO.getLastName());
        return doctorEntity;
    }
}
