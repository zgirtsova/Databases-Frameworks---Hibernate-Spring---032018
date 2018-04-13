package app.service;

import java.time.LocalDate;
import java.util.List;

public interface HomeworkService <Homework, Long> {

    Homework findById(Long id);

    List<Homework> findAll();

    void save(Homework homework);

    void remove(Homework homework);

}
