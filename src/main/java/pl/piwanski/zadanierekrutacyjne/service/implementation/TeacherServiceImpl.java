package pl.piwanski.zadanierekrutacyjne.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;
import pl.piwanski.zadanierekrutacyjne.model.dto.TeacherDTO;
import pl.piwanski.zadanierekrutacyjne.repository.StudentRepository;
import pl.piwanski.zadanierekrutacyjne.repository.TeacherRepository;
import pl.piwanski.zadanierekrutacyjne.service.TeacherService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;



    @Override
    public Teacher save(Teacher teacher) {
        teacher.setFirstName(teacher.getFirstName());
        teacher.setLastName(teacher.getLastName());
        teacher.setAge(teacher.getAge());
        teacher.setEmail(teacher.getEmail());
        teacher.setStudents(teacher.getStudents());
        teacher.setSubject(teacher.getSubject());
        teacher.setStudents(teacher.getStudents());
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher register(TeacherDTO teacherDTO) {
        Teacher teacher = teacherDTO.map();
        return teacherRepository.save(teacher);
    }

    @Override
    public void updateEdit(TeacherDTO teacherDTO) {
        Teacher teacher= teacherDTO.map();
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(long id) {
        teacherRepository.deleteTeacherById(id);
    }

    @Override
    public Optional<Teacher> get(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findByFirstName(String firstName) {
        return teacherRepository.findByFirstName(firstName);
    }

    @Override
    public Teacher findByLastName(String lastName) {
        return teacherRepository.findByLastName(lastName);
    }
}
