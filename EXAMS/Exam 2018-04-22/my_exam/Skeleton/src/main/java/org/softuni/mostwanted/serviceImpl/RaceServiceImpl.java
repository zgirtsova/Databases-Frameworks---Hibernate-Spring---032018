package org.softuni.mostwanted.serviceImpl;

import org.softuni.mostwanted.domain.dto.xml.RaceImportXMLDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.DistrictRepository;
import org.softuni.mostwanted.repository.RaceEntryRepository;
import org.softuni.mostwanted.repository.RaceRepository;
import org.softuni.mostwanted.service.RaceEntryService;
import org.softuni.mostwanted.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private RaceEntryRepository raceEntryService;


    @Override
    public void create(RaceImportXMLDto raceDto) {
        Race race = this.modelParser.convert(raceDto, Race.class);

        District district = districtRepository.findFirstByName(raceDto.getDistrictName());

        Set<RaceEntry> raceEntries = raceDto.getEntries()
                .stream()
                .map(entry -> this.raceEntryService.findFirstById(entry.getId()))
                .collect(Collectors.toSet());

        race.setDistrict(district);
        race.setEntries(raceEntries);

        this.raceRepository.saveAndFlush(race);

        //raceEntries.forEach(raceEntry -> raceEntry.setRace(race));

    }
}
