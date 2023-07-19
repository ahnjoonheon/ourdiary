package com.example.ourdiary.configuration.audit;

import com.example.ourdiary.member.repository.MemberRepository;
import com.example.ourdiary.message.MessageService;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<Long> {

    private final MemberRepository memberRepository;
    private final MessageService messageService;

    public AuditorAwareImpl(MemberRepository memberRepository, MessageService messageService) {
        this.memberRepository = memberRepository;
        this.messageService = messageService;
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return Optional.empty();
        }
        Object principal = authentication.getPrincipal();
        if(principal instanceof String) {
            return Optional.empty();
        }
        String email = ((User) principal).getUsername();
        return Optional.of(
                memberRepository.findByEmail(email).orElseThrow(
                        () -> new UsernameNotFoundException(messageService.get("exception.email-not-found", email))).getId()
        );
    }
}
