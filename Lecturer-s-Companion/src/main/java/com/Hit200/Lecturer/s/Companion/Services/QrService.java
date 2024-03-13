package com.Hit200.Lecturer.s.Companion.Services;


import com.Hit200.Lecturer.s.Companion.Models.QrCodeModel;
import com.Hit200.Lecturer.s.Companion.Repositories.QRcodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

    @Service
    public class QrService {

        @Autowired
       private QRcodeRepo qRcodeRepo;

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


