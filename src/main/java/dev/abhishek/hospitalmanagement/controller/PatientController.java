package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.exceptions.patient.PatientNotFoundException;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import dev.abhishek.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequiredArgsConstructor
public class PatientController {

    final PatientService patientService;
//    PatientRepository patientRepository;

    @GetMapping("/api/patients/{id}")
    public Patient getPatientById(@PathVariable Long id){
         return patientService.getPatientByID(id);
    }

    @GetMapping("/api/patients/{email}")
    public Patient getPatientByEmail(@RequestParam String email){
        return patientService.getPatientByEmail(email)
                .orElseThrow(() -> new PatientNotFoundException(email));
    }


//    @PostMapping("/api/patients/")
//     public Patient createPatient(@RequestBody Patient patient) {
//          return patientRepository.(id);
//     }




}
