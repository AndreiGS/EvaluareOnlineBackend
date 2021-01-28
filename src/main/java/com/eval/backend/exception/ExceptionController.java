package com.eval.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = CannotFindTestException.class)
    public ResponseEntity<Object> exception (CannotFindTestException exception) {
        return new ResponseEntity<>("Cannot find test with specified id", HttpStatus.BAD_REQUEST);
    }


}
