package dev.abhishek.hospitalmanagement.dto.insurance;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
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
    private Long id;
    @NotBlank
    private String policyNumber;
    @NotBlank
    private String provider;
    @Future
    private LocalDate validUntil;
}
