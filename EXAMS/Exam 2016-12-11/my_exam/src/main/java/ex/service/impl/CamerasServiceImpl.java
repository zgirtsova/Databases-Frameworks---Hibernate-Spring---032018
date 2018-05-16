package ex.service.impl;

import ex.model.entities.BasicCamera;
import ex.repository.CamerasRepository;
import ex.service.api.CamerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CamerasServiceImpl implements CamerasService {

    @Autowired
    CamerasRepository camerasRepository;

    @Override
    public BasicCamera add(BasicCamera camera) {

        return camerasRepository.save(camera);
    }
}
