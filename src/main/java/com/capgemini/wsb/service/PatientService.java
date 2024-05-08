package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    public PatientTO findById(final Long id);

    PatientTO addPatient(PatientTO patientTO);

    void removePatient(Long patientId);

    PatientTO updatePatient(PatientTO patientTO);

    List<VisitTO> getAllVisitsForPatient(Long patientId);

    PatientTO getPatientWithVisits(Long patientID);

    List<PatientTO> getPatientList();
}
