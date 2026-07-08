package com.example.practice_application.practice_application.Exception.StudentExceptions.ExceptionClass;


import com.example.practice_application.practice_application.enums.StudentEnum;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException( String message) {
        super(message);
    }

    public StudentNotFoundException( String message , Throwable causes) {
        super(message ,causes);
    }

    public StudentNotFoundException(StudentEnum studentEnum) {
        super(studentEnum.getMessage());
    }
}
