package org.softuni.mostwanted.serviceImpl;

import org.softuni.mostwanted.domain.dto.json.RacersImportJSONDto;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.RacerRepository;
import org.softuni.mostwanted.repository.TownRepository;
import org.softuni.mostwanted.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RacerServiceImpl implements RacerService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private RacerRepository racerRepository;

    @Autowired
    private TownRepository townRepository;

    @Override
    public void create(RacersImportJSONDto racerDto) {

        Racer racer = this.modelParser.convert(racerDto, Racer.class);
        String townName = racerDto.getHomeTown();
        //System.out.println(townName);
        Town town = townRepository.findFirstByName(townName);
        racer.setHomeTown(town);
        this.racerRepository.save(racer);
    }
}
