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
public class PhoneNotFoundException extends RuntimeException {

  HttpStatus status;

  public PhoneNotFoundException(String message) {
    super(message);
    this.status = HttpStatus.NOT_FOUND;
  }

}
