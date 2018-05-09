package org.softuni.mostwanted.serviceImpl;

import org.softuni.mostwanted.domain.dto.json.DistrictImportJSONDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.DistrictRepository;
import org.softuni.mostwanted.repository.TownRepository;
import org.softuni.mostwanted.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private TownRepository townRepository;

    @Override
    public void create(DistrictImportJSONDto districtDto) {

        District district = this.modelParser.convert(districtDto, District.class);
        String townName = districtDto.gettownName();
        Town town = townRepository.findFirstByName(townName);
        district.setTown(town);
        this.districtRepository.save(district);
    }
}
