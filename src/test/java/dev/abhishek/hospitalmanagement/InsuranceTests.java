package dev.abhishek.hospitalmanagement;

import dev.abhishek.hospitalmanagement.entity.Insurance;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("hdfc-123")
                .provider("hdfc")
                .validUntil(LocalDate.of(2029,5,3))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);
    }
}
