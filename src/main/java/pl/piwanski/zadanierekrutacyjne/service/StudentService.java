package pl.piwanski.zadanierekrutacyjne.service;

import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.model.dto.StudentDTO;
import pl.piwanski.zadanierekrutacyjne.model.dto.TeacherDTO;


import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);

    Student register(StudentDTO studentDTO);
    void updateEdit (StudentDTO studentDTO);

    void delete(long id);

    List<Student> findAll();
    Optional<Student> get(Long id);

    Student findByFirstName(String firstName);

    Student findByLastName(String lastName);
}
