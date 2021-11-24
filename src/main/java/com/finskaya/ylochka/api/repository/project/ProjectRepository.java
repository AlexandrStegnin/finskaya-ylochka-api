package com.finskaya.ylochka.api.repository.project;

import com.finskaya.ylochka.api.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
