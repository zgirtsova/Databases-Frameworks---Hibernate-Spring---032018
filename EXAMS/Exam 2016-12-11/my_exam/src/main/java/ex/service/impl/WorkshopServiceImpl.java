package ex.service.impl;

import ex.model.entities.Accessory;
import ex.model.entities.Workshop;
import ex.repository.AccessoriesRepository;
import ex.repository.WorkshopsRepository;
import ex.service.api.AccessoriesService;
import ex.service.api.WorkshopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class WorkshopServiceImpl implements WorkshopsService{

    @Autowired
    WorkshopsRepository workshopsRepository;


    @Override
    public void create(Workshop workshop) {
        workshopsRepository.save(workshop);
    }
}
