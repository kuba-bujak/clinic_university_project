package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao visitRepository) {
        this.visitDao = visitRepository;
    }

    @Override
    public VisitTO findById(Long id) {
        final VisitEntity visitEntity = visitDao.findOne(id);
        return VisitMapper.mapToTO(visitEntity);
    }

    @Override
    public List<VisitTO> findAllVisits() {
        final List<VisitEntity> visits = visitDao.findAll();
        List<VisitTO> visitTOS = visits.stream().map(VisitMapper::mapToTO).collect(Collectors.toList());
        return visitTOS;
    }


}
