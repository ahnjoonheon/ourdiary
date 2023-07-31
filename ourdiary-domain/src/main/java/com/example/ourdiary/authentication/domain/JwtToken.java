package com.example.ourdiary.authentication.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class JwtToken {

    private String token;
    
    protected JwtToken(String token) {
        this.token = token;
    }

    public String stringify() {
        return token;
    }

    // create null token
    public static JwtToken nullToken() {
        return new JwtToken(null);
    }
    public static JwtToken create(String token) {
        return new JwtToken(token);
    }

    // validate null
    public boolean isNotNull() {
        return token != null;
    }

    public boolean isNull() {
        return token == null;
    }

    public String getToken() {
        return token;
    }

    // jpa converter
    @Converter
    public static class JwtTokenConverter implements AttributeConverter<JwtToken, String> {
        @Override
        public String convertToDatabaseColumn(JwtToken attribute) {
            if (attribute.isNull()) {
                return null;
            }
            return attribute.stringify();
        }

        @Override
        public JwtToken convertToEntityAttribute(String dbData) {
            if (dbData == null) {
                return JwtToken.nullToken();
            }
            return new JwtToken(dbData);
        }
    }
}
