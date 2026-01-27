package dev.abhishek.hospitalmanagement.repository;

import dev.abhishek.hospitalmanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}