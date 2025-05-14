package com.quixindo.api_ai.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<RestErrorMessage> buildErrorResponse(HttpStatus status, String message){
        RestErrorMessage threatError = new RestErrorMessage(status, message, new Date());
        return ResponseEntity.status(status).body(threatError);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<RestErrorMessage> handleEmailAlreadyExists(EmailAlreadyExistsException emailAlreadyExistsException){
        String message = emailAlreadyExistsException.getMessage();
        return buildErrorResponse(HttpStatus.CONFLICT, message);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        String message = userNotFoundException.getMessage();
        return buildErrorResponse(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<RestErrorMessage> handleJwtException(JwtException jwtException){
        String message = jwtException.getMessage();
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    @ExceptionHandler(JwtValidationToken.class)
    public ResponseEntity<RestErrorMessage> handleJwtException(JwtValidationToken jwtValidationToken){
        String message = jwtValidationToken.getMessage();
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, message);
    }

    @ExceptionHandler({
            UsernameNotFoundException.class,
            BadCredentialsException.class,
            InvalidUserException.class
    })
    public ResponseEntity<RestErrorMessage> handleAuthenticationException(AuthenticationException ex){
        String message = "Invalid User";
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorMessage> handleGenericException(Exception exception){
        String message = exception.getMessage();
        return buildErrorResponse(HttpStatus.BAD_REQUEST, message);
    }
}
