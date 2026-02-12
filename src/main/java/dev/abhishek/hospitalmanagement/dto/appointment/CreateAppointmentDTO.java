package dev.abhishek.hospitalmanagement.dto.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentDTO {
    @NotNull
    private Long id;
    private LocalDateTime appointmentTime;
    @NotBlank
    private String reason;
}
