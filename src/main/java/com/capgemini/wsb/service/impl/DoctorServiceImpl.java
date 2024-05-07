package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao doctorRepository) {
        this.doctorDao = doctorRepository;
    }
    @Override
    public DoctorTO findById(Long id) {
        final DoctorEntity doctorEntity = doctorDao.findOne(id);
        return DoctorMapper.mapToTO(doctorEntity);
    }

    @Override
    public int DoctorsNumber() {
        final List<DoctorEntity> doctorEntities = doctorDao.findAll();
        return doctorEntities.size();
    }
}
