package dev.abhishek.hospitalmanagement.dto.patient;

import dev.abhishek.hospitalmanagement.dto.insurance.InsuranceDTO;
import dev.abhishek.hospitalmanagement.type.BloodGroupType;
import dev.abhishek.hospitalmanagement.type.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private GenderType gender;
    private BloodGroupType bloodGroup;
    private InsuranceDTO insurance; // Nested DTO
}
