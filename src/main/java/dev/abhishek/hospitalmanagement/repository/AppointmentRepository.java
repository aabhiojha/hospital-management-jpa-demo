package dev.abhishek.hospitalmanagement.repository;

import dev.abhishek.hospitalmanagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}