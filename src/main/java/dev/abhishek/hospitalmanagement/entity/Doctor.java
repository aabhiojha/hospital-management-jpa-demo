package dev.abhishek.hospitalmanagement.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointment;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();

}
