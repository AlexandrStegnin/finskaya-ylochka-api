package com.finskaya.ylochka.api.model.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import static com.finskaya.ylochka.api.util.Constant.ROLE_PREFIX;

/**
 * @author Alexandr Stegnin
 */

@Data
@Entity
@Table(name = "app_role", schema = "investments", catalog = "investments")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_role_log_generator")
  @SequenceGenerator(name = "app_role_log_generator", sequenceName = "app_role_log_id_seq")
  private Long id;

  @Column(name = "name")
  private String name;

  @Override
  public String getAuthority() {
    return name.startsWith(ROLE_PREFIX) ? name : ROLE_PREFIX + name;
  }

  @PrePersist
  public void setRole() {
    if (!name.trim().toUpperCase().startsWith(ROLE_PREFIX)) name = ROLE_PREFIX + name.trim().toUpperCase();
    else name = name.trim().toUpperCase();
  }

  public Role(GrantedAuthority authority) {
    this.name = authority.getAuthority();
  }
}
