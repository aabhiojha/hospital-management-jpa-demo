package dev.abhishek.hospitalmanagement.repository;

import dev.abhishek.hospitalmanagement.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient save(Patient patient);

    Optional<Patient> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

    boolean existsByEmailAndIdNot(String email, long id);

    boolean existsByEmailNot(String email);


    List<Patient> findByNameContainingIgnoreCase(String name);

    List<Patient> findByGender(String gender);

    List<Patient> findByBloodGroup(String bloodGroup);

// Methods for insurance relationship

    Optional<Patient> findByInsurance_Id(Long insuranceId);

    Optional<Patient> findByInsurance_PolicyNumber(String policyNumber);

    Optional<Patient> findByInsurance_Provider(String insuranceProvider);
}
