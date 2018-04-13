package app.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    private BigDecimal price;

    private Set<Student> studentSet;
    private Set<Homework> homeworkSet;

    public Course() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "description", columnDefinition = "text")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "start_date", nullable = false)
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date", nullable = false)
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToMany
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name = "course_id",
            referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "student_id",
            referencedColumnName = "id"))
    public Set<Student> getStudents() {
        return studentSet;
    }
    public void setStudents(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    // от един курс, МНОГО домашни
    @OneToMany(mappedBy = "course")
    public Set<Homework> getHomework() {
        return homeworkSet;
    }
    public void setHomework(Set<Homework> homework) {
        this.homeworkSet = homeworkSet;
    }
}
