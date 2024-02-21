package Training_java.spring.boot.motorbike.service.mapping;


import Training_java.spring.boot.motorbike.dto.Request.MotorbikeRequest;
import Training_java.spring.boot.motorbike.dto.Response.MotorbikeResponse;
import Training_java.spring.boot.motorbike.entity.MotorbikeEntity;

public class MotorbikeMapping {
    public static MotorbikeEntity convertDtoToEntity( MotorbikeRequest dto){
          MotorbikeEntity entity = new MotorbikeEntity();
          entity.setName(dto.getName());
          entity.setBrand(dto.getBrand());
          entity.setColor(dto.getColor());
          entity.setModel(dto.getModel());
          entity.setYear(dto.getYear());
          return entity;
    }
    public static MotorbikeResponse convertEntityToMotorbikeResponse(MotorbikeEntity entity){
        MotorbikeResponse dto = new MotorbikeResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBrand(entity.getBrand());
        dto.setColor(entity.getColor());
        dto.setModel(entity.getModel());
        dto.setYear(entity.getYear());
        return dto;
    }
}
