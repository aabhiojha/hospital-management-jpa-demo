package dev.abhishek.hospitalmanagement.dto.appointment;

import dev.abhishek.hospitalmanagement.entity.Doctor;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.type.AppointmentStatusType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private AppointmentStatusType status;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

}
