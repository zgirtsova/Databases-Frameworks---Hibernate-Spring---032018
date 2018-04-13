package app.repository;

import app.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.name, c.description, c.startDate FROM Course AS c")
    List<Course> findAllByStartDate(LocalDate startDate);
}
