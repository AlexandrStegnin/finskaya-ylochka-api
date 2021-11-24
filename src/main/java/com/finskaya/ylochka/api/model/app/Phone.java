package com.finskaya.ylochka.api.model.app;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Table(name = "phone")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_generator")
  @SequenceGenerator(name = "phone_generator", sequenceName = "phone_id_seq")
  Long id;

  String number;

  @Column(name = "app_user_id")
  Long investorId;

}
