package com.Hit200.Lecturer.s.Companion.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "qrcodes")
public class QrCodeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String qrCodeId;
    private String courseId;
    private String lecturerName;
    private String studentsTaken;
    private String time;

    public String getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    // Getters and setters
}
