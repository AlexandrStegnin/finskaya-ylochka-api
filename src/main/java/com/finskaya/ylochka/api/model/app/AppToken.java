package com.finskaya.ylochka.api.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Модель для хранения информации о ключах приложения
 * Ключ нужен для авторизации в API
 *
 * @author Alexandr Stegnin
 */

@Data
@Entity
@Table(name = "app_token")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppToken {

  @GenericGenerator(
      name = "app_token_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(name = "sequence_name", value = "app_token_id_seq"),
          @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
          @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
      }
  )
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_token_generator")
  Long id;

  @Column(name = "app_name")
  String name;

  @Column(name = "token")
  String token;

  @JsonIgnore
  @CreationTimestamp
  @Column(name = "creation_time")
  LocalDate creationTime;

  @JsonIgnore
  @UpdateTimestamp
  @Column(name = "modified_time")
  LocalDate modifiedTime;

}
