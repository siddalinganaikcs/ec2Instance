package com.example.practice_application.practice_application.Service.ServiceImplementaion.CourseService_impl;

import com.example.practice_application.practice_application.Model.CourseModel.CourseEntity;
import com.example.practice_application.practice_application.Repository.CourseRepository.CourseRepo;
import com.example.practice_application.practice_application.Service.ServiceInterface.CourseService_interf.CourseServiceInterf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImple implements CourseServiceInterf {

    private final CourseRepo courseRepo;

    @Transactional
    @Override
    public String saveCourse(CourseEntity courseEntity) {
        courseRepo.save(courseEntity);
        return "Course successfully created";
    }

    @Override
    public CourseEntity getCourseById(String courseId) {
        return null;
    }

    @Override
    public List<CourseEntity> getAllCourse() {
        return List.of();
    }

    @Override
    public CourseEntity updateCourseById(CourseEntity courseEntity) {
        return null;
    }

    @Override
    public String deleteCourseById(String deleteCourseId) {
        return "";
    }
}
