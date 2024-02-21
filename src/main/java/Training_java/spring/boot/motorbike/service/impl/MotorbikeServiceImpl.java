package Training_java.spring.boot.motorbike.service.impl;

import Training_java.spring.boot.motorbike.dto.Request.MotorbikeRequest;
import Training_java.spring.boot.motorbike.dto.Response.MotorbikeResponse;
import Training_java.spring.boot.motorbike.entity.MotorbikeEntity;
import Training_java.spring.boot.motorbike.repository.MotorbikeRepository;
import Training_java.spring.boot.motorbike.service.MotorbikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static Training_java.spring.boot.motorbike.service.mapping.MotorbikeMapping.convertDtoToEntity;
import static Training_java.spring.boot.motorbike.service.mapping.MotorbikeMapping.convertEntityToMotorbikeResponse;

@Service
@Slf4j
public class MotorbikeServiceImpl implements MotorbikeService {
    private final MotorbikeRepository motorbikeRepository;

    public MotorbikeServiceImpl(MotorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }

    @Override
    public MotorbikeResponse create(MotorbikeRequest request) {
        log.info(" === Start api create new motorbike === ");
        log.info(" === Request Body {} : === ", request);
        MotorbikeEntity motorbikeEntity = convertDtoToEntity(request);
        motorbikeEntity= motorbikeRepository.save(motorbikeEntity);
        MotorbikeResponse response = convertEntityToMotorbikeResponse(motorbikeEntity);
        log.info(" === Finish api create new motorbike, Motorbike Id {} : === ", response.getId());
        return response;
    }

    @Override
    public MotorbikeResponse getById(String id) {
        log.info( " === Start api getById motorbike === ");
        log.info(" === String id {} :  === ", id);
        Optional<MotorbikeEntity> optionalMotorbike = motorbikeRepository.findById(id);
        if(!optionalMotorbike.isPresent()){
            throw new RuntimeException();
        }
        MotorbikeEntity motorbikeEntity = optionalMotorbike.get();
        MotorbikeResponse response = convertEntityToMotorbikeResponse(motorbikeEntity);
        log.info(" === Finish api getById motorbike, Motorbike Id {} : ===", response.getId());
        return response;
    }

    @Override
    public MotorbikeResponse update(MotorbikeRequest request, String id) {
        log.info(" === Start api update Motorbike === ");
        log.info(" === Request Body {} :, String id {} : === ", request, id);
        Optional<MotorbikeEntity>optionalMotorbike = motorbikeRepository.findById(id);
        if ( !optionalMotorbike.isPresent()){
            throw new RuntimeException();
        }
        MotorbikeEntity motorbikeEntity = optionalMotorbike.get();
        motorbikeEntity.setName(request.getName());
        motorbikeEntity.setYear(request.getYear());
        motorbikeEntity.setModel(request.getModel());
        motorbikeEntity.setColor(request.getColor());
        motorbikeEntity.setBrand(request.getBrand());
        motorbikeEntity = motorbikeRepository.save(motorbikeEntity);
        MotorbikeResponse response = convertEntityToMotorbikeResponse(motorbikeEntity);
        log.info(" === Finish api update motorbike, Motorbike Id", response.getId());
        return response;
    }
}
