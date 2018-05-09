package org.softuni.mostwanted.service;

import org.softuni.mostwanted.domain.dto.json.RacersImportJSONDto;

public interface RacerService {
    void create(RacersImportJSONDto racerDto);
}
