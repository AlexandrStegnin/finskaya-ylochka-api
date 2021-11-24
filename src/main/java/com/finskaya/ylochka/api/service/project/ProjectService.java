package com.finskaya.ylochka.api.service.project;

import com.finskaya.ylochka.api.dto.project.ProjectDTO;
import com.finskaya.ylochka.api.mapper.ProjectMapper;
import com.finskaya.ylochka.api.repository.project.ProjectRepository;
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
public class ProjectService {

  ProjectMapper projectMapper;
  ProjectRepository projectRepository;

  public List<ProjectDTO> fetchAvailableProjects() {
    return projectRepository.findAll().stream()
        .map(projectMapper::toDTO)
        .collect(Collectors.toList());
  }

}
