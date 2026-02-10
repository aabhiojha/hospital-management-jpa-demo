package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.entity.Insurance;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.InsuranceRepository;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    // service to create an insurance
    @Transactional
    public Insurance createInsurance(Insurance insurance){
        return insuranceRepository.save(insurance);
    }


    @Transactional
    public Patient assignInsuranceToPatient(Long insuranceId, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(()-> new EntityNotFoundException("Insurance not found with id: "+ insuranceId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }


}
