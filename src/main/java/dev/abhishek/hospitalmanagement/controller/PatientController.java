package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.dto.patient.CreatePatientRequestDTO;
import dev.abhishek.hospitalmanagement.dto.patient.PatientDTO;
import dev.abhishek.hospitalmanagement.dto.patient_insurance.AssignInsurancePatientDTO;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import dev.abhishek.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
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
    PatientRepository patientRepository;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> allPatients = patientService.getAllPatients();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
         return new ResponseEntity<>(patientService.getPatientByID(id), HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<Optional<Patient>> getPatientByEmail(@RequestParam String email){
        return new ResponseEntity<>(patientService.getPatientByEmail(email), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatientEntry(@RequestBody CreatePatientRequestDTO patient){
        PatientDTO patientEntry = patientService.createPatientEntry(patient);
        return new ResponseEntity<>(patientEntry,HttpStatus.CREATED);
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

    @PutMapping
    public ResponseEntity<Patient> assignInsuranceToPatient(@RequestBody AssignInsurancePatientDTO requestObj){
        Patient patient = patientService.assignInsuranceToPatient(requestObj.getInsuranceId(), requestObj.getPatientId());
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

}
