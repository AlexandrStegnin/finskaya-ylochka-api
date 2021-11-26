package com.finskaya.ylochka.api.controller.investor;

import com.finskaya.ylochka.api.configuration.annotation.ValidToken;
import com.finskaya.ylochka.api.dto.phone.PhoneDTO;
import com.finskaya.ylochka.api.service.phone.PhoneService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/v1/{token}/investors")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InvestorController {

  PhoneService phoneService;

  @GetMapping(path = "/{phone}")
  public PhoneDTO fetchInvestorsByPhone(@Parameter(description = "ключ приложения")
                                      @PathVariable(name = "token") @ValidToken String token,
                                        @Parameter(description = "телефон клиента")
                                      @PathVariable(name = "phone") String phone) {
    return phoneService.findInvestorsByPhoneNumber(phone);
  }
}
