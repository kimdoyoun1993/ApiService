package com.apiservice.controller.Handler;

import com.apiservice.model.Error.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;

import static com.apiservice.model.Error.ErrorCode.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler({ BindException.class})
    protected ResponseEntity handleBindException(BindException ex) {

        FieldError fieldError = ex.getFieldError();

        String message = fieldError.getDefaultMessage();
        String param = fieldError.getField();

        message = message + "(" + param + ")";

        log.debug(" message : {}", message);
        log.debug(" param   : {}", param);

        return new ResponseEntity(new ErrorDTO( BAD_REQUEST.getStatus(), message + " " + BAD_REQUEST.getMessage()+ ":" + param), HttpStatus.valueOf(BAD_REQUEST.getStatus()));
    }





    @ExceptionHandler({ Exception.class })
    protected ResponseEntity handleServerException(Exception ex) {

        ex.printStackTrace();

        return new ResponseEntity(new ErrorDTO(SYS_ERR.getStatus(), SYS_ERR.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({CustomException.class})
    protected ResponseEntity handleCustomException(CustomException ex){

        ex.getMessage();

        return new ResponseEntity(new ErrorDTO(ex.getErrorCode().getStatus() , ex.getErrorCode().getMessage()),HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }




}
