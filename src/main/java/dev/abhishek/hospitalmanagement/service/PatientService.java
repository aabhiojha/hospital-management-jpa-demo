package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final RouterFunctionMapping routerFunctionMapping;

    public Page<Patient> findAll(Pageable pageable){
        return patientRepository.findAll(pageable);
    }

    @Transactional
    public Patient getPatientByID(long id) {
        return patientRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public Patient createPatient(Patient patient) {
        String email = patient.getEmail();

        if(patientRepository.existsByEmailNot(email)){}

        Patient newPatient = new Patient();
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient updatePatient(long id, Patient patient) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with id: "+ id));

        if(patient.getEmail() != null && !patient.getEmail().equals(existing.getEmail())){
            if(patientRepository.existsByEmailAndIdNot(patient.getEmail(), id)){
                throw new IllegalArgumentException("Email already in use.");
            }
            existing.setEmail(patient.getEmail());
        }
        if(patient.getName() != null) existing.setName(patient.getName());
        if(patient.getBirthDate() != null) existing.setBirthDate(patient.getBirthDate());
        if(patient.getBloodGroup() != null) existing.setBloodGroup(patient.getBloodGroup());
        if(patient.getGender() != null) existing.setGender(patient.getGender());
//        if(patient.() != null) existing.setName(patient.getName());
        return patientRepository.save(existing);
    }

    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

}
