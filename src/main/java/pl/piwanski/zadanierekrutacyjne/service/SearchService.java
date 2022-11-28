package pl.piwanski.zadanierekrutacyjne.service;

import org.springframework.stereotype.Service;
import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.repository.StudentRepository;
import pl.piwanski.zadanierekrutacyjne.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public interface SearchService {


    List<Teacher> searchT(String firstName, String lastName);
    List<Student> searchS(String firstName, String lastName);
}
