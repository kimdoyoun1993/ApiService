package com.apiservice.controller;

import com.apiservice.model.ApiDTO;
import com.apiservice.model.DeviceDTO;
import com.apiservice.model.ListDTO;
import com.apiservice.model.ListResponseDTO;
import com.apiservice.service.DeviceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/device/")
@Log4j2
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;


    @ApiOperation("device Get list")
    @GetMapping("/list")
    public ListResponseDTO<DeviceDTO> list(ListDTO listDTO){


        log.info("Api list");

        log.info(listDTO);

        ListResponseDTO<DeviceDTO> responseDTO = deviceService.getList(listDTO);

        log.info("List Controller ");
        log.info(responseDTO);

        return responseDTO;

    }


    @ApiOperation("Device Post register")
    @PostMapping("/register")
    public ResponseEntity registerPost(@Validated DeviceDTO deviceDTO){
        log.info(deviceDTO);
        log.info("controller register");


        deviceService.register(deviceDTO , ApiDTO.builder()
                        .memberNumber(deviceDTO.getMemberNumber())
                        .build());

        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation("Device post delete")
    @PostMapping("/delete/{serviceNumber}")
    public ResponseEntity delete(@PathVariable("serviceNumber") Integer serviceNumber , DeviceDTO deviceDTO){
        log.info("-----------------------");
        log.info("delete");
        log.info("------------------");

        deviceService.delete(serviceNumber , deviceDTO);

        return new ResponseEntity(HttpStatus.OK);
    }
}
