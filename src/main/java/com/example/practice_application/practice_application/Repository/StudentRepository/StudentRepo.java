package com.example.practice_application.practice_application.Repository.StudentRepository;

import com.example.practice_application.practice_application.Model.StudentModel.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity , String>{

//    public void saveStudent(StudentEntity studentEntity);
//
//    public StudentEntity getStudentById(String studentId);
//
//    public List<StudentEntity> getAllStudent();
//
//    public StudentEntity updateStudentById(String updateStudentByid);
//
//    public void deleteStudentById(String deleteStudentById);
}
