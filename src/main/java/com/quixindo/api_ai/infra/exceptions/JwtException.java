package com.quixindo.api_ai.infra.exceptions;

import com.auth0.jwt.exceptions.JWTCreationException;

public class JwtException extends JWTCreationException {
    public JwtException(String message, Throwable cause) {
        super(message, cause);
    }
}
