package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;
    @Autowired
    private final PatientMapper patientMapper;


    public PatientController(PatientService patientService, PatientMapper patientMapper) {
        this.patientService = patientService;
        this.patientMapper = patientMapper;
    }

    @GetMapping("/patients")
    ResponseEntity<List<PatientTO>> findAllPatients() {
        List<PatientTO> listOfPatients = patientService.getPatientList();
        return ResponseEntity.ok(listOfPatients);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientTO> creataPatient(@RequestBody PatientTO patient) {
        PatientTO createdPatient = patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @GetMapping("/patient/{id}")
    ResponseEntity<PatientTO> findPatientById(@PathVariable final Long id){
        final PatientTO patientTO = patientService.findById(id);
        if (patientTO != null) {
            return ResponseEntity.ok().body(patientTO);
        }
        return ResponseEntity.notFound().build();
    }


}
