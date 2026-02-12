package dev.abhishek.hospitalmanagement.dto.mapper;

import dev.abhishek.hospitalmanagement.dto.appointment.AppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.appointment.CreateAppointmentDTO;
import dev.abhishek.hospitalmanagement.entity.Appointment;
import dev.abhishek.hospitalmanagement.type.AppointmentStatusType;

//public class AppointmentMapper {
//
//    public static AppointmentDTO toDto(Appointment appointment) {
//        if (appointment == null) {
//            return null;
//        }
//
//        AppointmentDTO appointmentDTO = new AppointmentDTO();
//        appointmentDTO.setId(appointment.getId());
//        appointmentDTO.setAppointmentTime(appointment.getAppointmentTime());
//        appointmentDTO.setReason(appointment.getReason());
//        appointmentDTO.setStatus(appointment.getStatus());
////        appointment.setDoctor(appointment.getDoctor());
////        appointment.setPatient(appointment.getPatient());
//
//        return appointmentDTO;
//    }
//
//    public static Appointment toEntity(CreateAppointmentDTO createAppointmentDTO) {
//        if (createAppointmentDTO == null) {
//            return null;
//        }
//        Appointment appointment = new Appointment();
//        appointment.setAppointmentTime(createAppointmentDTO.getAppointmentTime());
//        appointment.setReason(createAppointmentDTO.getReason());
////        createAppointmentDTO.setDoctor(appointment.getDoctor());
////        createAppointmentDTO.setPatient(appointment.getPatient());
//
//        return appointment;
//    }
//}


public class AppointmentMapper {

    private AppointmentMapper() {}

    public static AppointmentDTO toDto(Appointment appointment) {
        if (appointment == null) return null;

        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setReason(appointment.getReason());
        dto.setStatus(appointment.getStatus());

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
}
