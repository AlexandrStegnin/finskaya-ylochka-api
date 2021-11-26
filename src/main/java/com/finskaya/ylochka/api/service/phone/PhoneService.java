package com.finskaya.ylochka.api.service.phone;

import com.finskaya.ylochka.api.dto.phone.PhoneDTO;
import com.finskaya.ylochka.api.mapper.PhoneMapper;
import com.finskaya.ylochka.api.repository.app.PhoneRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Alexandr Stegnin
 */
@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PhoneService {

  PhoneMapper phoneMapper;
  PhoneRepository phoneRepository;

  public PhoneDTO findInvestorsByPhoneNumber(String phoneNumber) {
    var phones = phoneRepository.findByNumber(phoneNumber);
    return phoneMapper.toDTO(phones);
  }

}
