package com.finskaya.ylochka.api.model.project;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Immutable
@Table(name = "investment_project")
public class Project {

  @Id
  String uuid;
  Long projectId;
  String name;
  BigDecimal cost;
  BigDecimal invested;
  BigDecimal available;

}
