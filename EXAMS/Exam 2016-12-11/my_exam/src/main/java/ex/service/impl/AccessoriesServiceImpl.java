package ex.service.impl;

import ex.model.entities.Accessory;
import ex.repository.AccessoriesRepository;
import ex.service.api.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccessoriesServiceImpl implements AccessoriesService{

    @Autowired
    AccessoriesRepository accessoriesRepository;

    @Override
    public void create(Accessory accessory) {
        accessoriesRepository.save(accessory);
    }
}
