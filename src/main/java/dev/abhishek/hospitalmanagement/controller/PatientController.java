package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.exceptions.patient.PatientNotFoundException;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import dev.abhishek.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {

    final PatientService patientService;
//    PatientRepository patientRepository;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> allPatients = patientService.getAllPatients();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
         return new ResponseEntity<>(patientService.getPatientByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPatientEntry(@RequestBody Patient patient){
        Patient patientEntry = patientService.createPatientEntry(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatientEntry(@RequestBody Patient patient, @PathVariable long id){
        Optional<Patient> updatedPatient = patientService.updatePatient(patient, id);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientEntry(@PathVariable long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
