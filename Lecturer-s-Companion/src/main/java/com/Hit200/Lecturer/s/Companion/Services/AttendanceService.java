package com.Hit200.Lecturer.s.Companion.Services;

import com.Hit200.Lecturer.s.Companion.Models.Attendance;
import com.Hit200.Lecturer.s.Companion.Repositories.AttendanceRepository;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;
import java.awt.image.BufferedImage;
import java.io.Writer;
import java.util.List;

@Service
public class AttendanceService {

    private AttendanceRepository attendanceRepository;

    public BufferedImage generateQrCode(String content, int width, int height) throws WriterException {
        Writer writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height);
        return toBufferedImage(bitMatrix);
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
