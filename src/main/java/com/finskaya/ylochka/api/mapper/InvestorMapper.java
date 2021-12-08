package com.finskaya.ylochka.api.mapper;

import com.finskaya.ylochka.api.configuration.mapper.MapStructConfig;
import com.finskaya.ylochka.api.dto.app.CreateUserDTO;
import com.finskaya.ylochka.api.dto.balance.InvestorDTO;
import com.finskaya.ylochka.api.model.app.Investor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Alexandr Stegnin
 */
@Component
@Mapper(config = MapStructConfig.class)
public abstract class InvestorMapper {

  BCryptPasswordEncoder encoder;

  @Autowired
  public void setEncoder(BCryptPasswordEncoder encoder) {
    this.encoder = encoder;
  }

  @Mapping(target = "login", source = "phone")
  @Mapping(target = "password", expression = "java(generatePassword())")
  public abstract Investor toEntity(CreateUserDTO dto);

  public abstract InvestorDTO toDTO(Investor entity);

  protected String generatePassword() {
    return encoder.encode(UUID.randomUUID().toString().substring(0, 8));
  }

}
