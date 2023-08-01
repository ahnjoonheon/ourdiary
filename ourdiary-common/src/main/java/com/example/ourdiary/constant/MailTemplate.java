package com.example.ourdiary.constant;

import com.example.ourdiary.exception.IllegalTemplateParameterException;
import org.apache.commons.text.StringSubstitutor;

import java.util.Map;
import java.util.function.Function;

public enum MailTemplate {
    PASSWORD_RESET (
            param -> new StringSubstitutor(param).replace(
                    "안녕하세요. ${userName} 님 임시비밀번호 안내드립니다."
            ),
            param -> new StringSubstitutor(param).replace(
            """
            안녕하세요. ${userName} 님 임시비밀번호 안내드립니다.
            임시비밀번호는 ${initPassword} 입니다.
            감사합니다.
            """
            )
    ),
    USER_REGISTRATION (
            param -> new StringSubstitutor(param).replace(
                    "안녕하세요. ${userName} 님 회원가입을 축하드립니다."
            ),
            param -> new StringSubstitutor(param).replace(
                    """
                    안녕하세요. ${userName} 님 회원가입을 축하드립니다.
                    감사합니다.
                    """
            )
    );

    private final Function<Map<String, String>, String> subject;
    private final Function<Map<String, String>, String> contents;
    private Map<String, String> params;

    MailTemplate(Function<Map<String, String>, String> subject, Function<Map<String, String>, String> contents) {
        this.subject = subject;
        this.contents = contents;
    }

    public MailTemplate apply(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public String subject() {
        if (params == null) {
            throw new IllegalTemplateParameterException("params is null");
        }
        return subject.apply(params);
    }

    public String contents() {
        if (params == null) {
            throw new IllegalTemplateParameterException("params is null");
        }
        return contents.apply(params);
    }
}
