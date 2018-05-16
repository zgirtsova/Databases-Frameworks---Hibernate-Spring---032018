package ex.controller.impl;

import ex.controller.DTOConvertUtil;
import ex.controller.constants.Constants;
import ex.io.interfaces.ConsoleIO;
import ex.model.dto.CameraImportJsonDto;
import ex.model.entities.BasicCamera;
import ex.model.entities.DSLRCamera;
import ex.model.entities.MirrorlessCamera;
import ex.parser.api.Parser;
import ex.service.api.CamerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class CamerasController {
    private Parser jsonSerializer;
    private CamerasService camerasService;

    @Autowired
    private ConsoleIO consoleIO;

    @Autowired
    public CamerasController(@Qualifier(value = "JSONParser") Parser jsonSerializer, CamerasService camerasService) {
        this.jsonSerializer = jsonSerializer;
        this.camerasService = camerasService;
    }

    public void importJSON() throws IOException, JAXBException {
        CameraImportJsonDto[] cameraDtos = jsonSerializer.read(CameraImportJsonDto[].class, Constants
                .input_camera_json);

            for (CameraImportJsonDto cameraDto : cameraDtos) {
                BasicCamera basicCamera = null;
                if ("DSLR".equals(cameraDto.getType())) {
                    try {
                        basicCamera = DTOConvertUtil.convert(cameraDto, DSLRCamera.class);
                        camerasService.add(basicCamera);
                        this.consoleIO.write(String.format("Successfully imported %s %s %s", cameraDto.getType(), cameraDto
                                .getMake(), cameraDto.getModel()));
                    } catch (Exception e) {
                        this.consoleIO.write("Error. Invalid data provided");
                    }
                    //validation should be implemented in the service
                } else if ("Mirrorless".equals(cameraDto.getType())) {
                    try {
                        basicCamera = DTOConvertUtil.convert(cameraDto, MirrorlessCamera.class);
                        camerasService.add(basicCamera);
                        this.consoleIO.write(String.format(
                                "Successfully imported %s %s %s", cameraDto.getType(), cameraDto.getMake(),
                                cameraDto.getModel()));
                    } catch (Exception e) {
                        this.consoleIO.write("Error. Invalid data provided");
                    }
                }
            }

        }
}

