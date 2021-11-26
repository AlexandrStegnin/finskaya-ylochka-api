package com.finskaya.ylochka.api.model.client;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Table(name = "client_decision")
public class ClientDecision {

  @GenericGenerator(
      name = "client_decision_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(name = "sequence_name", value = "client_decision_id_seq"),
          @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
          @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
      }
  )
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_decision_generator")
  Long id;
  @Column(name = "investor_id")
  Long investorId;
  String decision;
  @Column(name = "project_id")
  Long projectId;
  BigDecimal sum;
  
}
