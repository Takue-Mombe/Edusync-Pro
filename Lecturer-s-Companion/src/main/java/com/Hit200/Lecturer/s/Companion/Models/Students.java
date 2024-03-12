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
@Entity(name = "students")
public class Students {

    @Id
    private String regNumber;
    private String firstName;
    private String lastName;
    private String programme;
    private String department;
    private String coursesTaking;


}
