package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testFindPatientByLastName() {
        //given
        PatientEntity patientEntity1 = new PatientEntity();
        patientEntity1.setFirstName("Adam");
        patientEntity1.setLastName("Nowak");
        patientEntity1.setTelephoneNumber("1234567890");
        patientEntity1.setEmail("adam.nowak@gmail.com");
        patientEntity1.setPatientNumber("P001");
        patientEntity1.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientEntity1.setHasInsurance(true);

        PatientEntity patientEntity2 = new PatientEntity();
        patientEntity2.setFirstName("Anna");
        patientEntity2.setLastName("Nowak");
        patientEntity2.setTelephoneNumber("1234567890");
        patientEntity2.setEmail("anna.nowak@gmail.com");
        patientEntity2.setPatientNumber("P002");
        patientEntity2.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientEntity2.setHasInsurance(false);

        int patientListInitSize = patientDao.findAll().size();

        int patientListSizeStartsOnLastName = patientDao.findByLastName("Nowak").size();

        // when

        patientDao.save(patientEntity1);
        patientDao.save(patientEntity2);
        List<PatientEntity> patients = patientDao.findByLastName("Nowak");

        // then

        assertEquals(patientListInitSize + 2, patientDao.findAll().size());
        assertEquals(patientListSizeStartsOnLastName + 2, patients.size());
    }

    @Transactional
    @Test
    public void testFindAllPatientsWithMoreVisitsThan() {
        // given
        int minNumberOfVisits = 3;

        // when
        List<PatientEntity> listOfVisits = patientDao.findAllPatientsWithMoreVisitsThan(minNumberOfVisits);

        // then
        assertNotNull(listOfVisits);
        assertTrue(listOfVisits.get(0).getVisits().size() >= minNumberOfVisits);

    }

    @Transactional
    @Test
    public void testFindAllPatientsOlderThan() {
        // given
        int age = 30;

        // when
        List<PatientEntity> listOfPatients = patientDao.findPatientsOlderThan(age);

        // then
        assertNotNull(listOfPatients);
        assertTrue(listOfPatients.stream().allMatch(patient -> {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDateThreshold = currentDate.minusYears(age);
            return patient.getDateOfBirth().isBefore(birthDateThreshold);
        }));    }
}
