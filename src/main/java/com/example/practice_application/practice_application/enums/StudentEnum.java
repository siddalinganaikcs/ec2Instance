package com.example.practice_application.practice_application.enums;

import lombok.Getter;

@Getter
public enum StudentEnum {

    STUDENT_NOT_FOUND("400","Student not found please give valid user Id");


    private final String code;
    private final String message;

    StudentEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
