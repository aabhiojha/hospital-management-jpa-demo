package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.entity.Insurance;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.InsuranceRepository;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    //    @Autowired
    private final InsuranceRepository insuranceRepository;
    //    @Autowired
    private final PatientRepository patientRepository;

    // this quietly does constructor injection
    // Required args constructor
//    public InsuranceService(
//            InsuranceRepository insuranceRepository,
//            PatientRepository patientRepository
//    ) {
//        this.insuranceRepository = insuranceRepository;
//        this.patientRepository = patientRepository;
//    }

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient);

        return patient;
    }
}
