package org.softuni.mostwanted.service;

import org.softuni.mostwanted.domain.dto.json.RacersImportJSONDto;
import org.softuni.mostwanted.domain.dto.xml.RaceImportWrapper;
import org.softuni.mostwanted.domain.dto.xml.RaceImportXMLDto;

public interface RaceService {
    void create(RaceImportXMLDto raceDto);

}
