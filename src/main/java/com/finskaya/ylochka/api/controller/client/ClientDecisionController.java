package com.finskaya.ylochka.api.controller.client;

import com.finskaya.ylochka.api.configuration.annotation.ValidToken;
import com.finskaya.ylochka.api.configuration.response.ApiResponse;
import com.finskaya.ylochka.api.dto.client.ClientDecisionDTO;
import com.finskaya.ylochka.api.service.client.ClientDecisionService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Alexandr Stegnin
 */
@SuppressWarnings("unused")
@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/{token}/decisions")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientDecisionController {

  ClientDecisionService clientDecisionService;

  @GetMapping
  public List<ClientDecisionDTO> fetchDecisions(@Parameter(description = "ключ приложения")
                                                @PathVariable(name = "token") @ValidToken String token) {
    return clientDecisionService.fetchDecisions();
  }

  @PostMapping
  public ApiResponse create(@Parameter(description = "ключ приложения")
                            @PathVariable(name = "token") @ValidToken String token,
                            @Valid @RequestBody ClientDecisionDTO dto) {
    return clientDecisionService.create(dto);
  }

}
