package dev.abhishek.hospitalmanagement.dto.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateDoctorDTO {
    @NotNull
    private String name;
    @Email
    private String email;

    private String specialization;
//    private AssignDoctorToDepartment department;
}
