package dev.abhishek.hospitalmanagement.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDTO {
    @NotBlank
    private Long id;
    @NotBlank
    private String policyNumber;
    @NotBlank
    private String provider;
    @Future
    private LocalDate validUntil;
}
