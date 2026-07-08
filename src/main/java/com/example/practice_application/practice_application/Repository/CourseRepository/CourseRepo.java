package com.example.practice_application.practice_application.Repository.CourseRepository;

import com.example.practice_application.practice_application.Model.CourseModel.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity , String> {

//    public Object saveCourse(CourseEntity CoursetEntity);
//
//    @Query(value = "select * from Course where CourseId = : CourseId" ,nativeQuery = true)
//    public CourseEntity getCourseById(@Param("CourseId") String CourseId);
//
//    @Query("select c from Course c")
//    public  CourseEntity getAll();
//
//    public CourseEntity updateCourseById(CourseEntity courseEntity);
//
//    public CourseEntity deleteCourseById(String deleteById);
}
