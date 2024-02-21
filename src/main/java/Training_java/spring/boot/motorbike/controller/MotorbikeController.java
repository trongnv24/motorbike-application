package Training_java.spring.boot.motorbike.controller;

import Training_java.spring.boot.motorbike.dto.Request.MotorbikeRequest;
import Training_java.spring.boot.motorbike.dto.Response.MotorbikeResponse;
import Training_java.spring.boot.motorbike.service.MotorbikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/motorbikes")
@Slf4j
public class MotorbikeController {
    private final MotorbikeService service;


    public MotorbikeController(MotorbikeService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotorbikeResponse create(@RequestBody MotorbikeRequest request) {
        log.info(" === Start api create new motorbike === ");
        log.info(" === Request Body : {} === ", request);
        MotorbikeResponse response = service.create(request);
        log.info(" === Finish api create new motorbike, Motorbike Id : {} === ", response.getId());
       return response;
    }
}
