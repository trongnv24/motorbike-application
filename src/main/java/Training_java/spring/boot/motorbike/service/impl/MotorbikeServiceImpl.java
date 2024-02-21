package Training_java.spring.boot.motorbike.service.impl;

import Training_java.spring.boot.motorbike.dto.Request.MotorbikeRequest;
import Training_java.spring.boot.motorbike.dto.Response.MotorbikeResponse;
import Training_java.spring.boot.motorbike.entity.MotorbikeEntity;
import Training_java.spring.boot.motorbike.repository.MotorbikeRepository;
import Training_java.spring.boot.motorbike.service.MotorbikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
