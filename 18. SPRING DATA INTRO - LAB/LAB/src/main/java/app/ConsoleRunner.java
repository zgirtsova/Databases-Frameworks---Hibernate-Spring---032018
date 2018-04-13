package app;

import app.model.Course;
import app.model.Homework;
import app.model.Student;
import app.service.CourseService;
import app.service.HomeworkService;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private CourseService courseService;

    @Autowired
    public ConsoleRunner(StudentService studentService, HomeworkService homeworkService, CourseService courseService) {
        this.homeworkService = homeworkService;
        this.studentService = studentService;
        this.courseService = courseService;
    }


    public void run(String... strings ) throws Exception {

        Student john = new Student();
        john.setName("John Vann");
        john.setBirthday(LocalDate.of(1990,12, 30));
        john.setRegistrationDate(LocalDate.now());
        john.setPhoneNumber("0987988979");

        studentService.save(john);

        Set<Student> students = new HashSet<>();
        students.add(john);

        Course javaIntro = new Course();
        javaIntro.setName("Introduction to Java");
        javaIntro.setDescription("Fundamentals to programming with JAVA");
        javaIntro.setPrice(BigDecimal.valueOf(210.20));
        javaIntro.setStartDate(LocalDate.now());
        javaIntro.setEndDate(LocalDate.now().plus(60, DAYS));
        javaIntro.setStudents(students);

        courseService.save(javaIntro);

        Homework homework01 = new Homework();
        homework01.setContent("New Homework");
        homework01.setCourse(javaIntro);
        homework01.setStudent(john);
        homework01.setSubmissionDate(LocalDate.now());

        homeworkService.save(homework01);

    }
}
