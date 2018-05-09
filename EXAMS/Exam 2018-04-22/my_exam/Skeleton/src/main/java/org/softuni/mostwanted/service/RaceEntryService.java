package org.softuni.mostwanted.service;

import org.softuni.mostwanted.domain.dto.xml.RaceEntryImportXMLDto;

public interface RaceEntryService {
    void create(RaceEntryImportXMLDto raceEntryImportXMLDto);
}
