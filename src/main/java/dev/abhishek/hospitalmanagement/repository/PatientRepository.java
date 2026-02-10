package dev.abhishek.hospitalmanagement.repository;

import dev.abhishek.hospitalmanagement.dto.BloodGroupCountResponseEntity;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findById(Long id);

    Optional<Patient> findByEmail(String email);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findPatientByNameContainingIgnoreCaseOrderByIdAsc(String name);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select new dev.abhishek.hospitalmanagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.id=:id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

}
