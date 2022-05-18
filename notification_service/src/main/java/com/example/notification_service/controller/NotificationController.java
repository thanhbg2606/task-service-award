package com.example.notification_service.controller;

import com.example.notification_service.model.ResultDetail;
import com.example.notification_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public void sendMail(@RequestBody ResultDetail resultDetail){
        String subject = "CHÚC MỪNG BẠN ĐÃ TRÚNG THƯỞNG";
        String contentText = "Khách hàng " + resultDetail.getCustomer().getName() +" " +
                "đã trúng thưởng vói mã code: " + resultDetail.getResult().getCode();
        emailService.sendMessage(resultDetail.getCustomer().getEmail(), subject, contentText);
    }
}
