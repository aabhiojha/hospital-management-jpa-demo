package dev.abhishek.hospitalmanagement.service;

import dev.abhishek.hospitalmanagement.dto.appointment.AppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.appointment.CreateAppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.appointment.UpdateAppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.mapper.AppointmentMapper;
import dev.abhishek.hospitalmanagement.entity.Appointment;
import dev.abhishek.hospitalmanagement.entity.Doctor;
import dev.abhishek.hospitalmanagement.entity.Patient;
import dev.abhishek.hospitalmanagement.repository.AppointmentRepository;
import dev.abhishek.hospitalmanagement.repository.DoctorRepository;
import dev.abhishek.hospitalmanagement.type.AppointmentStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//    TODO: Proper Error handling

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final DoctorRepository doctorRepository;

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> allAppointments = appointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (Appointment appointment : allAppointments) {
            AppointmentDTO dto = AppointmentMapper.toDto(appointment);
            dto.setDoctorId(appointment.getDoctor().getId());
            dto.setPatientId(appointment.getPatient().getId());
            appointmentDTOS.add(dto);
        }
        return appointmentDTOS;
    }


    public AppointmentDTO createAppointment(
            CreateAppointmentDTO createAppointmentDTO,
            // doctor id for assigning doctor
            Long doctorId,
            // patient id just for assigning it to user
            // later this will be done via spring security
            Long patientId
    ) {
        Appointment appointmentEntity = AppointmentMapper.toEntity(createAppointmentDTO);
        appointmentEntity.setAppointmentTime(createAppointmentDTO.getAppointmentTime());
        appointmentEntity.setReason(createAppointmentDTO.getReason());
        appointmentEntity.setStatus(AppointmentStatusType.SCHEDULED);

        Patient patientByID = patientService.getPatientByID(patientId);
        Doctor doctorById = doctorService.getById(doctorId);

        // need to add patient
        appointmentEntity.setPatient(patientByID);
        // need to assign doctor
        appointmentEntity.setDoctor(doctorById);
        appointmentRepository.save(appointmentEntity);

        return AppointmentMapper.toDto(appointmentEntity);
    }


    @Transactional
    public AppointmentDTO updateAppointment(UpdateAppointmentDTO updateAppointmentDTO) {
        // find the appointment in question
        Optional<Appointment> appointmentObject = appointmentRepository.findById(updateAppointmentDTO.getId());

        if (appointmentObject.isEmpty()) {
            return null;
        }

        // find the doctor object mentioned in the request
        Optional<Doctor> doctorObj = doctorRepository.findById(updateAppointmentDTO.getDoctorId());
        if (doctorObj.isEmpty()) {
            return null;
        }

        Appointment appointment = AppointmentMapper.toEntity(updateAppointmentDTO, appointmentObject.get(), doctorObj.get());
        Appointment savedObj = appointmentRepository.save(appointment);
        return AppointmentMapper.toDto(savedObj);
    }



}
