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
@Entity(name = "courseMarks")
public class CourseMarks {

    @Id
    private String courseId;
    @Column
    private String regNumber;
    @Column
    private String lecturerCode;
    @Column
    private AssessmentType assessmentType;
    @Column
    private double marks;

}

