package dev.abhishek.hospitalmanagement.repository;

import dev.abhishek.hospitalmanagement.entity.Insurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    Optional<Insurance> findByPolicyNumber(String policyNumber);
    boolean existsByPolicyNumber(String policyNumber);

    List<Insurance> findByProviderContainingIgnoreCase(String provider);
    List<Insurance> findByValidUntilBefore(LocalDate date);
    List<Insurance> findByValidUntilAfter(LocalDate date);

    Optional<Insurance> findByPatient_Id(Long patientId);

    Page<Insurance> findAll(Pageable pageable);



}