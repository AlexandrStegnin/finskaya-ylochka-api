package com.finskaya.ylochka.api.mapper;

import com.finskaya.ylochka.api.configuration.mapper.MapStructConfig;
import com.finskaya.ylochka.api.dto.client.ClientDecisionDTO;
import com.finskaya.ylochka.api.model.client.ClientDecision;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Alexandr Stegnin
 */
@Component
@Mapper(config = MapStructConfig.class)
public interface ClientDecisionMapper {

  ClientDecisionDTO toDTO(ClientDecision entity);
  ClientDecision toEntity(ClientDecisionDTO dto);

}
