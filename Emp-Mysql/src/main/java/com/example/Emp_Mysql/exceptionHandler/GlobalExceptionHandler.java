package com.example.Emp_Mysql.exceptionHandler;

import com.example.Emp_Mysql.exception.pfException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value= pfException.class)
    public ResponseEntity<pfException> handlepf(){
        pfException pf = new pfException("pf Amount can not updated manually");
        return new ResponseEntity<pfException>(pf,HttpStatus.NOT_ACCEPTABLE);
    }

}