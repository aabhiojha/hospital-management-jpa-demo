package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.dto.doctor.CreateDoctorDTO;
import dev.abhishek.hospitalmanagement.dto.doctor.DoctorDTO;
import dev.abhishek.hospitalmanagement.entity.Doctor;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.service.DoctorServices;
import dev.abhishek.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorServices doctorServices;
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        return new ResponseEntity<>(doctorServices.getAllDoctors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> getAllDoctors(@RequestBody CreateDoctorDTO createDoctorDTO){
        DoctorDTO doctor = doctorServices.createDoctor(createDoctorDTO);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

}

