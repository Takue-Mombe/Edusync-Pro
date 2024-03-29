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
@Entity(name = "lecturers")
public class Lecturers {

    @Id
    private String lecturerCode;
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String department;
    private String coursesTeaching;

}
