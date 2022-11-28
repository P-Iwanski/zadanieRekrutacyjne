package pl.piwanski.zadanierekrutacyjne.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.repository.StudentRepository;
import pl.piwanski.zadanierekrutacyjne.repository.TeacherRepository;
import pl.piwanski.zadanierekrutacyjne.service.SearchService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<Teacher> searchT(String firstName, String lastName) {
        List<Teacher> result = new ArrayList<>();
        result = teacherRepository.findAllByFirstNameAndLastName(firstName, lastName);
        return result;
    }

    @Override
    public List<Student> searchS(String firstName, String lastName) {
        List<Student> result = new ArrayList<>();
        result = studentRepository.findAllByFirstNameAndLastName(firstName, lastName);
        return result;
    }
}
