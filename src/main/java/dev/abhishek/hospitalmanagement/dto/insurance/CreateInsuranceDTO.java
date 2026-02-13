package dev.abhishek.hospitalmanagement.dto.insurance;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateInsuranceDTO {
    @NotBlank(message = "Policy number is required")
    private String policyNumber;

    @NotBlank(message = "Provider is required")
    private String provider;

    @Future(message = "Valid until data must be in the future")
    private LocalDate validUntil;
}
