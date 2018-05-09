package org.softuni.mostwanted.serviceImpl;

import org.softuni.mostwanted.domain.dto.xml.RaceEntryImportXMLDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.CarRepository;
import org.softuni.mostwanted.repository.RaceEntryRepository;
import org.softuni.mostwanted.repository.RacerRepository;
import org.softuni.mostwanted.service.RaceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RaceEntryImpl implements RaceEntryService {

    @Autowired
    private RaceEntryRepository raceEntryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RacerRepository racerRepository;

    @Autowired
    private ModelParser modelParser;


    @Override
    public void create(RaceEntryImportXMLDto raceEntryImportXMLDto) {
        String racerName = raceEntryImportXMLDto.getRacerName();
        Racer racer = racerRepository.findFirstByName(racerName);

        int carId = raceEntryImportXMLDto.getCarId();
        Car car = carRepository.findFirstById(carId);

        RaceEntry raceEntry = this.modelParser.convert(raceEntryImportXMLDto, RaceEntry.class);
        raceEntry.setRacer(racer);
        raceEntry.setCar(car);

        this.raceEntryRepository.save(raceEntry);
    }
}
