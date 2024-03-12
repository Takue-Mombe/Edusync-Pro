package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.Attendance;
import com.Hit200.Lecturer.s.Companion.Services.AttendanceService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/generate")
    public BufferedImage generateQrCode(@RequestParam String content, @RequestParam int width, @RequestParam int height) {
        try {
            BufferedImage qrCodeImage = attendanceService.generateQrCode(content, width, height);

            return qrCodeImage;
        } catch (WriterException e) {
            return null;
        }}

    @PostMapping("/save")
    public ResponseEntity<Attendance> saveAttendance(@Valid @RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAttendance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> allAttendances = attendanceService.getAllAttendances();
        return ResponseEntity.ok(allAttendances);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @Valid @RequestBody Attendance updatedAttendance) {
        Attendance updated = attendanceService.updateAttendance(id, updatedAttendance);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
