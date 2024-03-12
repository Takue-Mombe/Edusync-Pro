package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Services.AttendanceService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/qrcode")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping(value = "/generate/{content}/{additionalInfo}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQrCode(@PathVariable String content, @PathVariable String additionalInfo) throws IOException, WriterException {

        String fullContent = content + "/" + additionalInfo;
        BufferedImage image = attendanceService.generateQrCode(fullContent, 300, 300);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);

        return baos.toByteArray();
    }
}