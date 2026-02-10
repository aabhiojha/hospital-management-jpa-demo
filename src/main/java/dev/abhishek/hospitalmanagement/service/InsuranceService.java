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

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    // Required args constructor
//    public InsuranceService(
//            InsuranceRepository insuranceRepository,
//            PatientRepository patientRepository
//    ) {
//        this.insuranceRepository = insuranceRepository;
//        this.patientRepository = patientRepository;
//    }

    // service to create an insurance
    @Transactional
    public Insurance createInsurance(Insurance insurance){
        return insuranceRepository.save(insurance);
    }


//    @Transactional
//    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
//        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
//        patient.setInsurance(insurance);
//        insurance.setPatient(patient);
//        return patient;
//    }
}
