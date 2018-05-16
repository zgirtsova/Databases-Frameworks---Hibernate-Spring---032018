package ex.service.impl;

import ex.model.entities.Accessory;
import ex.model.entities.Lens;
import ex.repository.AccessoriesRepository;
import ex.repository.LensesRepository;
import ex.service.api.AccessoriesService;
import ex.service.api.LensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LensesServiceImpl implements LensesService{

    @Autowired
    LensesRepository lensesRepository;

    @Override
    public void add(Lens lens) {
        lensesRepository.save(lens);
    }
}
