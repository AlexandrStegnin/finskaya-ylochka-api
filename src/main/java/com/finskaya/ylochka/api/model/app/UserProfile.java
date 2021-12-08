package com.finskaya.ylochka.api.model.app;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * @author Alexandr Stegnin
 */

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_profile")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfile {

  @Id
  Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  @MapsId
  Investor user;

  public UserProfile(Investor user) {
    this.user = user;
  }

}
