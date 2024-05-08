package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.ShortenedPatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.ShortenedDoctorMapper;
import com.capgemini.wsb.mapper.ShortenedPatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientRepository) {
        this.patientDao = patientRepository;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity patientEntity = patientDao.findOne(id);
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    @Transactional
    public PatientTO addPatient(PatientTO patientTO) {
        System.out.println(patientTO);
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        System.out.println(patientEntity);
        PatientEntity savedPatient = patientDao.save(patientEntity);
        System.out.println(savedPatient);

        return PatientMapper.mapToTO(savedPatient);
    }

    @Override
    public void removePatient(Long patientId) {
        patientDao.delete(patientId);
    }

    @Override
    public PatientTO updatePatient(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        patientDao.update(patientEntity);
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    public List<VisitTO> getAllVisitsForPatient(Long patientId) {
        PatientEntity patientEntity = patientDao.findOne(patientId);
        List<VisitEntity> visitEntities = patientEntity.getVisits();
        return visitEntities.stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PatientTO getPatientWithVisits(Long patientId) {
        PatientEntity patientEntity = patientDao.findOne(patientId);
        Hibernate.initialize(patientEntity.getVisits());
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    public List<PatientTO> getPatientList() {
        List<PatientEntity> patientList = patientDao.findAll();
        return patientList.stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }


}
