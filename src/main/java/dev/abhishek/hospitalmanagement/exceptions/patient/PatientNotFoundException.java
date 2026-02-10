package dev.abhishek.hospitalmanagement.exceptions.patient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(Long id){
        super("Patient with id " + id + " not found");
    }

    public PatientNotFoundException(String str){
        super("Patient with " + str + " not found");
    }

}
