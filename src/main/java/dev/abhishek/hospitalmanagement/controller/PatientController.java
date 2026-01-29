package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/api/patients/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientRepository.findPatientById(id);
    }

    @PostMapping("/api/patients/")
     public Patient createPatient(@RequestBody Patient patient) {
         // return patientRepository.(id);
     }


}
