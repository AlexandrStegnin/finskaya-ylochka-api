package com.finskaya.ylochka.api.dto.balance;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Alexandr Stegnin
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvestorDTO {

  Long id;
  String login;

}
