package com.finskaya.ylochka.api.model.investor;

import com.finskaya.ylochka.api.model.app.Phone;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Immutable
@Table(name = "app_user")
public class InvestorEntity {

  @Id
  Long id;
  String login;
  @ManyToOne
  @JoinColumn(name = "app_user_id")
  Phone phone;

}
