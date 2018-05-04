package app.terminal;

import app.domain.dto.json.PersonDTO;
import app.service.PersonService;
import app.utils.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final PersonService personService;
    private final JsonParser jsonParser;

    public static final String PERSON_INPUT_JSON = "files/input/json/person.json";
    public static final String PERSONS_INPUT_JSON = "files/input/json/persons.json";
    public static final String PERSON_OUTPUT_JSON = "src/main/resources/files/output/json/person.json";

    @Autowired
    public Terminal(final PersonService personService,
                    final JsonParser jsonParser) {
        this.personService = personService;
        this.jsonParser = jsonParser;
    }

    @Override
    public void run(String... strings) throws Exception {
        PersonDTO[] personDTOS = this.jsonParser.getFromFile(PersonDTO[].class, "files/input/json/persons.json");
        for (final PersonDTO personDTO : personDTOS) {
            this.personService.create(personDTO);
        }

//        PersonDTO personDTO = this.jsonParser.getFromFile(PersonDTO.class, "files/input/json/person.json");
//            this.personService.create(personDTO);



        PersonDTO personDTO = this.personService.getPersonDtoFromId(1);
        this.jsonParser.writeToFile(personDTO, "files/output/json/person.json"); // target/classes/json/output/person.json
        System.out.println(this.jsonParser.toJson(personDTO));
    }
}
