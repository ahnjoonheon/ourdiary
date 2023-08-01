package com.example.ourdiary.member.event;

import com.example.ourdiary.constant.MailTemplate;
import com.example.ourdiary.member.domain.PasswordResetEvent;
import com.example.ourdiary.notification.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PasswordResetEventListener {
    private final EmailService emailService;

    public PasswordResetEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    public void handlePasswordResetEvent(PasswordResetEvent event) {
        emailService.send(event.email(), MailTemplate.PASSWORD_RESET.apply(Map.of(
                "userName", event.userName(),
                "initPassword", event.initPassword()
        )));
    }
}
