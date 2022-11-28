package pl.piwanski.zadanierekrutacyjne.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, message = "Imię musi mieć conajmniej 2 znaki")
    private String firstName;
    @NotNull
    private String lastName;
    @Min(value = 18, message = "Wiek nie może być mniejszy niż 18")
    private int age;
    @NotNull
    private String specialization;
    @Email(message = "Nieprawidłowy email")
    private String email;
    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers;

}
