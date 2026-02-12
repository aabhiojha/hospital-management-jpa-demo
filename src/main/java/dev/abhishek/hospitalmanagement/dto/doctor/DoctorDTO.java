package dev.abhishek.hospitalmanagement.dto.doctor;

import dev.abhishek.hospitalmanagement.entity.Appointment;
import dev.abhishek.hospitalmanagement.entity.Department;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DoctorDTO {
    private String name;

    private String specialization;

    private String email;

    private LocalDateTime createdAt;

//    private List<Appointment> appointment;
//
//    private Set<Department> departments = new HashSet<>();

}
