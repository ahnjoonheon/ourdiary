package com.example.ourdiary.notification.service;

import com.example.ourdiary.constant.MailTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(String to, MailTemplate.MailTemplateInstance mailTemplateInstance) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(mailTemplateInstance.subject());
        message.setText(mailTemplateInstance.contents());
        javaMailSender.send(message);
    }
}
