package pl.piwanski.zadanierekrutacyjne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piwanski.zadanierekrutacyjne.model.Student;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from students s where s.firstName=:firstName")
    Student findByFirstName(@Param("firstName") String firstName);

    @Query("select s from students s where s.lastName=:lastName")
    Student findByLastName(@Param("lastName") String lastName);

    List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);

    @Modifying
    void deleteStudentById(Long id);
}
