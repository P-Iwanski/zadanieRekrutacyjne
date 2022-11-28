package pl.piwanski.zadanierekrutacyjne.model.dto;

import lombok.Data;
import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class StudentDTO {
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
    private Set<Teacher> teachers;

    public Student map(){
        Student student = new Student();
        student.setFirstName(this.firstName);
        student.setLastName(this.lastName);
        student.setEmail(this.email);
        student.setAge(this.age);
        student.setSpecialization(this.specialization);
        student.setTeachers(this.teachers);
        return student;
    }
}
