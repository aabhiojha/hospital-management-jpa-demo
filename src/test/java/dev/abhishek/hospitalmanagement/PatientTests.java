package dev.abhishek.hospitalmanagement;

import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.PatientRepository;
import dev.abhishek.hospitalmanagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = (List<Patient>) patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods() {
//        Patient patient = patientService.getPatientByID(1L);
//        System.out.println(patient);

//        Patient patient = patientRepository.findByName("Aarav Sharma");
//
//        System.out.println(patient);
//        Patient patient1 = patientRepository.findByBirthDate()

//        List<Patient> patients = patientRepository.findByBirthDateOrEmail(LocalDate.of(2018, 05, 12), "aarav.sharma@example.com");

//        List<Patient> patients = patientRepository.findPatientByNameContainingIgnoreCaseOrderByIdAsc("a");

//        List<Patient> patients = patientRepository.findByBloodGroup(BloodGroupType.O_POSITIVE);

//        List<Patient> patients = patientRepository.findByBornAfterDate(LocalDate.of(1990, 5, 12));
//
//        List<BloodGroupCountResponseDTO> bloodGroupCountResponseEntities = patientRepository.countEachBloodGroupType();
//        System.out.println(bloodGroupCountResponseEntities);
//        for(BloodGroupCountResponseDTO bloodGroupCountResponseEntity: bloodGroupCountResponseEntities){
//            System.out.println(bloodGroupCountResponseEntity);
//        }

//        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(2, 2, Sort.by("name")));

//        int result = patientRepository.updateNameWithId("ram", 1L);
//        System.out.println(result);

//        for (var patient : patientList) {
//            System.out.println(patient);
//        }
    }
}
