package com.monocept.demo.exception;


import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse>
            handleResourceNotFound(
                    ResourceNotFoundException ex) {

        logger.error(ex.getMessage());

        return ResponseEntity.status(
                HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        404,
                        "NOT FOUND",
                        ex.getMessage()));
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse>
            handleDuplicateResource(
                    DuplicateResourceException ex) {

        logger.error(ex.getMessage());

        return ResponseEntity.status(
                HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        409,
                        "CONFLICT",
                        ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>
            handleValidation(
                    MethodArgumentNotValidException ex) {

        List<String> errors =
                ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        logger.error("Validation failed");

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        400,
                        "VALIDATION ERROR",
                        errors));
    }

    @ExceptionHandler(
            MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse>
            handleTypeMismatch(
                    MethodArgumentTypeMismatchException ex) {

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        400,
                        "INVALID TYPE",
                        ex.getMessage()));
    }

    @ExceptionHandler(
            HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse>
            handleInvalidJson(
                    HttpMessageNotReadableException ex) {

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        400,
                        "INVALID JSON",
                        ex.getMessage()));
    }

    @ExceptionHandler(
            DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse>
            handleDataIntegrity(
                    DataIntegrityViolationException ex) {

        return ResponseEntity.status(
                HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        409,
                        "DATABASE ERROR",
                        ex.getMessage()));
    }

    @ExceptionHandler(
            AccessDeniedException.class)
    public ResponseEntity<ErrorResponse>
            handleAccessDenied(
                    AccessDeniedException ex) {

        return ResponseEntity.status(
                HttpStatus.FORBIDDEN)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        403,
                        "ACCESS DENIED",
                        ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>
            handleGeneric(Exception ex) {

        logger.error("Unexpected Error", ex);

        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        500,
                        "INTERNAL SERVER ERROR",
                        ex.getMessage()));
    }
}