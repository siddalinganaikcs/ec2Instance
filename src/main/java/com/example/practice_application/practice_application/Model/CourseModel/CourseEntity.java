package com.example.practice_application.practice_application.Model.CourseModel;

import com.example.practice_application.practice_application.Model.StudentModel.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;


    private String trainerName;

    @Column(nullable = false)
    private Double fee;

    @ManyToMany(mappedBy = "courseEntity")
    private Set<StudentEntity> studentEntity =new HashSet<>();

    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", fee=" + fee +
                ", studentEntity=" + studentEntity +
                '}';
    }
}
