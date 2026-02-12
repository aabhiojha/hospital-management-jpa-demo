package dev.abhishek.hospitalmanagement.dto.mapper;

import dev.abhishek.hospitalmanagement.dto.appointment.AppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.doctor.CreateDoctorDTO;
import dev.abhishek.hospitalmanagement.entity.Appointment;

public class AppointmentMapper {

    public AppointmentDTO toDto(Appointment appointment) {
        if (appointment == null) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setAppointmentTime(appointment.getAppointmentTime());
        appointmentDTO.setReason(appointment.getReason());
        appointmentDTO.setStatus(appointment.getStatus());
//        appointment.setDoctor(appointment.getDoctor());
//        appointment.setPatient(appointment.getPatient());

        return appointmentDTO;
    }

    public Appointment toEntity(CreateDoctorDTO createDoctorDTO) {
        if (createDoctorDTO == null) {
            return null;
        }
        Appointment appointment = new Appointment();
        appointment.setAppointmentTime(appointment.getAppointmentTime());
        appointment.setReason(appointment.getReason());
        appointment.setStatus(appointment.getStatus());
//        appointment.setDoctor(appointment.getDoctor());
//        appointment.setPatient(appointment.getPatient());

        return appointment;
    }
}
