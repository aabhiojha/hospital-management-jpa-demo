package dev.abhishek.hospitalmanagement.type;

public enum AppointmentStatusType {
    SCHEDULED,   // booked but not yet happened
    CONFIRMED,   // explicitly acknowledged
    COMPLETED,   // successfully finished
    CANCELLED    // will not happen
}
