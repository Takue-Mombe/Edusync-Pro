package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.QrCodeModel;
import com.Hit200.Lecturer.s.Companion.Services.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class QrController {
        @Autowired
        private QrService qrCodeService;

        @PostMapping("/generate-qr-code")
        public QrCodeModel generateQRCode(@RequestBody QrCodeModel qrCode) {
            qrCodeService.validateQRCodeId(qrCode.getQrCodeId());
            return qrCodeService.generateQRCode(qrCode);
        }
    }


