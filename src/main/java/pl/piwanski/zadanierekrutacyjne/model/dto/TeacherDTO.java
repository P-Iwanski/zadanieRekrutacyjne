package pl.piwanski.zadanierekrutacyjne.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class TeacherDTO {
    @Size(min = 2)
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Min(18)
    @NotNull
    private int age;
    @NotEmpty
    private String subject;
    @NotEmpty
    @Email(message = "Nieprawidłowy email")
    private String email;

    private Set<Student> students;

    public Teacher map(){
        Teacher teacher = new Teacher();
        teacher.setFirstName(this.firstName);
        teacher.setLastName(this.lastName);
        teacher.setEmail(this.email);
        teacher.setAge(this.age);
        teacher.setSubject(this.subject);
        teacher.setStudents(this.students);
        return teacher;
    }
}
