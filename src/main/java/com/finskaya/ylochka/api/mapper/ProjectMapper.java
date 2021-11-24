package com.finskaya.ylochka.api.mapper;

import com.finskaya.ylochka.api.configuration.mapper.MapStructConfig;
import com.finskaya.ylochka.api.dto.project.ProjectDTO;
import com.finskaya.ylochka.api.model.project.Project;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Alexandr Stegnin
 */
@Component
@Mapper(config = MapStructConfig.class)
public interface ProjectMapper {
  ProjectDTO toDTO(Project entity);
}
