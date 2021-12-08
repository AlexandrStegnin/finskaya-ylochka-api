package com.finskaya.ylochka.api.mapper;

import com.finskaya.ylochka.api.configuration.mapper.MapStructConfig;
import com.finskaya.ylochka.api.dto.balance.InvestorDTO;
import com.finskaya.ylochka.api.model.security.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Alexandr Stegnin
 */
@Component
@Mapper(config = MapStructConfig.class)
public interface UserMapper {

  InvestorDTO toInvestorDTO(User entity);

}
