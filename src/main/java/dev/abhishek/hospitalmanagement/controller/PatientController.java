package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import dev.abhishek.hospitalmanagement.service.PatientService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/api/patients/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatientByID(id);
    }

    @PostMapping("/api/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    @PutMapping("api/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatient(id, patient);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPatient);
    }

    @DeleteMapping("apit/patients/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") long id){
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body("The patient with id "+ id);
    }
}
