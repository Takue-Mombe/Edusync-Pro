package com.Hit200.Lecturer.s.Companion.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column
    public String StudentsTaken;
    @Column
    private int qrCodeNumber;
    @Column
    private int courseId;
    @Column
    private String lecturerCode;

}