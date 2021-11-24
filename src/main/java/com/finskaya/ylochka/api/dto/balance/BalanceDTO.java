package com.finskaya.ylochka.api.dto.balance;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Alexandr Stegnin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BalanceDTO {

  String phone;
  Long investorId;
  String accountNumber;
  BigDecimal freeCash;
  List<InvestmentDTO> investments;

}
