package dev.abhishek.hospitalmanagement.repository;

import dev.abhishek.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient save(Patient patient);

    Optional<Patient> findById(Long id);

    List<Patient> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);

    boolean existsByEmailAndIdNot(String email, long id);

//    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
//
//    List<Patient> findPatientByNameContainingIgnoreCaseOrderByIdAsc(String name);
//
//    @Query("select p from Patient p where p.bloodGroup = ?1")
//    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);
//
//    @Query("select p from Patient p where p.birthDate > :birthDate")
//    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);
//
//    @Query("select new dev.abhishek.hospitalmanagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, count(p)) from Patient p group by p.bloodGroup")
//    List<BloodGroupCountResponseEntity> countEachBloodGroupType();
//
//    @Query(value = "select * from patient", nativeQuery = true)
//    Page<Patient> findAllPatients(Pageable pageable);
//
//    @Transactional
//    @Modifying
//    @Query("update Patient p set p.name = :name where p.id=:id")
//    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

}
