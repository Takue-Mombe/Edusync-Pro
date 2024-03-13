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
@Entity(name = "students")
public class Students {

    @Id
    private String regNumber;
    @Column
    private String firstName; @Column
    private String lastName; @Column
    private String programme; @Column
    private String department; @Column
    private String coursesTaking;


}
