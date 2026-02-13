package dev.abhishek.hospitalmanagement.dto.mapper;

import dev.abhishek.hospitalmanagement.dto.insurance.CreateInsuranceDTO;
import dev.abhishek.hospitalmanagement.entity.Insurance;
import org.springframework.stereotype.Component;

@Component
public class InsuranceMapper {
    public Insurance toEntity(CreateInsuranceDTO createInsuranceDTO){
        Insurance insurance = new Insurance();
        insurance.setPolicyNumber(createInsuranceDTO.getPolicyNumber());
        insurance.setProvider(createInsuranceDTO.getProvider());
        insurance.setValidUntil(createInsuranceDTO.getValidUntil());
        return insurance;
    }

    public CreateInsuranceDTO toDto(Insurance insurance){
        CreateInsuranceDTO createInsuranceDTO = new CreateInsuranceDTO();
        createInsuranceDTO.setPolicyNumber(insurance.getPolicyNumber());
        createInsuranceDTO.setProvider(insurance.getProvider());
        createInsuranceDTO.setValidUntil(insurance.getValidUntil());
        return createInsuranceDTO;
    }
}
