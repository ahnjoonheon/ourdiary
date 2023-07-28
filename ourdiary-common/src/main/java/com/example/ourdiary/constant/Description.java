package com.example.ourdiary.constant;

public class Description {

    private Description() {
        throw new IllegalStateException("Utility class");
    }

    public static final String API_AUTH_LOGIN = """
                            **successful operation**<br/>
                            `Access Token`, `Refresh Token`을 발행합니다.<br/>
                            `Access Token`은 `Header`에<br/>
                            `Refresh Token`은 `Cookie`의 `refresh-token`으로 전달됩니다.
                            """;
}
