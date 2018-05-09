package org.softuni.mostwanted.serviceImpl;

import org.softuni.mostwanted.domain.dto.json.CarsImportJSONDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.CarRepository;
import org.softuni.mostwanted.repository.RacerRepository;
import org.softuni.mostwanted.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RacerRepository racerRepository;

    @Override
    public void create(CarsImportJSONDto carDto) {

        Car car = this.modelParser.convert(carDto, Car.class);
        String racerName = carDto.getRacer();
        Racer racer = racerRepository.findFirstByName(racerName);
        car.setRacer(racer);
        this.carRepository.save(car);
    }
}
