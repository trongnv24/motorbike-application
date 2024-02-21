package Training_java.spring.boot.motorbike.service;

import Training_java.spring.boot.motorbike.dto.Request.MotorbikeRequest;
import Training_java.spring.boot.motorbike.dto.Response.MotorbikeResponse;

public interface MotorbikeService {

    MotorbikeResponse create(MotorbikeRequest request);

    MotorbikeResponse getById(String id);

    MotorbikeResponse update(MotorbikeRequest request, String id);
}
