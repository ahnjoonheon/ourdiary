package com.example.ourdiary.member.event;

import com.example.ourdiary.constant.MailTemplate;
import com.example.ourdiary.member.domain.PasswordResetEvent;
import com.example.ourdiary.notification.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetEventListener {
    private final EmailService emailService;

    public PasswordResetEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    public void handlePasswordResetEvent(PasswordResetEvent event) {
        MailTemplate.PASSWORD_RESET.contents(event.userName(), event.initPassword());
        emailService.send(
                event.email(),
                MailTemplate.PASSWORD_RESET.subject(event.userName()),
                MailTemplate.PASSWORD_RESET.contents(event.userName(), event.initPassword()));
    }
}
