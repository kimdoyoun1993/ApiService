package com.apiservice.controller;

import com.apiservice.model.ApiDTO;
import com.apiservice.model.ListDTO;
import com.apiservice.model.ListResponseDTO;
import com.apiservice.service.ApiService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
@Log4j2
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @ApiOperation("Api Get list")
    @GetMapping("/list")
    public ListResponseDTO<ApiDTO> list(ListDTO listDTO){


        log.info("Api list");

        log.info(listDTO);

        ListResponseDTO<ApiDTO> responseDTO = apiService.getList(listDTO);

        log.info("List Controller ");
        log.info(responseDTO);

        return responseDTO;

    }


    @ApiOperation("Api Post register")
    @PostMapping("/register")
    public ResponseEntity registerPost(@Validated(ApiDTO.insertGroup.class) ApiDTO apiDTO){
        log.info(apiDTO);
        log.info("controller register");


        apiService.register(apiDTO);

        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation("api post update")
    @PostMapping("/update/{memberNumber}")
    public ResponseEntity update(@PathVariable("memberNumber") String memberNumber , @Validated(ApiDTO.updateGroup.class) ApiDTO apiDTO){

        log.info("-----------------------");
        log.info("update");
        log.info("------------------");
        apiService.update(apiDTO);


        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation("api post delete")
    @PostMapping("/delete/{memberNumber}")
    public ResponseEntity delete(@PathVariable("memberNumber") Integer memberNumber){
        log.info("-----------------------");
        log.info("delete");
        log.info("------------------");

        apiService.delete(memberNumber);

        return new ResponseEntity(HttpStatus.OK);
    }
    

}
