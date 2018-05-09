package org.softuni.mostwanted.service;

import org.softuni.mostwanted.domain.dto.json.TownImportJSONDto;

public interface TownService {
    void create(TownImportJSONDto townDto);
}
