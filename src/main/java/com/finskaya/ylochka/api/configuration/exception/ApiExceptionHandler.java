package com.finskaya.ylochka.api.configuration.exception;

import com.finskaya.ylochka.api.configuration.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.finskaya.ylochka.api.util.Constant.INVALID_APP_TOKEN;

/**
 * @author Alexandr Stegnin
 */

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

  private static final String DATABASE_ERROR = "Ошибка базы данных: {}";

  @ExceptionHandler({ApiException.class})
  protected ResponseEntity<ApiResponse> handleApiException(ApiException ex) {
    return new ResponseEntity<>(new ApiResponse(ex.getMessage(), ex.getStatus(), Instant.now()), ex.getStatus());
  }

  @ExceptionHandler(PhoneNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected ResponseEntity<ApiResponse> handlePhoneNotFoundException(PhoneNotFoundException ex) {
    return new ResponseEntity<>(new ApiResponse(ex.getMessage(), ex.getStatus(), Instant.now()), ex.getStatus());
  }

  @ExceptionHandler(PhoneAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  protected ResponseEntity<ApiResponse> handlePhoneAlreadyExistsException(PhoneAlreadyExistsException ex) {
    return new ResponseEntity<>(new ApiResponse(ex.getMessage(), ex.getStatus(), Instant.now()), ex.getStatus());
  }

  @ExceptionHandler
  public ResponseEntity<ApiResponse> handle(ConstraintViolationException exception) {
    String errorMessage = new ArrayList<>(exception.getConstraintViolations())
        .stream()
        .map(ConstraintViolation::getMessage)
        .collect(Collectors.joining("; "));
    HttpStatus status;
    if (errorMessage.equalsIgnoreCase(INVALID_APP_TOKEN)) {
      status = HttpStatus.FORBIDDEN;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }
    ApiResponse apiErrorResponse = new ApiResponse(errorMessage, status, Instant.now());
    return new ResponseEntity<>(apiErrorResponse, status);
  }

  @ExceptionHandler
  public ResponseEntity<ApiResponse> handle(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult().getFieldErrors()
        .stream()
        .collect(Collectors.toMap(FieldError::getField, Objects.requireNonNull(FieldError::getDefaultMessage)))
        .entrySet()
        .stream()
        .map(entrySet -> entrySet.getKey() + ": " + entrySet.getValue()).
        collect(Collectors.joining(",\n"));
    ApiResponse apiErrorResponse = new ApiResponse(message, HttpStatus.BAD_REQUEST, Instant.now());
    return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler
  public void handle(RequestRejectedException e) {
    log.warn("Запрос отклонён: {}", e.getLocalizedMessage());
  }

  @ExceptionHandler
  public void handle(IllegalArgumentException e) {
    log.warn("Произошла ошибка: {}", e.getLocalizedMessage());
  }

  @ExceptionHandler({SQLSyntaxErrorException.class, InvalidDataAccessResourceUsageException.class, SQLGrammarException.class})
  public void handle(InvalidDataAccessResourceUsageException e) {
    log.warn(DATABASE_ERROR, e.getLocalizedMessage());
  }

  @ExceptionHandler({
      org.springframework.web.HttpRequestMethodNotSupportedException.class,
      org.springframework.web.HttpMediaTypeNotAcceptableException.class
  })
  public void handle(HttpRequestMethodNotSupportedException e) {
    log.warn("Неподдерживаемый метод: {}", e.getLocalizedMessage());
  }

  @ExceptionHandler
  public void handle(org.hibernate.exception.ConstraintViolationException exception) {
    log.error(DATABASE_ERROR, exception.getSQLException().getLocalizedMessage());
  }

  @ExceptionHandler
  public void handle(org.hibernate.HibernateException exception) {
    log.error(DATABASE_ERROR, exception.getLocalizedMessage());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiResponse> handle(HttpMessageNotReadableException e) {
    log.error("Произошла ошибка {}", e.getLocalizedMessage());
    return new ResponseEntity<>(ApiResponse.build400Response(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
  }

}
