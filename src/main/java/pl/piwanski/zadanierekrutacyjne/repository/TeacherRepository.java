package pl.piwanski.zadanierekrutacyjne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piwanski.zadanierekrutacyjne.model.Teacher;

import java.util.List;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
   @Query("select t from teachers t where t.firstName=:firstName")
    Teacher findByFirstName(@Param("firstName") String firstName);

    @Query("select t from teachers t where t.lastName=:lastName")
    Teacher findByLastName(@Param("lastName") String lastName);


    List<Teacher> findAllByFirstNameAndLastName(String firstName, String lastName);

    @Modifying
    void deleteTeacherById(Long id);
}
