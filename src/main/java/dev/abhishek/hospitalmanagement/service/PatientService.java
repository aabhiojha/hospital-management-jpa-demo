package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.exceptions.patient.PatientNotFoundException;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientByID(long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    @Transactional
    public Patient createPatientEntry(Patient patient) {
        return patientRepository.save(patient);
    }

    @Transactional
    public Optional<Patient> updatePatient(Patient patient, Long id) {
        // check if the patient really exists by id
        Optional<Patient> patientFromDb = patientRepository.findById(id);
        if (patientFromDb.isEmpty()) {
            return Optional.empty();
        }
        Patient existingPatient = patientFromDb.get();
        existingPatient.setName(patient.getName());
        existingPatient.setBirthDate(patient.getBirthDate());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setGender(patient.getGender());
        patientRepository.save(existingPatient);
        return patientFromDb;
    }


    @Transactional
    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }

}
