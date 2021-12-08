package com.finskaya.ylochka.api.mapper;

import com.finskaya.ylochka.api.dto.balance.InvestorDTO;
import com.finskaya.ylochka.api.dto.phone.PhoneDTO;
import com.finskaya.ylochka.api.model.app.Phone;
import com.finskaya.ylochka.api.repository.investor.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexandr Stegnin
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PhoneMapper {

  UserMapper userMapper;
  UserRepository userRepository;

  public PhoneDTO toDTO(List<Phone> entities) {
    return PhoneDTO.builder()
        .phone(mapPhone(entities))
        .investors(mapInvestors(entities))
        .build();
  }

  private String mapPhone(List<Phone> entities) {
    return entities.stream()
        .findFirst()
        .map(Phone::getNumber)
        .orElse(null);
  }

  private List<InvestorDTO> mapInvestors(List<Phone> entities) {
    return entities.stream()
        .map(phone -> userRepository.getById(phone.getInvestorId()))
        .map(userMapper::toInvestorDTO)
        .collect(Collectors.toList());
  }

}
