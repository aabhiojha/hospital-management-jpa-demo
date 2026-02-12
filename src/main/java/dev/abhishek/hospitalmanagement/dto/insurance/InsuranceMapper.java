package dev.abhishek.hospitalmanagement.dto.insurance;

import dev.abhishek.hospitalmanagement.entity.Insurance;
import org.springframework.stereotype.Component;

@Component
public class InsuranceMapper {
    public Insurance toEntity(CreateInsuranceRequestDTO createInsuranceRequestDTO){
        Insurance insurance = new Insurance();
        insurance.setPolicyNumber(createInsuranceRequestDTO.getPolicyNumber());
        insurance.setProvider(createInsuranceRequestDTO.getProvider());
        insurance.setValidUntil(createInsuranceRequestDTO.getValidUntil());
        return insurance;
    }

    public CreateInsuranceRequestDTO toDto(Insurance insurance){
        CreateInsuranceRequestDTO createInsuranceRequestDTO = new CreateInsuranceRequestDTO();
        createInsuranceRequestDTO.setPolicyNumber(insurance.getPolicyNumber());
        createInsuranceRequestDTO.setProvider(insurance.getProvider());
        createInsuranceRequestDTO.setValidUntil(insurance.getValidUntil());
        return createInsuranceRequestDTO;
    }
}
