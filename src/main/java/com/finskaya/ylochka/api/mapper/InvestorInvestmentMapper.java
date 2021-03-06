package com.finskaya.ylochka.api.mapper;

import com.finskaya.ylochka.api.configuration.mapper.MapStructConfig;
import com.finskaya.ylochka.api.dto.balance.InvestmentDTO;
import com.finskaya.ylochka.api.model.balance.InvestorInvestment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Alexandr Stegnin
 */
@Component
@Mapper(config = MapStructConfig.class)
public interface InvestorInvestmentMapper {

  InvestmentDTO toDTO(InvestorInvestment investment);

}
