package com.Hit200.Lecturer.s.Companion.Services;

import com.Hit200.Lecturer.s.Companion.Models.Attendance;
import com.Hit200.Lecturer.s.Companion.Repositories.AttendanceRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }


    public BufferedImage generateQrCode(String content, int width, int height) throws WriterException {
        Writer writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height);
        return toBufferedImage(bitMatrix);
    }


    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }


    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }


    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            attendance.setStudentsTaken(updatedAttendance.getStudentsTaken());
            attendance.setQrCodeNumber(updatedAttendance.getQrCodeNumber());
            attendance.setCourseId(updatedAttendance.getCourseId());
            attendance.setLecturerCode(updatedAttendance.getLecturerCode());
            return attendanceRepository.save(attendance);
        } else {
            throw new IllegalArgumentException("Attendance record with ID " + id + " not found.");
        }
    }


    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }
}
