package com.finskaya.ylochka.api.dto.phone;

import com.finskaya.ylochka.api.dto.balance.InvestorDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author Alexandr Stegnin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhoneDTO {

  String phone;
  List<InvestorDTO> investors;

}
