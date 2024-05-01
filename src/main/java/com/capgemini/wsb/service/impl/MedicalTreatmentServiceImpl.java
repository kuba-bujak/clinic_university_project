package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
import com.capgemini.wsb.service.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicalTreatmentServiceImpl implements MedicalTreatmentService {
    private final MedicalTreatmentDao medicalTreatmentDao;

    @Autowired
    public MedicalTreatmentServiceImpl(MedicalTreatmentDao pMedicalTreatmentDao)
    {
        medicalTreatmentDao = pMedicalTreatmentDao;
    }
}
