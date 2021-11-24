package com.finskaya.ylochka.api.service.client;

import com.finskaya.ylochka.api.configuration.response.ApiResponse;
import com.finskaya.ylochka.api.dto.client.ClientDecisionDTO;
import com.finskaya.ylochka.api.mapper.ClientDecisionMapper;
import com.finskaya.ylochka.api.repository.client.ClientDecisionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexandr Stegnin
 */
@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientDecisionService {

  ClientDecisionMapper clientDecisionMapper;
  ClientDecisionRepository clientDecisionRepository;

  public List<ClientDecisionDTO> fetchDecisions() {
    return clientDecisionRepository.findAll().stream()
        .map(clientDecisionMapper::toDTO)
        .collect(Collectors.toList());
  }

  public ApiResponse create(ClientDecisionDTO dto) {
    var decision = clientDecisionMapper.toEntity(dto);
    clientDecisionRepository.save(decision);
    return ApiResponse.build200Response("Client decision successfully saved");
  }

}
