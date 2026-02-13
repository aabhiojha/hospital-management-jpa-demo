package dev.abhishek.hospitalmanagement.dto.mapper;

import dev.abhishek.hospitalmanagement.dto.appointment.AppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.appointment.CreateAppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.appointment.UpdateAppointmentDTO;
import dev.abhishek.hospitalmanagement.entity.Appointment;
import dev.abhishek.hospitalmanagement.entity.Doctor;
import dev.abhishek.hospitalmanagement.repository.DoctorRepository;
import dev.abhishek.hospitalmanagement.type.AppointmentStatusType;


public class AppointmentMapper {

    private AppointmentMapper() {}

    public static AppointmentDTO toDto(Appointment appointment) {
        if (appointment == null) return null;

        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setReason(appointment.getReason());
        dto.setStatus(appointment.getStatus());
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setPatientId(appointment.getPatient().getId());

        return dto;
    }

    public static Appointment toEntity(CreateAppointmentDTO dto) {
        if (dto == null) return null;

        return Appointment.builder()
                .appointmentTime(dto.getAppointmentTime())
                .reason(dto.getReason())
                .status(AppointmentStatusType.SCHEDULED) // default state
                .build();
    }

    public static Appointment toEntity(
            UpdateAppointmentDTO updateAppointmentDTO,
            Appointment existingAppointment,
            Doctor doctor) {

        if (updateAppointmentDTO.getAppointmentTime() != null) {
            existingAppointment.setAppointmentTime(updateAppointmentDTO.getAppointmentTime());
        }

        if (updateAppointmentDTO.getDoctorId() != null) {
            existingAppointment.setDoctor(doctor);
        }

        if (updateAppointmentDTO.getStatus() != null) {
            existingAppointment.setStatus(updateAppointmentDTO.getStatus());
        }

        if (updateAppointmentDTO.getReason() != null) {
            existingAppointment.setReason(updateAppointmentDTO.getReason());
        }
        return existingAppointment;
    }
}
