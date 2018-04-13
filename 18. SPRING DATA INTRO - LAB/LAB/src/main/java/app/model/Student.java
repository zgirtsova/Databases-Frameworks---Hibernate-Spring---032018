package app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    private Long id;
    private String name;
    private String phoneNumber;
    private LocalDate registrationDate;
    private LocalDate birthday;

    private Set<Course> courseSet;
    private Set<Homework> homeworkSet;

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "registration_date", nullable = false)
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "birthday")
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @ManyToMany(mappedBy = "students")
    public Set<Course> getCourses() {
        return courseSet;
    }
    public void setCourses(Set<Course> courses) {
        this.courseSet = courseSet;
    }

    @OneToMany(mappedBy = "student") // имаме 1 студент към МНОГО домашни
    public Set<Homework> getHomeworkSet() {
        return homeworkSet;
    }
    public void setHomeworkSet(Set<Homework> homeworkSet) {
        this.homeworkSet = homeworkSet;
    }
}
