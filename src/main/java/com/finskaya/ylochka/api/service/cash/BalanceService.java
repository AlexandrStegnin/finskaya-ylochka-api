package com.finskaya.ylochka.api.service.cash;

import com.finskaya.ylochka.api.configuration.exception.ApiException;
import com.finskaya.ylochka.api.dto.money.BalanceDTO;
import com.finskaya.ylochka.api.dto.money.InvestmentDTO;
import com.finskaya.ylochka.api.mapper.InvestorInvestmentMapper;
import com.finskaya.ylochka.api.model.app.InvestorBalance;
import com.finskaya.ylochka.api.model.app.InvestorInvestment;
import com.finskaya.ylochka.api.model.app.Phone;
import com.finskaya.ylochka.api.repository.app.InvestorBalanceRepository;
import com.finskaya.ylochka.api.repository.app.InvestorInvestmentRepository;
import com.finskaya.ylochka.api.repository.app.PhoneRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

  InvestorInvestmentMapper investorInvestmentMapper;
  PhoneRepository phoneRepository;
  InvestorBalanceRepository investorBalanceRepository;
  InvestorInvestmentRepository investorInvestmentRepository;

  public BalanceDTO fetchInvestorBalance(String phoneNumber) {
    var phone = findPhone(phoneNumber);
    var investorBalance = investorBalanceRepository.findByInvestorId(phone.getInvestorId());
    var investorInvestments = investorInvestmentRepository.findByInvestorId(phone.getInvestorId());
    return mapToBalanceDTO(investorBalance, investorInvestments, phone);
  }

  private Phone findPhone(String phoneNumber) {
    var phone = phoneRepository.findByNumber(phoneNumber);
    if (Objects.isNull(phone)) {
      throw new ApiException("Телефон не найден", HttpStatus.NOT_FOUND);
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
