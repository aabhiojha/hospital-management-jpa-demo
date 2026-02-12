package dev.abhishek.hospitalmanagement.dto.appointment;

import dev.abhishek.hospitalmanagement.entity.Doctor;
import dev.abhishek.hospitalmanagement.entity.Patient;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private String status;

//    private Patient patient;
//    private Doctor doctor;
}
