package com.Hit200.Lecturer.s.Companion.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course")
public class Courses {

    @Id
    private String courseId;
    private String courseName;
    private String Lecturer;
    private String programme;
    private String department;
    private String NumberOfStudents;

}