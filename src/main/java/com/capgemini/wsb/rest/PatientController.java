package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    List<PatientTO> findAllPatients() {
        final List<PatientTO> listOfPatients = patientService.getPatientList();
        return listOfPatients;
    }

    @PostMapping("/patient/{id}")
    PatientTO updatePatient(@PathVariable final Long id, PatientTO updatedPatientTO) throws Exception {
        final PatientTO patientTO = patientService.findById(id);
        if (patientTO != null) {
            PatientTO updatedPatient = patientService.updatePatient(updatedPatientTO);
            if (updatedPatient != null) {
                return updatedPatient;
            }
            throw new Exception("Patient was not updated");
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/{id}")
    PatientTO findPatientById(@PathVariable final Long id){
        final PatientTO patientTO = patientService.findById(id);
        if (patientTO != null) {
            return patientTO;
        }
        throw new EntityNotFoundException(id);
    }


}
