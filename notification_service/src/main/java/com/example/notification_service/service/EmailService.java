package com.example.notification_service.service;

public interface EmailService {
    void sendMessage(String to, String subject, String text);
}
