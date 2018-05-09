package org.softuni.mostwanted.serviceImpl;

import org.softuni.mostwanted.domain.dto.json.TownImportJSONDto;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.TownRepository;
import org.softuni.mostwanted.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private TownRepository townRepository;

    @Override
    public void create(TownImportJSONDto townDto) {

        Town town = this.modelParser.convert(townDto, Town.class);
        this.townRepository.save(town);
    }
}
