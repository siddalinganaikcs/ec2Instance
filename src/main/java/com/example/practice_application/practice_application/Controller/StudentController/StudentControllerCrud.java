package com.example.practice_application.practice_application.Controller.StudentController;

import com.example.practice_application.practice_application.Model.StudentModel.StudentEntity;
import com.example.practice_application.practice_application.Service.ServiceInterface.StudentService_interf.StudentServiceInterf;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Slf4j
@AllArgsConstructor
public class StudentControllerCrud {

    private final StudentServiceInterf studentServiceInterf;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(
            @RequestBody StudentEntity studentEntity) {
        System.out.println(studentEntity);

        String response = studentServiceInterf.saveStudent(studentEntity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/getStudentBy/{id}")
    public ResponseEntity<StudentEntity> getStudentById(
            @PathVariable("id") String id) {

        System.out.println(id );
        StudentEntity student = studentServiceInterf.getStudentById(id);

        return ResponseEntity.ok(student);
    }


    @GetMapping("/getAllStudent")
    public ResponseEntity<List<StudentEntity>> getAllStudents( @RequestParam(defaultValue = "0") int page ,
                                                               @RequestParam(defaultValue = "5") int size) {

        List<StudentEntity> students = studentServiceInterf.getAllStudent(page , size);

        return ResponseEntity.ok(students);
    }


    @PutMapping("/{studentId}")
    public ResponseEntity<StudentEntity> updateStudent(
            @PathVariable("studentId") String studentId,
            @RequestBody StudentEntity studentEntity) {

        studentEntity.setStudentId(studentId);

        StudentEntity updatedStudent = studentServiceInterf.updateStudentById(studentEntity);

        return ResponseEntity.ok(updatedStudent);
    }


    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable String studentId) {

        String response = studentServiceInterf.deleteStudentById(studentId);

        return ResponseEntity.ok(response);
    }


}
