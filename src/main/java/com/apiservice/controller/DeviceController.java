package com.apiservice.controller;

import com.apiservice.model.DeviceDTO;
import com.apiservice.service.DeviceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device/")
@Log4j2
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @ApiOperation("Device Post register")
    @PostMapping("/register")
    public ResponseEntity registerPost(DeviceDTO deviceDTO){
        log.info(deviceDTO);
        log.info("controller register");


        deviceService.register(deviceDTO);

        return new ResponseEntity(HttpStatus.OK);
    }
}
