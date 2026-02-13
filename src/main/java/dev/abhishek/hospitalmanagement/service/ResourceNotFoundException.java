package dev.abhishek.hospitalmanagement.service;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String s) {
        System.out.println(s);
    }
}
