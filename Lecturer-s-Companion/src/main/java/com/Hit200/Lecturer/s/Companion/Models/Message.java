package com.Hit200.Lecturer.s.Companion.Models;

import jakarta.persistence.Column;
import lombok.*;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class Message {
    @Column
    private String senderName;
    @Column
    private String receiverName;
    @Column
    private String message;
    @Column
    private String date;
    @Column
    private Status status;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

