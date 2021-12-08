package com.finskaya.ylochka.api.service.balance;

import com.finskaya.ylochka.api.configuration.exception.PhoneNotFoundException;
import com.finskaya.ylochka.api.dto.balance.BalanceDTO;
import com.finskaya.ylochka.api.dto.balance.InvestmentDTO;
import com.finskaya.ylochka.api.mapper.InvestorInvestmentMapper;
import com.finskaya.ylochka.api.model.balance.InvestorBalance;
import com.finskaya.ylochka.api.model.balance.InvestorInvestment;
import com.finskaya.ylochka.api.model.app.Phone;
import com.finskaya.ylochka.api.repository.balance.InvestorBalanceRepository;
import com.finskaya.ylochka.api.repository.balance.InvestorInvestmentRepository;
import com.finskaya.ylochka.api.repository.app.PhoneRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Alexandr Stegnin
 */
@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BalanceService {

  private static final String PHONE_NOT_FOUND_MESSAGE = "Phone not found";

  InvestorInvestmentMapper investorInvestmentMapper;
  PhoneRepository phoneRepository;
  InvestorBalanceRepository investorBalanceRepository;
  InvestorInvestmentRepository investorInvestmentRepository;

  public BalanceDTO fetchInvestorBalance(Long investorId) {
    var phone = findPhone(investorId);
    log.info("Fetch investor balance by phone {}", phone.getNumber());
    var investorBalance = investorBalanceRepository.findByInvestorId(investorId);
    var investorInvestments = investorInvestmentRepository.findByInvestorId(investorId);
    return mapToBalanceDTO(investorBalance, investorInvestments, phone);
  }

  public BalanceDTO fetchInvestorBalance(String phoneNumber) {
    var phone = findPhone(phoneNumber);
    log.info("Fetch investor balance by phone {}", phoneNumber);
    var investorBalance = investorBalanceRepository.findByInvestorId(phone.getInvestorId());
    var investorInvestments = investorInvestmentRepository.findByInvestorId(phone.getInvestorId());
    return mapToBalanceDTO(investorBalance, investorInvestments, phone);
  }

  private Phone findPhone(String phoneNumber) {
    var phone = phoneRepository.findByNumber(phoneNumber);
    if (Objects.isNull(phone) || phone.isEmpty()) {
      log.error("Phone not found {}", phoneNumber);
      throw new PhoneNotFoundException(PHONE_NOT_FOUND_MESSAGE);
    }
    return phone.get(0);
  }

  private Phone findPhone(Long investorId) {
    var phone = phoneRepository.findByInvestorId(investorId);
    if (Objects.isNull(phone)) {
      log.error(PHONE_NOT_FOUND_MESSAGE);
      throw new PhoneNotFoundException(PHONE_NOT_FOUND_MESSAGE);
    }
    return phone;
  }

  private BalanceDTO mapToBalanceDTO(InvestorBalance balance, List<InvestorInvestment> investments, Phone phone) {
    return BalanceDTO.builder()
        .phone(phone.getNumber())
        .investorId(balance.getInvestorId())
        .accountNumber(balance.getAccountNumber())
        .freeCash(balance.getFreeCash())
        .investments(mapToInvestmentDTO(investments))
        .build();
  }

  private List<InvestmentDTO> mapToInvestmentDTO(List<InvestorInvestment> investments) {
    return investments.stream()
        .map(investorInvestmentMapper::toDTO)
        .collect(Collectors.toList());
  }

}
