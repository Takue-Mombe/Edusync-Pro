package com.Hit200.Lecturer.s.Companion.Models;


import jakarta.persistence.Column;
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
    @Column
    private String courseName; @Column
    private String Lecturer; @Column
    private String programme; @Column
    private String department; @Column
    private String NumberOfStudents;

}
