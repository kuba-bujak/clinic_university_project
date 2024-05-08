package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.time.LocalDate;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>{

    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findAllPatientsWithMoreVisitsThan(int numberOfVisits);

    List<PatientEntity> findPatientsOlderThan(int age);
}
