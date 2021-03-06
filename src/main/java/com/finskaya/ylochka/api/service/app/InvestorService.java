package com.finskaya.ylochka.api.service.app;

import com.finskaya.ylochka.api.configuration.exception.PhoneAlreadyExistsException;
import com.finskaya.ylochka.api.dto.app.CreateUserDTO;
import com.finskaya.ylochka.api.dto.balance.InvestorDTO;
import com.finskaya.ylochka.api.dto.phone.PhoneDTO;
import com.finskaya.ylochka.api.mapper.InvestorMapper;
import com.finskaya.ylochka.api.model.app.Investor;
import com.finskaya.ylochka.api.repository.app.InvestorRepository;
import com.finskaya.ylochka.api.service.phone.PhoneService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Alexandr Stegnin
 */
@Service
@Slf4j
@Validated
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InvestorService {

  InvestorMapper investorMapper;
  InvestorRepository investorRepository;
  AccountService accountService;
  PhoneService phoneService;

  public InvestorDTO create(@Valid CreateUserDTO dto) {
    checkPhoneNumber(dto);
    var investor = investorMapper.toEntity(dto);
    investor.setLogin("investor" + getNextInvestorCode());
    log.info("Create investor {}", investor);
    investorRepository.save(investor);
    createAccount(investor);
    savePhoneNumber(investor);
    return investorMapper.toDTO(investor);
  }

  private void checkPhoneNumber(CreateUserDTO dto) {
    var phoneDTO = phoneService.findInvestorsByPhoneNumber(dto.getPhone());
    var investor = investorRepository.findByPhone(dto.getPhone());
    if (Objects.nonNull(phoneDTO.getPhone()) || Objects.nonNull(investor)) {
      log.error("Phone already exists {}", dto.getPhone());
      throw new PhoneAlreadyExistsException("Phone already exists");
    }
  }

  private Integer getNextInvestorCode() {
    return investorRepository.selectLastInvestorNumber() + 1;
  }

  private void createAccount(Investor investor) {
    accountService.createAccount(investor);
  }

  private void savePhoneNumber(Investor investor) {
    var investorDTO = investorMapper.toDTO(investor);
    var phoneDTO = PhoneDTO.builder()
        .investors(Collections.singletonList(investorDTO))
        .phone(investor.getPhone())
        .build();
    phoneService.save(phoneDTO);
  }

}
