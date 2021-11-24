package com.finskaya.ylochka.api.controller.app;

import com.finskaya.ylochka.api.configuration.annotation.ValidToken;
import com.finskaya.ylochka.api.dto.money.BalanceDTO;
import com.finskaya.ylochka.api.service.cash.BalanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandr Stegnin
 */
@SuppressWarnings("unused")
@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/{token}/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "AppUser", description = "API для получении информации о балансе инвестора")
public class BalanceController {

  BalanceService balanceService;

  @GetMapping(path = "/{phone}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public BalanceDTO fetchBalance(@PathVariable(name = "token") @ValidToken String token,
                                 @PathVariable(name = "phone") String phone) {
    return balanceService.fetchInvestorBalance(phone);
  }

}
