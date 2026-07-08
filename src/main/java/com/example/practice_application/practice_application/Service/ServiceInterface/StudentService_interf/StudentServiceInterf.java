package com.example.practice_application.practice_application.Service.ServiceInterface.StudentService_interf;

import com.example.practice_application.practice_application.Model.StudentModel.StudentEntity;

import java.util.List;

public interface StudentServiceInterf {

    public String saveStudent(StudentEntity studentEntity);

    public StudentEntity getStudentById(String studentId);

    public  List<StudentEntity> getAllStudent(int page , int size);

    public StudentEntity updateStudentById(StudentEntity studentEntity);

    public String deleteStudentById(String deleteStudentId);
}
