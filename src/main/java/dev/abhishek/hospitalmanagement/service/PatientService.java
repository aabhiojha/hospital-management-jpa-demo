package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.dto.insurance.CreateInsuranceRequestDTO;
import dev.abhishek.hospitalmanagement.dto.mapper.InsuranceMapper;
import dev.abhishek.hospitalmanagement.dto.patient.CreatePatientRequestDTO;
import dev.abhishek.hospitalmanagement.dto.patient.PatientDTO;
import dev.abhishek.hospitalmanagement.dto.mapper.PatientMapper;
import dev.abhishek.hospitalmanagement.entity.Insurance;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.exceptions.patient.PatientNotFoundException;
import dev.abhishek.hospitalmanagement.repository.InsuranceRepository;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;
    private final PatientMapper patientMapper;
    private final InsuranceMapper insuranceMapper;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientByID(long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    // search patient by email
    public Optional<Patient> getPatientByEmail(String email) {
        Patient byEmail = patientRepository.findByEmail(email);
        return Optional.ofNullable(byEmail);
    }

    @Transactional
    public PatientDTO createPatientEntry(CreatePatientRequestDTO patientRequestDTO) {
        Patient patientEntity = patientMapper.toEntity(patientRequestDTO);

        if (patientRequestDTO.getInsurance() != null) {
            CreateInsuranceRequestDTO createInsuranceRequestDTO = patientRequestDTO.getInsurance();
            Insurance insuranceEntity = insuranceMapper.toEntity(createInsuranceRequestDTO);
            patientEntity.setInsurance(insuranceEntity);
            insuranceEntity.setPatient(patientEntity);
            patientRepository.save(patientEntity);
            patientRepository.flush(); // flush to generate IDs
            return patientMapper.toDto(patientEntity);
        }
        return null;
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
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }


    // assign insurance to a patient
    // should be done from owning class
    // patient is the owning class
    @Transactional
    public Patient assignInsuranceToPatient(Long insuranceId, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new EntityNotFoundException("Insurance not found with id: " + insuranceId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        insurance.getPatient().setName("hari lal");
        return patient;
    }


}
