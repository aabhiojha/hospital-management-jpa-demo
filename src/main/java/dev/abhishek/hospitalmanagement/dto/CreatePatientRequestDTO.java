package dev.abhishek.hospitalmanagement.dto;

import dev.abhishek.hospitalmanagement.type.BloodGroupType;
import dev.abhishek.hospitalmanagement.type.GenderType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePatientRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Gender is required")
    private GenderType gender;

    private BloodGroupType bloodGroup;

    // recursive validation/serialization hune re
    @Valid
    private CreateInsuranceRequestDTO insurance;

}
