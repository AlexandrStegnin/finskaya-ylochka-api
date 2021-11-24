package com.finskaya.ylochka.api.dto.client;

import com.finskaya.ylochka.api.util.Decision;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDecisionDTO {

  @NotNull
  Long investorId;
  @NotNull
  Decision decision;
  Long projectId;
  @NotNull
  BigDecimal sum;

}
