package com.example.ourdiary.member.event;

import com.example.ourdiary.member.domain.PasswordResetEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordResetEventListener {
    @EventListener
    public void handlePasswordResetEvent(PasswordResetEvent event) {
        log.info("Sending reset password email to " + event.email());
        log.info("Your new password is: " + event.initPassword());
    }
}
