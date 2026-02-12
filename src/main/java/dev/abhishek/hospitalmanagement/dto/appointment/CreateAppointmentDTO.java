package dev.abhishek.hospitalmanagement.dto.appointment;

import dev.abhishek.hospitalmanagement.type.AppointmentStatusType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentDTO {
    @NotNull
    private LocalDateTime appointmentTime;
    @NotBlank
    private String reason;

//    private Patient patient;
//    private Doctor doctor;
}
