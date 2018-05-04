package app.service;

import app.domain.dto.json.PersonDTO;
import app.domain.model.Person;
import app.repository.PersonRepository;
import app.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void create(Person person) {
        personRepository.saveAndFlush(person);
    }

    @Override
    public void create(final PersonDTO personDTO) {
        Person person = getPersonFromPersonDto(personDTO);
        this.personRepository.saveAndFlush(person);
    }

    private Person getPersonFromPersonDto(final PersonDTO personDTO) {
        Person person = ObjectMapper.getInstance().map(personDTO, Person.class);
        person.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setPerson(person));
        return person;
    }

    @Override
    public Person findById(long id) {
        return this.personRepository.findById(id).orElse(null);
    }

    @Override
    public PersonDTO getPersonDtoFromId(final long id) {
        Person person = this.findById(id);
        if (person != null) {
            return ObjectMapper.getInstance().map(person, PersonDTO.class);
        }
        return null;
    }

    @Override
    public List<Person> findByCountry(String country) {
        return this.personRepository.findByCountry(country);
    }
}
