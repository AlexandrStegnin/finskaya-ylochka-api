package com.finskaya.ylochka.api.util;

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
public enum OwnerType {

  UNDEFINED(0, "Не определён"),
  INVESTOR(1, "Инвестор"),
  FACILITY(2, "Объект"),
  UNDER_FACILITY(3, "Подобъект"),
  ROOM(4, "Помещение");

  int id;
  String title;

}
