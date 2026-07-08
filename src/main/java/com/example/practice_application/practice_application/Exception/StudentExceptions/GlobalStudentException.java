package com.example.practice_application.practice_application.Exception.StudentExceptions;

import com.example.practice_application.practice_application.Exception.StudentExceptions.ExceptionClass.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalStudentException {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String , Object>> userNotFoundException(StudentNotFoundException message){

        Map<String , Object> set= new HashMap<>();
        set.put("timeStamp", LocalDateTime.now());
        set.put("message",message.getMessage());
        set.put("StatusCode", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(set , HttpStatus.NOT_FOUND);
    }



}
