package ex.controller.impl;

import ex.controller.DTOConvertUtil;
import ex.controller.constants.Constants;
import ex.io.interfaces.ConsoleIO;
import ex.model.dto.LensesImportJsonDto;
import ex.model.dto.PhotographersImportJsonDto;
import ex.model.entities.Lens;
import ex.parser.api.Parser;
import ex.service.api.LensesService;
import ex.service.api.PhotographersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class PhotographersController {

    @Autowired
    @Qualifier(value = "JSONParser")
    private Parser jsonParser;
    @Autowired
    private PhotographersService photographersService;
    @Autowired
    private ConsoleIO consoleIO;

//    @Autowired
//    public PhotographersController(@Qualifier(value = "JSONParser") Parser jsonParser, PhotographersService photographersService) {
//        this.jsonParser = jsonParser;
//        this.photographersService = photographersService;
//    }

    public void importJSON() throws IOException, JAXBException {
        PhotographersImportJsonDto[] photographerDtos = null;
        try {
            photographerDtos = this.jsonParser.read(PhotographersImportJsonDto[].class, Constants.input_photographers_json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (PhotographersImportJsonDto photographerDto : photographerDtos) {
            try {
                int size = this.photographersService.create(photographerDto);
                this.consoleIO.write(String.format("Successfully imported %s %s | Lenses: %d", photographerDto.getFirstName(), photographerDto.getLastName(), size));
            } catch (Exception e) {
                this.consoleIO.write("Error. Invalid data provided");
            }
        }

    }

}
