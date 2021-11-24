package com.finskaya.ylochka.api.controller.project;

import com.finskaya.ylochka.api.configuration.annotation.ValidToken;
import com.finskaya.ylochka.api.dto.project.ProjectDTO;
import com.finskaya.ylochka.api.service.project.ProjectService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alexandr Stegnin
 */
@SuppressWarnings("unused")
@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/{token}/projects")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectController {

  ProjectService projectService;

  @GetMapping(path = "/available")
  public List<ProjectDTO> fetchAvailableProjects(@Parameter(description = "ключ приложения")
                                                 @PathVariable(name = "token") @ValidToken String token) {
    return projectService.fetchAvailableProjects();
  }

}
