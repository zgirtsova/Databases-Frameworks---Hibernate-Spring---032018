package ex.controller.impl;

import ex.controller.DTOConvertUtil;
import ex.controller.constants.Constants;
import ex.model.dto.CameraImportJsonDto;
import ex.model.dto.LensesImportJsonDto;
import ex.model.entities.BasicCamera;
import ex.model.entities.DSLRCamera;
import ex.model.entities.Lens;
import ex.model.entities.MirrorlessCamera;
import ex.parser.api.Parser;
import ex.service.api.CamerasService;
import ex.service.api.LensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class LensesController {
    private Parser jsonSerializer;
    private LensesService lensesService;

    @Autowired
    public LensesController(@Qualifier(value = "JSONParser") Parser jsonSerializer, LensesService lensesService) {
        this.jsonSerializer = jsonSerializer;
        this.lensesService = lensesService;
    }

    public void importJSON() throws IOException, JAXBException {
        LensesImportJsonDto[] lensesDtos = jsonSerializer.read(LensesImportJsonDto[].class, Constants
                .input_lenses_json);

        for (LensesImportJsonDto lensDto : lensesDtos) {
            Lens lensEntity = null;
            lensEntity = DTOConvertUtil.convert(lensDto, Lens.class);
            lensesService.add(lensEntity);
        }

    }
}

