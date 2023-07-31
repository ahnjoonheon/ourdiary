package com.example.ourdiary.constant;


public class Description {

    private Description() {
        throw new IllegalStateException("Constant class");
    }

    public static final String API_AUTH_LOGIN = """
                            `Access Token`, `Refresh Token`을 발행합니다.<br/>
                            `Access Token`은 `Header`에<br/>
                            `Refresh Token`은 `Cookie`의 `refresh-token`으로 전달됩니다.
                            """;

    public static final String API_AUTH_LOGOUT = """
                            `Access Token`, `Refresh Token`을 만료시킵니다.<br/>
                            **Client**에서는 기존 `Access Token`을 제거해주시면 됩니다.<br/>
                            `Refresh Token`은 서버에서 처리하게 됩니다.
                            """;

    public static final String API_AUTH_REFRESH_TOKEN = """
                            `Refresh Token`을 이용하여 `Access Token`,`Refresh Token`을 갱신합니다.<br/>
                            `Access Token`은 `Header`에<br/>
                            `Refresh Token`은 `Cookie`의 `refresh-token`으로 전달됩니다.
                            """;

    public static final String API_AUTH_RESET_PASSWORD = """
                            **successful operation**<br/>
                            `Refresh Token`을 이용하여 `Access Token`,`Refresh Token`을 갱신합니다.<br/>
                            `Access Token`은 `Header`에<br/>
                            `Refresh Token`은 `Cookie`의 `refresh-token`으로 전달됩니다.
                            """;
}
