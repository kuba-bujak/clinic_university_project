package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MedicalTreatmentMapperTest {
    @Test
    public void testMapToTO() {
        // given
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(1L);
        medicalTreatmentEntity.setDescription("Test description");
        medicalTreatmentEntity.setType(TreatmentType.RTG);

        // when
        MedicalTreatmentTO medicalTreatmentTO = MedicalTreatmentMapper.mapToTO(medicalTreatmentEntity);

        // then
        assertEquals(medicalTreatmentEntity.getId(), medicalTreatmentTO.getId());
        assertEquals(medicalTreatmentEntity.getDescription(), medicalTreatmentTO.getDescription());
        assertEquals(medicalTreatmentEntity.getType(), medicalTreatmentTO.getType());
    }

    @Test
    public void testMapToTO_NullInput() {
        // when
        MedicalTreatmentTO medicalTreatmentTO = MedicalTreatmentMapper.mapToTO(null);

        // then
        assertNull(medicalTreatmentTO);
    }

    @Test
    public void testMapToEntity() {
        // given
        MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTO.setId(1L);
        medicalTreatmentTO.setDescription("Test description");
        medicalTreatmentTO.setType(TreatmentType.RTG);

        // when
        MedicalTreatmentEntity medicalTreatmentEntity = MedicalTreatmentMapper.mapToEntity(medicalTreatmentTO);

        // then
        assertEquals(medicalTreatmentTO.getId(), medicalTreatmentEntity.getId());
        assertEquals(medicalTreatmentTO.getDescription(), medicalTreatmentEntity.getDescription());
        assertEquals(medicalTreatmentTO.getType(), medicalTreatmentEntity.getType());
    }

    @Test
    public void testMapToEntity_NullInput() {
        // when
        MedicalTreatmentEntity medicalTreatmentEntity = MedicalTreatmentMapper.mapToEntity(null);

        // then
        assertNull(medicalTreatmentEntity);
    }
}
