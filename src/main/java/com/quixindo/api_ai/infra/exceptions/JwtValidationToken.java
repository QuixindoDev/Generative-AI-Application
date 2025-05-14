package com.quixindo.api_ai.infra.exceptions;

import com.auth0.jwt.exceptions.JWTCreationException;

public class JwtValidationToken extends JWTCreationException {
    public JwtValidationToken(String message, Throwable cause) {
        super(message, cause);
    }
}
