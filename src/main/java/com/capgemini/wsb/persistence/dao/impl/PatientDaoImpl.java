package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("select patient from PatientEntity patient"+
                                    " where patient.lastName like :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findAllPatientsWithMoreVisitsThan(int numberOfVisits) {
        return entityManager.createQuery("select patient from PatientEntity patient" +
                                  " where size(patient.visits) > :minVisits", PatientEntity.class)
                .setParameter("minVisits", numberOfVisits)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsOlderThan(int age) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDateThreshold = currentDate.minusYears(age);

        return entityManager.createQuery("select patient from PatientEntity patient "+
                                        " where patient.dateOfBirth < :birthDateThreshold", PatientEntity.class)
                .setParameter("birthDateThreshold", birthDateThreshold)
                .getResultList();
    }
}
