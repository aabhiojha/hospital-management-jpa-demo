package dev.abhishek.hospitalmanagement.dto.patient;

import dev.abhishek.hospitalmanagement.dto.insurance.InsuranceDTO;
import dev.abhishek.hospitalmanagement.entity.Insurance;
import dev.abhishek.hospitalmanagement.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    // dto to patient object
    public Patient toEntity(CreatePatientRequestDTO patientRequestObj){
        Patient patient = new Patient();
        patient.setName(patientRequestObj.getName());
        patient.setBirthDate(patientRequestObj.getBirthDate());
        patient.setEmail(patientRequestObj.getEmail());
        patient.setGender(patientRequestObj.getGender());
        patient.setBloodGroup(patientRequestObj.getBloodGroup());

        // if request object contains insurance information while creating the user
        if (patientRequestObj.getInsurance() != null){
            Insurance insurance = new Insurance();
            insurance.setPolicyNumber(patientRequestObj.getInsurance().getPolicyNumber());
            insurance.setProvider(patientRequestObj.getInsurance().getProvider());
            insurance.setValidUntil(patientRequestObj.getInsurance().getValidUntil());
            patient.setInsurance(insurance);
        }
        return patient;
    }

    
    // patient to dto
    public PatientDTO toDto(Patient patient){
        PatientDTO dto = new PatientDTO();
        dto.setName(patient.getName());
        dto.setBirthDate(patient.getBirthDate());
        dto.setBloodGroup(patient.getBloodGroup());
        dto.setEmail(patient.getEmail());
        dto.setGender(patient.getGender());

        // insurance logic
        // return nested insurance response in patient with another dto
        if(patient.getInsurance() != null){
            InsuranceDTO insurance = new InsuranceDTO();
            insurance.setPolicyNumber(patient.getInsurance().getPolicyNumber());
            insurance.setProvider(patient.getInsurance().getProvider());
            insurance.setValidUntil(patient.getInsurance().getValidUntil());
            dto.setInsurance(insurance);
        }
        return dto;
    }


}
