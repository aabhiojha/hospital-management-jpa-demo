package dev.abhishek.hospitalmanagement.dto.patient;

import dev.abhishek.hospitalmanagement.entity.Insurance;
import dev.abhishek.hospitalmanagement.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(CreatePatientRequestDTO patientRequestObj){
        Patient patient = new Patient();
        patient.setName(patientRequestObj.getName());
        patient.setBirthDate(patientRequestObj.getBirthDate());
        patient.setEmail(patientRequestObj.getEmail());
        patient.setGender(patientRequestObj.getGender());
        patient.setBloodGroup(patientRequestObj.getBloodGroup());

        if (patientRequestObj.getInsurance() != null){
            Insurance insurance = new Insurance();
            insurance.setPolicyNumber(patientRequestObj.getInsurance().getPolicyNumber());
            insurance.setProvider(patientRequestObj.getInsurance().getProvider());
            insurance.setValidUntil(patientRequestObj.getInsurance().getValidUntil());
            patient.setInsurance(insurance);
        }
        return patient;
    }


}
