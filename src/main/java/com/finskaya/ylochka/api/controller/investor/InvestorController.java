package com.finskaya.ylochka.api.controller.investor;

import com.finskaya.ylochka.api.configuration.annotation.ValidToken;
import com.finskaya.ylochka.api.dto.app.CreateUserDTO;
import com.finskaya.ylochka.api.dto.balance.InvestorDTO;
import com.finskaya.ylochka.api.dto.phone.PhoneDTO;
import com.finskaya.ylochka.api.service.app.InvestorService;
import com.finskaya.ylochka.api.service.phone.PhoneService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
  InvestorService investorService;

  @GetMapping(path = "/{phone}")
  public PhoneDTO fetchInvestorsByPhone(@Parameter(description = "ключ приложения")
                                        @PathVariable(name = "token") @ValidToken String token,
                                        @Parameter(description = "телефон клиента")
                                        @PathVariable(name = "phone") String phone) {
    return phoneService.findInvestorsByPhoneNumber(phone);
  }

  @PostMapping
  public InvestorDTO createInvestor(@Parameter(description = "ключ приложения")
                                    @PathVariable(name = "token") @ValidToken String token,
                                    @RequestBody CreateUserDTO dto) {
    return investorService.create(dto);
  }

}
