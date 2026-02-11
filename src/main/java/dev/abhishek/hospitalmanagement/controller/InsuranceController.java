package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.dto.patient_insurance.AssignInsurancePatientDTO;
import dev.abhishek.hospitalmanagement.entity.Insurance;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;




    //create an insurance
    @PostMapping
    public ResponseEntity<Insurance> createInsurance(@RequestBody Insurance insurance){
        Insurance insurance1 = insuranceService.createInsurance(insurance);
        return new ResponseEntity<>(insurance1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Patient> assignInsuranceToPatient(@RequestBody AssignInsurancePatientDTO requestObj){
        Patient patient = insuranceService.assignInsuranceToPatient(requestObj.getInsuranceId(), requestObj.getPatientId());
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }



}
