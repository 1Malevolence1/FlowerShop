package com.example.businesslogic.exeption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {


    @ExceptionHandler(BindException.class)
    public ResponseEntity<ProblemDetail> handlerBindException(BindException bindException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Некоректные данные");
        problemDetail.setProperty("errors",bindException.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList());
        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ProblemDetail> handlerBindException(DataIntegrityViolationException dataIntegrityViolationException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "ошибка sql");
        problemDetail.setProperty("errors", dataIntegrityViolationException.getMessage());
        return ResponseEntity.internalServerError().body(problemDetail);
    }
}
