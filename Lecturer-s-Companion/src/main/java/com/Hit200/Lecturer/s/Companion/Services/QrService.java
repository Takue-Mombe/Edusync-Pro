package com.Hit200.Lecturer.s.Companion.Services;


import com.Hit200.Lecturer.s.Companion.Models.QrCodeModel;
import com.Hit200.Lecturer.s.Companion.Repositories.QRcodeRepo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.UUID;

import static com.google.zxing.client.j2se.MatrixToImageWriter.toBufferedImage;

//@Service
//public class QrCodeGeneratorService {
//    public BufferedImage generateQrCode(String content, int width, int height) throws WriterException {
//        Writer writer = new QRCodeWriter();
//        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height);
//        return toBufferedImage(bitMatrix);
//    }
//
//    private static BufferedImage toBufferedImage(BitMatrix matrix) {
//        int width = matrix.getWidth();
//        int height = matrix.getHeight();
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        for (int x = 0; x < width; x++) {
//            for (int y = 0; y < height; y++) {
//                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
//            }
//        }
//        return image;
//    }
//}


    @Service
    public class QrService {

        @Autowired
       private QRcodeRepo qRcodeRepo;



        public BufferedImage generateQrCode_test() throws WriterException {

            String content = "123";
            int width = 250;
            int height =250;

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


        public QrCodeModel generateQRCode(QrCodeModel qrCode) {
            String qrCodeId = UUID.randomUUID().toString();
            while (qRcodeRepo.findByQrCodeId(qrCodeId) != null) {
                qrCodeId = UUID.randomUUID().toString();
            }
            qrCode.setQrCodeId(qrCodeId);
            return qRcodeRepo.save(qrCode);
        }

        public void validateQRCodeId(String qrCodeId) {
            QrCodeModel qrCode = qRcodeRepo.findByQrCodeId(qrCodeId);
            if (qrCode != null) {
                throw new IllegalArgumentException("QR code with the same ID already exists");
            }
        }
    }


