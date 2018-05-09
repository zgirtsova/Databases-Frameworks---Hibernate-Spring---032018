package org.softuni.mostwanted.service;

import org.softuni.mostwanted.domain.dto.json.DistrictImportJSONDto;

public interface DistrictService {
    void create(DistrictImportJSONDto districtDto);
}
