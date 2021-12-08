package com.finskaya.ylochka.api.model.app;

import com.finskaya.ylochka.api.util.OwnerType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Alexandr Stegnin
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@EqualsAndHashCode(of = {"id", "accountNumber"})
public class Account {

  @GenericGenerator(
      name = "account_id_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(name = "sequence_name", value = "account_id_seq"),
          @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
          @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
      }
  )
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_generator")
  private Long id;

  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "owner_id")
  private Long ownerId;

  @Column(name = "owner_name")
  private String ownerName;

  @Enumerated(EnumType.STRING)
  @Column(name = "owner_type")
  private OwnerType ownerType;

}
