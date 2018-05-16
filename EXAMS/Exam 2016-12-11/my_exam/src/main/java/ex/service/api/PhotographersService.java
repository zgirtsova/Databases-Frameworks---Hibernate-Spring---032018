package ex.service.api;

import ex.model.dto.PhotographersImportJsonDto;
import ex.model.entities.Photographer;

import java.util.List;

public interface PhotographersService {

    int create(PhotographersImportJsonDto photographerDto);

//    List<PhotographersImportJsonDto> findAllOrder();
//
//    List<PhotographersImportJsonDto> findAllWithLenses();
//
//    PhotographersImportJsonDto findAllWithCameras();

}
