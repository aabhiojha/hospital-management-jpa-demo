package dev.abhishek.hospitalmanagement.repository;

import dev.abhishek.hospitalmanagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}