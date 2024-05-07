package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface VisitService {
    public VisitTO findById(final Long id);

    public List<VisitTO> findAllVisits();
}
