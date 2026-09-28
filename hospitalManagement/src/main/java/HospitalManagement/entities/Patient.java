package HospitalManagement.entities;

import HospitalManagement.entities.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime birthDate;
    private String email;
    private String gender;
    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroupType;
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_insurance", unique = true)
    private Insurance insurance; // owning side

    @OneToMany(mappedBy = "patient") //
    private Set<Appointment> appointments = new HashSet<>();
}
