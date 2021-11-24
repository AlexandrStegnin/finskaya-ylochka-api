package com.finskaya.ylochka.api.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Alexandr Stegnin
 */
@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Decision {

  @JsonProperty("Реинвестирование")
  REINVEST("Реинвестирование"),
  @JsonProperty("Вывод")
  WITHDRAWING("Вывод"),
  @JsonProperty("Пополнение")
  DEPOSIT("Пополнение");

  String value;

}
