package dev.abhishek.hospitalmanagement.dto.patient_insurance;

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
