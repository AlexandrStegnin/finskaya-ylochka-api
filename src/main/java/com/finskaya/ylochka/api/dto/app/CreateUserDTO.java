package com.finskaya.ylochka.api.dto.app;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

/**
 * @author Alexandr Stegnin
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserDTO {

  @NotBlank
  String phone;

}
