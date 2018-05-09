package org.softuni.mostwanted.service;

import org.softuni.mostwanted.domain.dto.json.CarsImportJSONDto;

public interface CarService {
    void create(CarsImportJSONDto carDto);
}
