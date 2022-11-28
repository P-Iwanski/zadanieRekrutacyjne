package pl.piwanski.zadanierekrutacyjne.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.model.dto.StudentDTO;
import pl.piwanski.zadanierekrutacyjne.repository.StudentRepository;
import pl.piwanski.zadanierekrutacyjne.repository.TeacherRepository;
import pl.piwanski.zadanierekrutacyjne.service.SearchService;
import pl.piwanski.zadanierekrutacyjne.service.StudentService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public Student save(Student student) {
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setAge(student.getAge());
        student.setEmail(student.getEmail());
        student.setTeachers(student.getTeachers());
        student.setSpecialization(student.getSpecialization());
        student.setTeachers(student.getTeachers());
        return studentRepository.save(student);
    }

    @Override
    public Student register(StudentDTO studentDTO) {
        Student student = studentDTO.map();
        return studentRepository.save(student);
    }
    @Override
    public void updateEdit(StudentDTO studentDTO) {
        Student student = studentDTO.map();
        studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteStudentById(id);
    }
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> get(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }


}
