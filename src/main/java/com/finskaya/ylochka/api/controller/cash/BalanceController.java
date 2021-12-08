package com.finskaya.ylochka.api.controller.cash;

import com.finskaya.ylochka.api.configuration.annotation.ValidToken;
import com.finskaya.ylochka.api.dto.balance.BalanceDTO;
import com.finskaya.ylochka.api.service.balance.BalanceService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandr Stegnin
 */
@SuppressWarnings("unused")
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BalanceController {

  BalanceService balanceService;

  @GetMapping(path = "/api/v2/{token}/users/{investorId}")
  public BalanceDTO fetchBalance(@Parameter(description = "ключ приложения")
                                 @PathVariable(name = "token") @ValidToken String token,
                                 @Parameter(description = "id клиента")
                                 @PathVariable(name = "investorId") Long investorId) {
    return balanceService.fetchInvestorBalance(investorId);
  }

  @GetMapping(path = "/api/v1/{token}/users/{phone}")
  public BalanceDTO fetchBalanceV1(@Parameter(description = "ключ приложения")
                                   @PathVariable(name = "token") @ValidToken String token,
                                   @Parameter(description = "телефон клиента")
                                   @PathVariable(name = "phone") String phone) {
    return balanceService.fetchInvestorBalance(phone);
  }

}
