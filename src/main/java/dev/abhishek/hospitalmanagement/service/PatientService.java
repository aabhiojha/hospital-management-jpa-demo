package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.exceptions.patient.PatientNotFoundException;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient getPatientByID(long id) {
        return patientRepository.findById(id)
                .orElseThrow(()-> new PatientNotFoundException(id));
    }

    public Optional<Patient> getPatientByEmail(String email){
        return patientRepository.findByEmail(email);
    }

//    public Optional<Patient> getPatientByID


}
