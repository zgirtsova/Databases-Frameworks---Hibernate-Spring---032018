package app.terminal;

import app.domain.dto.json.PersonDTO;
import app.domain.model.Person;
import app.serialize.Serializer;
import app.service.PersonService;
import app.utils.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static app.domain.dto.DTOConvertUtil.convert;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    @Autowired
    private Serializer serializer;

    public static final String PERSON_INPUT_JSON = "files/input/json/person.json";
    public static final String PERSONS_INPUT_JSON = "files/input/json/persons.json";
    public static final String PERSONS_OUTPUT_JSON = "src/main/resources/files/output/json/persons.json";


    @Override
    public void run(String... strings) throws Exception {

        importPersonJSON();
    }

    private void importPerson(PersonDTO personDTO) {

        Person person = convert(personDTO, Person.class);
        personService.create(person);

//        PersonDTO personDTO1 = convert(person, PersonDTO.class);
//
//        System.out.println(person.toString());
//        System.out.println(personDTO1.toString());
    }

    private void importPersonJSON() throws IOException {

        PersonDTO personDTO = serializer.deserialize(PersonDTO.class, PERSON_INPUT_JSON);
        importPerson(personDTO);
    }

    private void importPersonsJSON() throws IOException {
        PersonDTO[] personDTOS = serializer.deserialize(PersonDTO[].class, PERSONS_INPUT_JSON);
        for (PersonDTO personDTO : personDTOS) {
            importPerson(personDTO);
        }
    }
}










