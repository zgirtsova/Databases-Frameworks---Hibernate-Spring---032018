package app.repository;

import app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s.name FROM Student AS s JOIN s.homeworkSet AS h")
    List<Object[]> getStudentsAndHomeworkSubmissions();

    @Query("SELECT s.name, s.courses.size, SUM(c.price) AS totalPrice FROM Student AS s " +
            "JOIN s.courses AS c GROUP BY s.name ORDER BY Sum(c.price) DESC")
    List<Object[]> getAllStudentsAndCoursesEnrolledAndTotalPrice();


}