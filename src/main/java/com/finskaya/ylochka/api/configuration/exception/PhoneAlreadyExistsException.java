package com.finskaya.ylochka.api.configuration.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

/**
 * @author Alexandr Stegnin
 */
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PhoneAlreadyExistsException extends RuntimeException {

  HttpStatus status;

  public PhoneAlreadyExistsException(String message) {
    super(message);
    this.status = HttpStatus.BAD_REQUEST;
  }

}
