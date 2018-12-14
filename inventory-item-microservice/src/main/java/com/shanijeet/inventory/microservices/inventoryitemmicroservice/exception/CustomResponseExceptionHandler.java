package com.shanijeet.inventory.microservices.inventoryitemmicroservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public final ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException ex, WebRequest request) throws Exception {

       ExceptionResponse er= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
        return new ResponseEntity(er,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public final ResponseEntity<Object> handleItemNotFoundException(ItemAlreadyExistsException ex, WebRequest request) throws Exception {

        ExceptionResponse er= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        er.setMessage("Record Already Exists for Item "+ ex.getMessage().substring(7));
        return new ResponseEntity(er,HttpStatus.BAD_REQUEST);

    }
}
