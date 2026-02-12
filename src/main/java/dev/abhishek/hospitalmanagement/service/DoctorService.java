package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.dto.doctor.CreateDoctorDTO;
import dev.abhishek.hospitalmanagement.dto.doctor.DoctorDTO;
import dev.abhishek.hospitalmanagement.dto.mapper.DoctorMapper;
import dev.abhishek.hospitalmanagement.dto.mapper.PatientMapper;
import dev.abhishek.hospitalmanagement.entity.Doctor;
import dev.abhishek.hospitalmanagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final PatientMapper patientMapper;

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> allDoctors = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : allDoctors) {
            DoctorDTO dto = DoctorMapper.toDTO(doctor);
            doctorDTOS.add(dto);
        }
        return doctorDTOS;
    }

    // create doctor entry
    public DoctorDTO createDoctor(CreateDoctorDTO dto) {
        Doctor doctorEntity = DoctorMapper.toEntity(dto);
        System.out.println(doctorEntity);
        doctorRepository.save(doctorEntity);
        return DoctorMapper.toDTO(doctorEntity);
    }

    // delete doctor entry
    public DoctorDTO deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor != null) {
            doctorRepository.delete(doctor);
        }
        return null;
    }

}
