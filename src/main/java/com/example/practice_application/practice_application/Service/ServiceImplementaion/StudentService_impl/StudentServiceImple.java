package com.example.practice_application.practice_application.Service.ServiceImplementaion.StudentService_impl;

import com.example.practice_application.practice_application.Exception.StudentExceptions.ExceptionClass.StudentNotFoundException;
import com.example.practice_application.practice_application.Exception.StudentExceptions.GlobalStudentException;
import com.example.practice_application.practice_application.Model.StudentModel.StudentEntity;
import com.example.practice_application.practice_application.Repository.StudentRepository.StudentRepo;
import com.example.practice_application.practice_application.Service.ServiceInterface.StudentService_interf.StudentServiceInterf;
import com.example.practice_application.practice_application.enums.StudentEnum;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@AllArgsConstructor
public class StudentServiceImple implements StudentServiceInterf {

    private final StudentRepo studentRepo;
    private final GlobalStudentException studentException;


    @Transactional
    @Override
    public String saveStudent(StudentEntity studentEntity) {

        studentRepo.save(studentEntity);

        return "Student Saved Successfully";
    }

    @Override
    public StudentEntity getStudentById(String studentId) {

        return studentRepo.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                StudentEnum.STUDENT_NOT_FOUND));

    }

    @Override
    public List<StudentEntity> getAllStudent(int page , int size) {


        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by("studentFirstName")
                                .ascending());

        Page<StudentEntity> studentPage =
                studentRepo.findAll(pageable);

        if(studentPage.isEmpty()){
            throw new StudentNotFoundException(StudentEnum.STUDENT_NOT_FOUND);
        }

        return studentPage.getContent();
    }

    @Transactional
    @Override
    public StudentEntity updateStudentById(StudentEntity studentEntity) {

        StudentEntity existingStudent =
                studentRepo.findById(studentEntity.getStudentId())
                        .orElseThrow(()-> new StudentNotFoundException(StudentEnum.STUDENT_NOT_FOUND));


        existingStudent.setStudentFirstName(studentEntity.getStudentFirstName());
        existingStudent.setStudentEmail(studentEntity.getStudentEmail());
        existingStudent.setStudentAge(studentEntity.getStudentAge());

        return studentRepo.save(existingStudent);
    }

    @Transactional
    @Override
    public String deleteStudentById(String deleteStudentId) {

        StudentEntity student =
                studentRepo.findById(deleteStudentId)
                        .orElseThrow(() ->
                                 new StudentNotFoundException(StudentEnum.STUDENT_NOT_FOUND));

        studentRepo.delete(student);

        return "Student Deleted Successfully";
    }
}