package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping()
    public Page<Patient> getPatients(Pageable pageable) {
        return patientService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatientByID(id);
    }

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatient(id, patient);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") long id) {
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body("The patient with id " + id + " is deleted.");
    }
}
