package dev.abhishek.hospitalmanagement.controller;

import dev.abhishek.hospitalmanagement.dto.appointment.AppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.appointment.CreateAppointmentDTO;
import dev.abhishek.hospitalmanagement.dto.appointment.UpdateAppointmentDTO;
import dev.abhishek.hospitalmanagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> allAppointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(allAppointments, HttpStatus.OK);
    }

    @PostMapping("/{doctorId}/{patientId}")
    public ResponseEntity<AppointmentDTO> createAppointment(
            @RequestBody CreateAppointmentDTO appointmentDTO,
            @PathVariable Long doctorId,
            @PathVariable Long patientId
    ) {
        AppointmentDTO appointmentDto = appointmentService.createAppointment(appointmentDTO, doctorId, patientId);
        return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AppointmentDTO> updateAppointment(
            @RequestBody UpdateAppointmentDTO updateAppointmentDTO
    ) {
        AppointmentDTO appointmentDTO = appointmentService.updateAppointment(updateAppointmentDTO);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
    }

}
