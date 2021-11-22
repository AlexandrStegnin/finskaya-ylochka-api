package com.ddkolesnik.ddkapi.configuration.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * @author Alexandr Stegnin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse {

  String message;
  HttpStatus status;
  Instant timestamp;

  public static ApiResponse build200Response(String message) {
    return new ApiResponse(message, HttpStatus.OK, Instant.now());
  }

}
