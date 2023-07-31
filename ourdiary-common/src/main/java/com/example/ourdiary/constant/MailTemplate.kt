package com.example.ourdiary.constant

enum class MailTemplate {
    PASSWORD_RESET {
        override fun subject(userName: String): String =
            "안녕하세요. $userName 님 임시비밀번호 안내드립니다."

        override fun contents(userName: String, initPassword: String): String = """
            안녕하세요. $userName 님 임시비밀번호 안내드립니다.
            임시비밀번호는 $initPassword 입니다.
            감사합니다.
        """.trimIndent()
    };

    abstract fun subject(userName: String): String
    abstract fun contents(userName: String, initPassword: String): String
}