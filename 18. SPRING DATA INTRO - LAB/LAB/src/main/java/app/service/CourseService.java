package app.service;

import app.model.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseService<Course, Long> {

    Course findById(Long id);

    List<Course> findAll();

    void save(Course course);

    void remove(Course course);

    List<app.model.Course> findAllByStartDate(LocalDate startDate);

}
