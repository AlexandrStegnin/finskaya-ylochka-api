package com.finskaya.ylochka.api.dto.project;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDTO {

  Long projectId;
  String name;
  BigDecimal cost;
  BigDecimal invested;
  BigDecimal available;

}
