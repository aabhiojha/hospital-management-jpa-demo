package dev.abhishek.hospitalmanagement.dto.doctor;

import lombok.Data;

@Data
public class CreateDoctorDTO {
    private String name;
    private String email;
//    private AssignDoctorToDepartment department;
}
