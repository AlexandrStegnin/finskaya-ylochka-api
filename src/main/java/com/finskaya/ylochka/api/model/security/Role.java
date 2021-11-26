package com.finskaya.ylochka.api.model.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
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

  @GenericGenerator(
      name = "app_role_log_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(name = "sequence_name", value = "app_role_log_id_seq"),
          @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
          @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
      }
  )
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_role_log_generator")
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
