package dev.abhishek.hospitalmanagement.dto.mapper;

import dev.abhishek.hospitalmanagement.dto.doctor.CreateDoctorDTO;
import dev.abhishek.hospitalmanagement.dto.doctor.DoctorDTO;
import dev.abhishek.hospitalmanagement.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    private DoctorMapper() {
        // prevent instantiation
    }

    // Entity -> DoctorDTO (for responses)
    public static DoctorDTO toDTO(Doctor doctor) {
        if (doctor == null) {
            return null;
        }

        DoctorDTO dto = new DoctorDTO();
        dto.setName(doctor.getName());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setEmail(doctor.getEmail());
        dto.setCreatedAt(doctor.getCreatedAt());

        return dto;
    }

    // CreateDoctorDTO -> Entity (for creating new doctor)
    public static Doctor toEntity(CreateDoctorDTO createDoctorDTO) {
        if (createDoctorDTO == null) {
            return null;
        }

        Doctor doctor = new Doctor();
        doctor.setName(createDoctorDTO.getName());
        doctor.setEmail(createDoctorDTO.getEmail());

        return doctor;
    }

    // Optional: update existing entity from CreateDoctorDTO
    public static void updateEntityFromDTO(CreateDoctorDTO dto, Doctor doctor) {
        if (dto == null || doctor == null) {
            return;
        }

        if (dto.getName() != null) {
            doctor.setName(dto.getName());
        }

        if (dto.getEmail() != null) {
            doctor.setEmail(dto.getEmail());
        }
    }


}

