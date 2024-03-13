package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.QrCodeModel;
import com.Hit200.Lecturer.s.Companion.Services.QrService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class QrController {
        @Autowired
        private QrService qrCodeService;

        @GetMapping("/generate-qr-code")
        public QrCodeModel generateQRCode(@RequestBody QrCodeModel qrCode) {
            qrCodeService.validateQRCodeId(qrCode.getQrCodeId());
            return qrCodeService.generateQRCode(qrCode);
        }

        @GetMapping("/gen-qr")
        public BufferedImage generateQRCode_t( ) throws WriterException {

            return qrCodeService.generateQrCode_test();
        }
    }


