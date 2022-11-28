package pl.piwanski.zadanierekrutacyjne.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity(name = "teachers")
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Imię musi mieć conajmniej 2 znaki")
    private String firstName;
    @NotEmpty
    private String lastName;
    @Min(value = 18, message = "Wiek nie może być mniejszy niż 18")
    private int age;
    @NotEmpty
    private String subject;
    @NotEmpty
    @Email(message = "Nieprawidłowy email")
    private String email;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany (cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "teachers_students",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;


}
