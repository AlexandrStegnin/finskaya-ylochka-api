package com.finskaya.ylochka.api.model.app;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Table(name = "phone")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone {

  @GenericGenerator(
      name = "phone_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(name = "sequence_name", value = "phone_id_seq"),
          @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
          @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
      }
  )
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_generator")
  Long id;

  String number;

  @Column(name = "app_user_id")
  Long investorId;

}
