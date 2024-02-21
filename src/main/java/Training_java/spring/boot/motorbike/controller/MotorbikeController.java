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
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MotorbikeResponse getById(@PathVariable("id") String id){
        log.info(" === Start api getById motorbike === ");
        log.info(" === String id {} : === ", id);
        MotorbikeResponse response = service.getById(id);
        log.info(" === Finish api getById motorbike, MotorbikeId Id {} : === ", response.getId());
        return response;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MotorbikeResponse update(@RequestBody MotorbikeRequest request, @PathVariable("id") String id){
        log.info(" === Start api update motorbike === ");
        log.info(" === Request Body {} :, String id {} : === ", request,id);
        MotorbikeResponse response = service.update(request,id);
        log.info(" === Finish api update motorbike, Motorbike Id === ", response.getId());
        return response;
    }
}
