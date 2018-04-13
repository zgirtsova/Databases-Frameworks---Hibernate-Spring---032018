package app.serviceImpl;

import app.model.Course;
import app.repository.CourseRepository;
import app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService<Course, Long>{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.getOne(id);
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public void save(Course student) {
        this.courseRepository.save(student);
    }

    @Override
    public void remove(Course student) {
        this.courseRepository.delete(student);
    }

    @Override
    public List<Course> findAllByStartDate(LocalDate startDate) {
        return this.courseRepository.findAllByStartDate(startDate);
    }
}
