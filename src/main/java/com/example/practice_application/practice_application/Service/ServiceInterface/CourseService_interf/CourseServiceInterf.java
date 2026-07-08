package com.example.practice_application.practice_application.Service.ServiceInterface.CourseService_interf;


import com.example.practice_application.practice_application.Model.CourseModel.CourseEntity;

import java.util.List;

public interface CourseServiceInterf {

    public String saveCourse(CourseEntity courseEntity);

    public CourseEntity getCourseById(String courseId);

    public List<CourseEntity> getAllCourse();

    public CourseEntity updateCourseById(CourseEntity courseEntity);

    public String deleteCourseById(String deleteCourseId);

}
