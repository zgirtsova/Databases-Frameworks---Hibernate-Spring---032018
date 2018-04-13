package app.service;

import java.util.List;

public interface StudentService<Student, Long>  {
    Student findById(Long id);

    List<Student> findAll();

    void save(Student student);

    void remove(Student student);

    List<Object[]> getStudentsAndHomeworkSubmissions();

    List<Object[]> getAllStudentsAndCoursesEnrolledAndTotalPrice();

}
