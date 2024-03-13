package com.Hit200.Lecturer.s.Companion.Repositories;

import com.Hit200.Lecturer.s.Companion.Models.QrCodeModel;
import com.google.zxing.qrcode.encoder.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRcodeRepo extends JpaRepository<QrCodeModel,Long> {
    QrCodeModel findByQrCodeId(String qrCodeId);
}
