package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.dto.doctor.CreateDoctorDTO;
import dev.abhishek.hospitalmanagement.dto.doctor.DoctorDTO;
import dev.abhishek.hospitalmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorServices;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return new ResponseEntity<>(doctorServices.getAllDoctors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> getAllDoctors(@RequestBody CreateDoctorDTO createDoctorDTO) {
        DoctorDTO doctor = doctorServices.createDoctor(createDoctorDTO);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        DoctorDTO doctorDTO = doctorServices.deleteDoctor(id);
        if (doctorDTO != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

