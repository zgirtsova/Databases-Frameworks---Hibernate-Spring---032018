package app.service;

import app.domain.dto.json.PersonDTO;
import app.domain.model.Person;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface PersonService {

    void create(Person person);

    void create(PersonDTO personDTO);

    Person findById(long id);

    PersonDTO getPersonDtoFromId(long id);

    List<Person> findByCountry(String country);
}
