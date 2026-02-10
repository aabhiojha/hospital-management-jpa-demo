package dev.abhishek.hospitalmanagement.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AssignInsurancePatientDTO {
    private Long insuranceId;
    private Long patientId;
}
