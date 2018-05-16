package ex.controller;

import ex.controller.impl.*;
import ex.parser.api.Parser;
import ex.service.api.WorkshopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class Terminal implements CommandLineRunner {
    @Autowired
    @Qualifier(value = "JSONParser")
    private Parser jsonParser;

    @Autowired
    @Qualifier(value = "XMLParser")
    private Parser xmlParser;

    @Autowired
    private WorkshopsService workshopsService;

    @Autowired
    private CamerasController camerasController;

    @Autowired
    private LensesController lensesController;

    @Autowired
    private AccessoriesController accessoriesController;

    @Autowired
    private PhotographersController photographersController;

    @Autowired
    private WorkshopsController workshopsController;

    @Override
    public void run(String... args) throws Exception {

        camerasController.importJSON();
        lensesController.importJSON();
        photographersController.importJSON();
    }
}
