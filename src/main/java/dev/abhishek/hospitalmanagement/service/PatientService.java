package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientByID(long id) {
        Patient p1 = patientRepository.findById(id)
                .orElseThrow();
        Patient p2 = patientRepository.findById(id)
                .orElseThrow();

        System.out.println(p1 == p2);

        p1.setName("Ram Bahadur");
//        patientRepository.save(p1);

        return p1;
    }

}
