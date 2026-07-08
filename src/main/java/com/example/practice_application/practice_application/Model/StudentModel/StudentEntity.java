package com.example.practice_application.practice_application.Model.StudentModel;

import com.example.practice_application.practice_application.Model.CourseModel.CourseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String studentId ;

    @Column(name="First_Name",nullable = false)
    private String studentFirstName;

    @Column(name="Last_Name",nullable = false)
    private String studentLastName;

    @Column(name="Age",nullable = false)
    private int  studentAge;

    @Column(name="Email",nullable = false)
    private String studentEmail;

    @CreationTimestamp
    @Column(name = "JoiningDate")
    private LocalDateTime studentJoiningDate;

    @CreationTimestamp
    @Column(name="EndDate")
    private LocalDateTime studentEendDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name ="student_course",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name="courseId")
    )
   private Set<CourseEntity> courseEntity = new HashSet<>();

    @Override
    public String toString() {
        return "StudentEntiry{" +
                "studentId='" + studentId + '\'' +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentAge=" + studentAge +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentJoiningDate=" + studentJoiningDate +
                ", studentEendDate=" + studentEendDate +
                ", courseEntity=" + courseEntity +
                '}';
    }
}
