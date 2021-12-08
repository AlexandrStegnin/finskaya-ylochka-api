package com.finskaya.ylochka.api.model.app;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Table(name = "app_user")
@ToString(exclude = {"password", "profile"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Investor {

  @GenericGenerator(
      name = "investor_id_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(name = "sequence_name", value = "app_user_id_seq"),
          @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
          @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
      }
  )
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investor_id_generator")
  Long id;
  String login;
  String phone;
  String password;
  @Column(name = "role_id")
  Long roleId = 2L;
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  UserProfile profile = new UserProfile(this);

}
