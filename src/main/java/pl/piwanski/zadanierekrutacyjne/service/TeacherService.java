package pl.piwanski.zadanierekrutacyjne.service;

import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.model.dto.TeacherDTO;
import pl.piwanski.zadanierekrutacyjne.repository.StudentRepository;
import pl.piwanski.zadanierekrutacyjne.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher register(TeacherDTO teacherDTO);

    void updateEdit (TeacherDTO teacherDTO);

    void delete(long id);
    Optional<Teacher> get(Long id);
    List<Teacher> findAll();

    Teacher findByFirstName(String firstName);

    Teacher findByLastName(String lastName);
}
