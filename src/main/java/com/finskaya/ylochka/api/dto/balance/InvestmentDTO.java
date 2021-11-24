package com.finskaya.ylochka.api.dto.balance;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvestmentDTO {

  String project;
  BigDecimal sum;

}
