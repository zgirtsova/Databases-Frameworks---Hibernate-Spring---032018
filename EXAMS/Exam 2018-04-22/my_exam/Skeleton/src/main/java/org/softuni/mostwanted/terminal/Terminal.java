package org.softuni.mostwanted.terminal;

import org.softuni.mostwanted.config.Config;
import org.softuni.mostwanted.domain.dto.json.CarsImportJSONDto;
import org.softuni.mostwanted.domain.dto.json.DistrictImportJSONDto;
import org.softuni.mostwanted.domain.dto.json.RacersImportJSONDto;
import org.softuni.mostwanted.domain.dto.json.TownImportJSONDto;
import org.softuni.mostwanted.domain.dto.xml.RaceEntriesImportXMLDto;
import org.softuni.mostwanted.domain.dto.xml.RaceEntryImportXMLDto;
import org.softuni.mostwanted.domain.dto.xml.RaceImportWrapper;
import org.softuni.mostwanted.domain.dto.xml.RaceImportXMLDto;
import org.softuni.mostwanted.io.interfaces.ConsoleIO;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "JSONParser")
    private Parser jsonParser;

    @Autowired
    @Qualifier(value = "XMLParser")
    private Parser xmlParser;

    @Autowired
    private ConsoleIO consoleIO;

    @Autowired
    private TownService townService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private RacerService racerService;

    @Autowired
    private CarService carService;

    @Autowired
    private RaceEntryService raceEntryService;

    @Autowired
    private RaceService raceService;

    @Autowired
    public Terminal() { }

    @Override
    public void run(String... args) throws Exception {

        //Import
       this.importTownsFromJson();
       this.importDistrictsFromJson();
       this.importRacersFromJson();
       this.importCarsFromJson();
       this.importRaceEntriesFromXML();
       this.importRacesFromXML();
    }

    private void importTownsFromJson() {
        TownImportJSONDto[] townDtos = null;
        try {
            townDtos = this.jsonParser.read(TownImportJSONDto[].class, Config.TOWNS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (TownImportJSONDto townDto : townDtos) {
            try {
                this.townService.create(townDto);
                this.consoleIO.write(String.format("Successfully imported Town - %s.", townDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write("Error: Incorrect Data!");
            }
        }
    }

    private void importDistrictsFromJson() {
        DistrictImportJSONDto[] districtDtos = null;
        try {
            districtDtos = this.jsonParser.read(DistrictImportJSONDto[].class, Config.DISTRICTS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (DistrictImportJSONDto districtDto : districtDtos) {
            try {
                this.districtService.create(districtDto);
                this.consoleIO.write(String.format("Successfully imported District - %s.", districtDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write("Error: Incorrect Data!");
            }
        }
    }

    private void importRacersFromJson() {
        RacersImportJSONDto[] racersDtos = null;
        try {
            racersDtos = this.jsonParser.read(RacersImportJSONDto[].class, Config.RACERS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (RacersImportJSONDto racersDto : racersDtos) {
            try {
                this.racerService.create(racersDto);
                this.consoleIO.write(String.format("Successfully imported Racer - %s.", racersDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write("Error: Incorrect Data!");
            }
        }
    }

    private void importCarsFromJson() {
        CarsImportJSONDto[] carsDtos = null;
        try {
            carsDtos = this.jsonParser.read(CarsImportJSONDto[].class, Config.CARS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (CarsImportJSONDto carsDto : carsDtos) {
            try {
                this.carService.create(carsDto);
                this.consoleIO.write(String.format("Successfully imported Car - %s.", carsDto.getBrand()));
            } catch (Exception e) {
                this.consoleIO.write("Error: Incorrect Data!");
            }
        }
    }

    private void importRaceEntriesFromXML() {
        RaceEntriesImportXMLDto raceEntriesDto = null;
        try {
            raceEntriesDto = this.xmlParser.read(RaceEntriesImportXMLDto.class, Config.RACE_ENTRIES_IMPORT_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (RaceEntryImportXMLDto raceEntryDto : raceEntriesDto.getRaceEntryImportXMLDtos()) {
            try {
                this.raceEntryService.create(raceEntryDto);
                this.consoleIO.write(String.format("Successfully imported %s", raceEntryDto.getCarId()));
            } catch (Exception e) {
                this.consoleIO.write("Error. Invalid data provided");
            }
        }
    }

    private void importRacesFromXML() {
        RaceImportWrapper raceImportWrapper = null;
        try {
            raceImportWrapper = this.xmlParser.read(RaceImportWrapper.class, Config.RACES_IMPORT_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (RaceImportXMLDto raceImportXMLDto : raceImportWrapper.getRaces()) {
            try {
                this.raceService.create(raceImportXMLDto);
                this.consoleIO.write(String.format("Successfully imported %s", raceImportXMLDto.getDistrictName()));
            } catch (Exception e) {
                this.consoleIO.write("Error. Invalid data provided");
            }
        }
    }
}
