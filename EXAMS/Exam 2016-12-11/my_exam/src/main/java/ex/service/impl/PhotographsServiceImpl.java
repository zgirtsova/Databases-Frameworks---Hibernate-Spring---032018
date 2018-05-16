package ex.service.impl;

import ex.model.dto.PhotographersImportJsonDto;
import ex.model.entities.BasicCamera;
import ex.model.entities.Lens;
import ex.model.entities.Photographer;
import ex.parser.api.ModelParser;
import ex.repository.AccessoriesRepository;
import ex.repository.CamerasRepository;
import ex.repository.LensesRepository;
import ex.repository.PhotographersRepository;
import ex.service.api.PhotographersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


@Service
@Transactional
public class PhotographsServiceImpl implements PhotographersService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private PhotographersRepository photographerRepository;

    @Autowired
    private LensesRepository lenRepository;

    @Autowired
    private CamerasRepository basicCameraRepository;

    @Autowired
    private AccessoriesRepository accessoryRepository;

    @Override
    public int create(PhotographersImportJsonDto photographerDto) {
        Photographer photographer = this.modelParser.convert(photographerDto, Photographer.class);
        Set<Lens> lenses = this.lenRepository.findByIdIn(photographerDto.getLensSet());
        BasicCamera primaryCamera = this.getRandomCamera();
        photographer.setPrimaryCamera(primaryCamera);
        BasicCamera secondaryCamera = this.getRandomCamera();
        photographer.setSecondaryCamera(secondaryCamera);
        for (Lens lens : lenses) {
            lens.setOwner(photographer);
        }
        this.photographerRepository.saveAndFlush(photographer);

        return lenses.size();
    }

//    @Override
//    public List<PhotographerExportJSONDto> findAllOrder() {
//        List<Photographer> photographers = this.photographerRepository.findAllOrder();
//        List<PhotographerExportJSONDto> photographerExportJSONDtos = new ArrayList<>();
//        for (Photographer photographer : photographers) {
//            PhotographerExportJSONDto photographerExportJSONDto = this.modelParser.convert(photographer, PhotographerExportJSONDto.class);
//            photographerExportJSONDtos.add(photographerExportJSONDto);
//        }
//
//        return photographerExportJSONDtos;
//    }
//
//    @Override
//    public List<PhotographerLandscapeExportJSONDto> findAllWithLenses() {
//        List<Photographer> photographers = this.photographerRepository.findAllWithLenses();
//        List<PhotographerLandscapeExportJSONDto> photographerLandscapeExportJSONDtos = new ArrayList<>();
//        for (Photographer photographer : photographers) {
//            if (photographer.getPrimaryCamera() instanceof DSLRCamera) {
//                PhotographerLandscapeExportJSONDto photographerLandscapeExportJSONDto = this.modelParser.convert(photographer, PhotographerLandscapeExportJSONDto.class);
//                photographerLandscapeExportJSONDto.setCount(photographer.getLenses().size());
//                photographerLandscapeExportJSONDtos.add(photographerLandscapeExportJSONDto);
//            }
//        }
//
//        return photographerLandscapeExportJSONDtos;
//    }
//
//    @Override
//    public PhotographersCameraExportXML findAllWithCameras() {
//        List<Photographer> photographers = this.photographerRepository.findAllWithCameras();
//        List<PhotographerCameraExportXML> photographerCameraExportXMLs = new ArrayList<>();
//        for (Photographer photographer : photographers) {
//            PhotographerCameraExportXML photographerCameraExportXML = this.modelParser.convert(photographer, PhotographerCameraExportXML.class);
//            photographerCameraExportXMLs.add(photographerCameraExportXML);
//        }
//
//        PhotographersCameraExportXML photographersCameraExportXML = new PhotographersCameraExportXML();
//        photographersCameraExportXML.setPhotographers(photographerCameraExportXMLs);
//        return photographersCameraExportXML;
//    }

    private BasicCamera getRandomCamera() {
        long cameraCount = this.basicCameraRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, cameraCount + 1);
        BasicCamera basicCamera = basicCameraRepository.findFirstById(randomId);
        return basicCamera;
    }
}